package com.firegnom.valkyrie.net;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

// TODO: Auto-generated Javadoc
// This class downloads a file from a URL.
/**
 * The Class AsyncDownload.
 */
public class AsyncDownload extends Observable implements Runnable {

	// Max size of download buffer.
	/** The Constant MAX_BUFFER_SIZE. */
	private static final int MAX_BUFFER_SIZE = 10024;

	// These are the status names.
	/** The Constant STATUSES. */
	public static final String STATUSES[] = { "Downloading", "Paused",
			"Complete", "Cancelled", "Error" };

	// These are the status codes.
	/** The Constant DOWNLOADING. */
	public static final int DOWNLOADING = 0;
	
	/** The Constant PAUSED. */
	public static final int PAUSED = 1;
	
	/** The Constant COMPLETE. */
	public static final int COMPLETE = 2;
	
	/** The Constant CANCELLED. */
	public static final int CANCELLED = 3;
	
	/** The Constant ERROR. */
	public static final int ERROR = 4;

	/** The url. */
	private URL url; // download URL
	
	/** The size. */
	private int size; // size of download in bytes
	
	/** The downloaded. */
	private int downloaded; // number of bytes downloaded
	
	/** The status. */
	private int status; // current status of download

	/** The path. */
	private String path;

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	// Constructor for Download.
	/**
	 * Instantiates a new async download.
	 *
	 * @param url the url
	 * @param path the path
	 * @param o the o
	 */
	public AsyncDownload(URL url, String path, Observer o) {
		addObserver(o);
		this.url = url;
		this.path = path;
		size = -1;
		downloaded = 0;
		status = DOWNLOADING;

		// Begin the download.
		download();
	}

	// Get this download's URL.
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url.toString();
	}

	// Get this download's size.
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	// Get this download's progress.
	/**
	 * Gets the progress.
	 *
	 * @return the progress
	 */
	public float getProgress() {
		return ((float) downloaded / size) * 100;
	}

	// Get this download's status.
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	// Pause this download.
	/**
	 * Pause.
	 */
	public void pause() {
		status = PAUSED;
		stateChanged();
	}

	// Resume this download.
	/**
	 * Resume.
	 */
	public void resume() {
		status = DOWNLOADING;
		stateChanged();
		download();
	}

	// Cancel this download.
	/**
	 * Cancel.
	 */
	public void cancel() {
		status = CANCELLED;
		stateChanged();
	}

	// Mark this download as having an error.
	/**
	 * Error.
	 */
	private void error() {
		status = ERROR;
		stateChanged();
	}

	// Start or resume downloading.
	/**
	 * Download.
	 */
	private void download() {
		Thread thread = new Thread(this);
		thread.start();
	}

	// Get file name portion of URL.
	/**
	 * Gets the file name.
	 *
	 * @param url the url
	 * @return the file name
	 */
	private String getFileName(URL url) {
		String fileName = url.getFile();
		return fileName.substring(fileName.lastIndexOf('/') + 1);
	}

	// Download file.
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		RandomAccessFile file = null;
		InputStream stream = null;

		try {
			// Open connection to URL.
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setUseCaches(false);
			// Specify what portion of file to download.
			connection.setRequestProperty("Range", "bytes=" + downloaded + "-");

			// Connect to server.
			connection.connect();

			// Make sure response code is in the 200 range.
			if (connection.getResponseCode() / 100 != 2) {
				error();
			}

			// Check for valid content length.
			int contentLength = connection.getContentLength();
			if (contentLength < 1) {
				error();
			}

			/*
			 * Set the size for this download if it hasn't been already set.
			 */
			if (size == -1) {
				size = contentLength;
				stateChanged();
			}

			// Open file and seek to the end of it.
			file = new RandomAccessFile(path + getFileName(url) + ".tmp", "rw");
			file.seek(downloaded);

			stream = connection.getInputStream();
			while (status == DOWNLOADING) {
				/*
				 * Size buffer according to how much of the file is left to
				 * download.
				 */
				byte buffer[];
				if (size - downloaded > MAX_BUFFER_SIZE) {
					buffer = new byte[MAX_BUFFER_SIZE];
				} else {
					buffer = new byte[size - downloaded];
				}

				// Read from server into buffer.
				int read = stream.read(buffer);
				if (read == -1) {
					break;
				}

				// Write buffer to file.
				file.write(buffer, 0, read);
				downloaded += read;
				stateChanged();
			}

			File f = new File(path + getFileName(url) + ".tmp");
			File newf = new File(path + getFileName(url));
			if (newf.exists()) {
				status = ERROR;
				stateChanged();
				return;
			}
			f.renameTo(newf);
			/*
			 * Change status to complete if this point was reached because
			 * downloading has finished.
			 */
			if (status == DOWNLOADING) {
				status = COMPLETE;
				stateChanged();
			}
		} catch (Exception e) {
			error();
		} finally {
			// Close file.
			if (file != null) {
				try {
					file.close();
				} catch (Exception e) {
				}
			}

			// Close connection to server.
			if (stream != null) {
				try {
					stream.close();
				} catch (Exception e) {
				}
			}
		}
	}

	// Notify observers that this download's status has changed.
	/**
	 * State changed.
	 */
	private void stateChanged() {
		setChanged();
		notifyObservers();
	}
}