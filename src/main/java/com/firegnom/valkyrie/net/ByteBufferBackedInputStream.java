package com.firegnom.valkyrie.net;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

// TODO: Auto-generated Javadoc
/**
 * The Class ByteBufferBackedInputStream.
 */
public class ByteBufferBackedInputStream extends InputStream {
	
	/** The buf. */
	ByteBuffer buf;

	/**
	 * Instantiates a new byte buffer backed input stream.
	 *
	 * @param buf the buf
	 */
	public ByteBufferBackedInputStream(ByteBuffer buf) {
		this.buf = buf;
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#read()
	 */
	@Override
	public synchronized int read() throws IOException {
		if (!buf.hasRemaining()) {
			return -1;
		}
		return buf.get();
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#read(byte[], int, int)
	 */
	@Override
	public synchronized int read(byte[] bytes, int off, int len)
			throws IOException {
		len = Math.min(len, buf.remaining());
		buf.get(bytes, off, len);
		return len;
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#read(byte[])
	 */
	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#available()
	 */
	@Override
	public int available() throws IOException {
		// TODO Auto-generated method stub
		return buf.remaining();
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#markSupported()
	 */
	@Override
	public boolean markSupported() {
		// TODO Auto-generated method stub
		return false;
	}

}
