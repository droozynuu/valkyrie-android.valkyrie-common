/*******************************************************************************
 * Copyright (c) 2010 Maciej Kaniewski (mk@firegnom.com).
 *  
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 3 of the License, or
 *     (at your option) any later version.
 *  
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *  
 *     You should have received a copy of the GNU General Public License
 *     along with this program; if not, write to the Free Software Foundation,
 *     Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 *  
 *     Contributors:
 *      Maciej Kaniewski (mk@firegnom.com) - initial API and implementation
 ******************************************************************************/
package com.firegnom.valkyrie.common.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import junit.framework.TestCase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.firegnom.valkyrie.net.Download;
import com.firegnom.valkyrie.util.Util;
import com.firegnom.valkyrie.util.ZipUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class UrlTest.
 */
public class UrlTest extends TestCase {
	
	/**
	 * Test url.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void testUrl() throws IOException {
		// URL u = new URL("http://valkyrie.firegnom.com/data/grafika.zip");
		// Download d = new Download(u,"/home/macio/",new Observer() {
		//
		// public void update(Observable arg0, Object arg1) {
		// System.out.println(((Download)arg0).getProgress() + "status : "+
		// Download.STATUSES[((Download)arg0).getStatus()]);
		// }
		// });
		//
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// d.pause();
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// d.resume();
		// try {
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	/**
	 * Test url sync.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void testUrlSync() throws IOException {
		String path = "/home/macio/grafika/";
		Download packsDownload = new Download(new URL(
				"http://valkyrie.firegnom.com/data/packs.json"), path, true);
		if (!packsDownload.download()) {
			return;
		}
		File packs = new File(path + "packs.json");
		JSONObject packsjson;

		try {
			packsjson = new JSONObject(
					Util.convertStreamToString(new FileInputStream(packs)));
			JSONArray packsArray = packsjson.getJSONArray("install");
			for (int i = 0; i < packsArray.length(); i++) {
				String pack = packsArray.getString(i);
				if (!new File(path + pack + ".json").exists()) {
					URL u = new URL("http://valkyrie.firegnom.com/data/" + pack
							+ ".zip");
					Download d = new Download(u, path, true, new Observer() {

						public void update(Observable arg0, Object arg1) {
							System.out.println(((Download) arg0).getProgress()
									+ "status : "
									+ Download.STATUSES[((Download) arg0)
											.getStatus()]);
						}
					});

					System.out.println(d.download());
					ZipUtil.unzip(new File(path + pack + ".zip"),
							new File(path));
				}

			}

		} catch (JSONException e) {
			e.printStackTrace();
			return;

		}

	}

	/**
	 * Download pack.
	 */
	public void downloadPack() {

	}
}
