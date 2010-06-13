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
package com.firegnom.valkyrie.util;

/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

// TODO: Auto-generated Javadoc
/**
 * Utility class to perform zip/unzip operations on files and directories.
 * 
 */
public class ZipUtil {

	/**
	 * Process path.
	 * 
	 * @param path
	 *            the path
	 * @param stripPath
	 *            the strip path
	 * @param pathSeparator
	 *            the path separator
	 * @return the string
	 */
	private static String processPath(final String path,
			final String stripPath, final char pathSeparator) {
		if (!path.startsWith(stripPath)) {
			throw new IllegalArgumentException("Invalid entry: " + path
					+ "; expected to start with " + stripPath);
		}

		return path.substring(stripPath.length()).replace(File.separatorChar,
				pathSeparator);
	}

	/**
	 * Unpacks a zip file to the target directory.
	 * 
	 * @param zipFile
	 *            the zip file
	 * @param destDir
	 *            the dest dir
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void unzip(final File zipFile, final File destDir)
			throws IOException {
		final ZipFile zip = new ZipFile(zipFile);
		try {
			final Enumeration<? extends ZipEntry> en = zip.entries();
			final int bufSize = 8 * 1024;
			final byte[] buf = new byte[bufSize];
			while (true) {
				ZipEntry entry;
				try {
					entry = en.nextElement();
				} catch (final NoSuchElementException e) {
					break;
				}

				final File file = (destDir != null) ? new File(destDir,
						entry.getName()) : new File(entry.getName());

				if (entry.isDirectory()) {
					if (!file.mkdirs()) {
						throw new IOException("Error creating directory: "
								+ file);
					}
				} else {
					final File parent = file.getParentFile();
					if (parent != null && !parent.exists()) {
						if (!parent.mkdirs()) {
							throw new IOException("Error creating directory: "
									+ parent);
						}
					}

					final InputStream in = zip.getInputStream(entry);
					try {
						final OutputStream out = new FileOutputStream(file);

						try {
							Util.copyPipe(in, out, buf);
						} finally {
							out.close();
						}

					} finally {
						in.close();
					}
				}
			}
		} finally {
			zip.close();
		}
	}

	/**
	 * Recursively zips a set of root entries into a zipfile, compressing the
	 * contents.
	 * 
	 * @param zipFile
	 *            target zip file.
	 * @param parentDir
	 *            a directory containing source files to zip.
	 * @param sources
	 *            an array of files and/or directories to zip.
	 * @param pathSeparator
	 *            path separator for zip entries.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void zip(final File zipFile, final File parentDir,
			final File[] sources, final char pathSeparator) throws IOException {

		String stripPath = (parentDir != null) ? parentDir.getPath() : "";
		if (stripPath.length() > 0 && !stripPath.endsWith(File.separator)) {
			stripPath += File.separator;
		}

		final ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFile));
		out.setMethod(ZipOutputStream.DEFLATED);

		try {
			// something like an Ant directory scanner wouldn't hurt here
			for (final File source : sources) {
				if (!source.exists()) {
					throw new IllegalArgumentException(
							"File or directory does not exist: " + source);
				}

				if (source.isDirectory()) {
					zipDirectory(out, stripPath, source, pathSeparator);
				} else {
					zipFile(out, stripPath, source, pathSeparator);
				}
			}
		} finally {
			out.close();
		}
	}

	/**
	 * Uses code fragments from Jakarta-Ant, Copyright: Apache Software
	 * Foundation.
	 * 
	 * @param out
	 *            the out
	 * @param stripPath
	 *            the strip path
	 * @param dir
	 *            the dir
	 * @param pathSeparator
	 *            the path separator
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static void zipDirectory(final ZipOutputStream out,
			final String stripPath, final File dir, final char pathSeparator)
			throws IOException {

		final String[] entries = dir.list();

		if (entries == null || entries.length == 0) {
			return;
		}

		// recurse via entries
		for (final String entry : entries) {
			final File file = new File(dir, entry);
			if (file.isDirectory()) {
				zipDirectory(out, stripPath, file, pathSeparator);
			} else {
				zipFile(out, stripPath, file, pathSeparator);
			}
		}
	}

	/**
	 * Uses code fragments from Jakarta-Ant, Copyright: Apache Software
	 * Foundation.
	 * 
	 * @param out
	 *            the out
	 * @param stripPath
	 *            the strip path
	 * @param file
	 *            the file
	 * @param pathSeparator
	 *            the path separator
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static void zipFile(final ZipOutputStream out,
			final String stripPath, final File file, final char pathSeparator)
			throws IOException {
		final ZipEntry ze = new ZipEntry(processPath(file.getPath(), stripPath,
				pathSeparator));
		ze.setTime(file.lastModified());
		out.putNextEntry(ze);

		final byte[] buffer = new byte[8 * 1024];
		final BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(file), buffer.length);

		try {
			int count = 0;
			while ((count = in.read(buffer, 0, buffer.length)) >= 0) {
				if (count != 0) {
					out.write(buffer, 0, count);
				}
			}
		} finally {
			in.close();
		}
	}

	/**
	 * Constructor for ZipUtil.
	 */
	public ZipUtil() {
		super();
	}
}
