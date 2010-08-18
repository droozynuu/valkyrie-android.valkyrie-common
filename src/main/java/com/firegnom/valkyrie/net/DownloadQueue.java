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
	 * @param path the path
	 * @param overwrite the overwrite
	 */
	public DownloadQueue(String path, boolean overwrite) {
		logger.info("DownloadQueue created");
		this.overwrite = overwrite;
		this.path = path;
		downloads = new LinkedBlockingQueue<URL>();
		this.start();
	}

	/**
	 * Adds the.
	 *
	 * @param url the url
	 */
	public void add(URL url) {
		if (!downloads.contains(url)) {
			downloads.add(url);
		}
	}

	/**
	 * Use observer.
	 *
	 * @param o the o
	 */
	public void useObserver(Observer o) {
		this.o = o;
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return downloads.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			URL file;
			try {
				file = downloads.take();
			} catch (InterruptedException e) {
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

}
