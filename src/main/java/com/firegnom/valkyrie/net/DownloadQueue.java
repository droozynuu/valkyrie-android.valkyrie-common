/*******************************************************************************
 * Copyright (c) 2010 Maciej Kaniewski (mk@firegnom.com).
 * 
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 3 of the License, or
 *    (at your option) any later version.
 * 
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 * 
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software Foundation,
 *    Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 * 
 *    Contributors:
 *     Maciej Kaniewski (mk@firegnom.com) - initial API and implementation
 ******************************************************************************/
package com.firegnom.valkyrie.net;

import java.net.URL;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class DownloadQueue.
 */
public class DownloadQueue extends Thread {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(DownloadQueue.class
			.getName());

	/** The downloads. */
	LinkedBlockingQueue<URL> downloads;

	/** The path. */
	String path;

	/** The overwrite. */
	boolean overwrite;

	/** The o. */
	Observer o = null;

	/**
	 * Instantiates a new download queue.
	 * 
	 * @param path
	 *            the path
	 * @param overwrite
	 *            the overwrite
	 */
	public DownloadQueue(final String path, final boolean overwrite) {
		logger.info("DownloadQueue created");
		this.overwrite = overwrite;
		this.path = path;
		downloads = new LinkedBlockingQueue<URL>();
		this.start();
	}

	/**
	 * Adds the.
	 * 
	 * @param url
	 *            the url
	 */
	public void add(final URL url) {
		if (!downloads.contains(url)) {
			downloads.add(url);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			URL file;
			try {
				file = downloads.take();
			} catch (final InterruptedException e) {
				e.printStackTrace();
				return;
			}
			Download d;
			if (o == null) {
				d = new Download(file, path, overwrite);
			} else {
				d = new Download(file, path, overwrite, o);
			}
			d.download();
		}
	}

	/**
	 * Size.
	 * 
	 * @return the int
	 */
	public int size() {
		return downloads.size();
	}

	/**
	 * Use observer.
	 * 
	 * @param o
	 *            the o
	 */
	public void useObserver(final Observer o) {
		this.o = o;
	}

}
