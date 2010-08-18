package com.firegnom.valkyrie.net;

import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;

// TODO: Auto-generated Javadoc
/**
 * The Class ByteBufferDataOutput.
 */
public class ByteBufferDataOutput implements DataOutput {
	
	/** The bb. */
	ByteBuffer bb;

	/**
	 * Instantiates a new byte buffer data output.
	 *
	 * @param bb the bb
	 */
	public ByteBufferDataOutput(ByteBuffer bb) {
		this.bb = bb;
	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#write(int)
	 */
	public void write(int arg0) throws IOException {
		bb.putInt(arg0);

	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#write(byte[])
	 */
	public void write(byte[] arg0) throws IOException {
		bb.put(arg0);

	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#write(byte[], int, int)
	 */
	public void write(byte[] arg0, int arg1, int arg2) throws IOException {
		bb.put(arg0, arg1, arg2);

	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeBoolean(boolean)
	 */
	public void writeBoolean(boolean arg0) throws IOException {
		bb.put(arg0 ? (byte) 1 : (byte) 0);
	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeByte(int)
	 */
	public void writeByte(int arg0) throws IOException {
		bb.put((byte) arg0);
	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeBytes(java.lang.String)
	 */
	public void writeBytes(String arg0) throws IOException {
		byte[] bytes = arg0.getBytes("UTF-8");
		int len = bytes.length;
		bb.putInt(len);
		for (int i = 0; i < len; i++) {
			bb.put(bytes[i]);
		}

	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeChar(int)
	 */
	public void writeChar(int arg0) throws IOException {
		bb.putChar((char) arg0);

	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeChars(java.lang.String)
	 */
	public void writeChars(String arg0) throws IOException {
		writeBytes(arg0);

	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeDouble(double)
	 */
	public void writeDouble(double arg0) throws IOException {
		bb.putDouble(arg0);
	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeFloat(float)
	 */
	public void writeFloat(float arg0) throws IOException {
		bb.putFloat(arg0);
	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeInt(int)
	 */
	public void writeInt(int arg0) throws IOException {
		bb.putInt(arg0);

	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeLong(long)
	 */
	public void writeLong(long arg0) throws IOException {
		bb.putLong(arg0);

	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeShort(int)
	 */
	public void writeShort(int arg0) throws IOException {
		bb.putShort((short) arg0);
	}

	/* (non-Javadoc)
	 * @see java.io.DataOutput#writeUTF(java.lang.String)
	 */
	public void writeUTF(String arg0) throws IOException {
		writeBytes(arg0);
	}

	/**
	 * Gets the buffer.
	 *
	 * @return the buffer
	 */
	public ByteBuffer getBuffer() {
		// TODO Auto-generated method stub
		return bb;
	}

}
