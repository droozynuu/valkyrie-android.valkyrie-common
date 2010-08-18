/**
 * 
 */
package com.firegnom.valkyrie.net;

import java.io.DataInput;
import java.io.IOException;
import java.nio.ByteBuffer;

// TODO: Auto-generated Javadoc
/**
 * The Class ByteBufferDataInput.
 *
 * @author macio
 */
public class ByteBufferDataInput implements DataInput {
	
	/** The bb. */
	private ByteBuffer bb;

	/**
	 * Instantiates a new byte buffer data input.
	 *
	 * @param bb the bb
	 */
	public ByteBufferDataInput(ByteBuffer bb) {
		this.bb = bb;
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readBoolean()
	 */
	public boolean readBoolean() throws IOException {
		return bb.get() == 1 ? true : false;
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readByte()
	 */
	public byte readByte() throws IOException {
		return bb.get();
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readChar()
	 */
	public char readChar() throws IOException {

		return bb.getChar();
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readDouble()
	 */
	public double readDouble() throws IOException {
		// TODO Auto-generated method stub
		return bb.getDouble();
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readFloat()
	 */
	public float readFloat() throws IOException {
		return bb.getFloat();
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readFully(byte[])
	 */
	public void readFully(byte[] b) throws IOException {
		bb.get(b);

	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readFully(byte[], int, int)
	 */
	public void readFully(byte[] b, int off, int len) throws IOException {
		bb.get(b, off, len);

	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readInt()
	 */
	public int readInt() throws IOException {
		return bb.getInt();
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readLine()
	 */
	public String readLine() throws IOException {
		throw new IOException("Not implemented");
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readLong()
	 */
	public long readLong() throws IOException {
		return bb.getLong();
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readShort()
	 */
	public short readShort() throws IOException {
		return bb.getShort();
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readUTF()
	 */
	public String readUTF() throws IOException {
		int len = bb.getInt();
		byte[] bytes = new byte[len];
		for (int i = 0; i < len; i++) {
			bytes[i] = bb.get();
		}
		return new String(bytes);

	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readUnsignedByte()
	 */
	public int readUnsignedByte() throws IOException {
		throw new IOException("Not implemented");
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#readUnsignedShort()
	 */
	public int readUnsignedShort() throws IOException {
		throw new IOException("Not implemented");
	}

	/* (non-Javadoc)
	 * @see java.io.DataInput#skipBytes(int)
	 */
	public int skipBytes(int n) throws IOException {
		int ret = Math.min(bb.remaining(), n);
		bb.position(bb.position() + ret);

		return ret;
	}

}
