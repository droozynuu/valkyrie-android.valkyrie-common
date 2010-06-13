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
	 * @param bb
	 *            the bb
	 */
	public ByteBufferDataOutput(final ByteBuffer bb) {
		this.bb = bb;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#write(byte[])
	 */
	public void write(final byte[] arg0) throws IOException {
		bb.put(arg0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#write(byte[], int, int)
	 */
	public void write(final byte[] arg0, final int arg1, final int arg2)
			throws IOException {
		bb.put(arg0, arg1, arg2);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#write(int)
	 */
	public void write(final int arg0) throws IOException {
		bb.putInt(arg0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeBoolean(boolean)
	 */
	public void writeBoolean(final boolean arg0) throws IOException {
		bb.put(arg0 ? (byte) 1 : (byte) 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeByte(int)
	 */
	public void writeByte(final int arg0) throws IOException {
		bb.put((byte) arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeBytes(java.lang.String)
	 */
	public void writeBytes(final String arg0) throws IOException {
		final byte[] bytes = arg0.getBytes("UTF-8");
		final int len = bytes.length;
		bb.putInt(len);
		for (int i = 0; i < len; i++) {
			bb.put(bytes[i]);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeChar(int)
	 */
	public void writeChar(final int arg0) throws IOException {
		bb.putChar((char) arg0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeChars(java.lang.String)
	 */
	public void writeChars(final String arg0) throws IOException {
		writeBytes(arg0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeDouble(double)
	 */
	public void writeDouble(final double arg0) throws IOException {
		bb.putDouble(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeFloat(float)
	 */
	public void writeFloat(final float arg0) throws IOException {
		bb.putFloat(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeInt(int)
	 */
	public void writeInt(final int arg0) throws IOException {
		bb.putInt(arg0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeLong(long)
	 */
	public void writeLong(final long arg0) throws IOException {
		bb.putLong(arg0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeShort(int)
	 */
	public void writeShort(final int arg0) throws IOException {
		bb.putShort((short) arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataOutput#writeUTF(java.lang.String)
	 */
	public void writeUTF(final String arg0) throws IOException {
		writeBytes(arg0);
	}

}
