package com.firegnom.valkyrie.net;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

// TODO: Auto-generated Javadoc
/**
 * The Class ByteBufferBackedOutputStream.
 */
public class ByteBufferBackedOutputStream extends OutputStream {
	
	/** The buf. */
	ByteBuffer buf;

	/**
	 * Instantiates a new byte buffer backed output stream.
	 *
	 * @param buf the buf
	 */
	public ByteBufferBackedOutputStream(ByteBuffer buf) {
		this.buf = buf;
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(int)
	 */
	@Override
	public synchronized void write(int b) throws IOException {
		buf.put((byte) b);
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(byte[], int, int)
	 */
	@Override
	public synchronized void write(byte[] bytes, int off, int len)
			throws IOException {
		buf.put(bytes, off, len);
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(byte[])
	 */
	@Override
	public void write(byte[] b) throws IOException {
		buf.put(b);
	}

}
