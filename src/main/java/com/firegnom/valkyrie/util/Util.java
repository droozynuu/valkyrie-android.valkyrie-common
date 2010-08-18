package com.firegnom.valkyrie.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class Util.
 */
public class Util {
	
	/**
	 * To convert the InputStream to String we use the BufferedReader.readLine()
	 * method. We iterate until the BufferedReader return null which means
	 * there's no more data to read. Each line will appended to a StringBuilder
	 * and returned as String.
	 *
	 * @param is the is
	 * @return the string
	 */
	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	/**
	 * Copy pipe.
	 *
	 * @param in the in
	 * @param out the out
	 * @param buf the buf
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void copyPipe(InputStream in, OutputStream out, byte[] buf)
			throws IOException {
		int read = -1;
		while ((read = in.read(buf)) >= 0) {
			out.write(buf, 0, read);
		}
		out.flush();
	}

}
