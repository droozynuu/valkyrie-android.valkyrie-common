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
package com.firegnom.valkyrie.scripting;

// TODO: Auto-generated Javadoc
/**
 * This object is responsible for controlling user interaction and dialogs.
 *
 * @author firegnom
 */
public interface SGui {
	
	/**
	 * show a short message which will disappear after a short period of time.
	 *
	 * @param msg text of the message
	 */
	public abstract void toast(final String msg);

	/**
	 * Question.
	 *
	 * @param msg the msg
	 * @return true, if successful
	 */
	public abstract boolean question(final String msg);

	/**
	 * Info.
	 *
	 * @param title the title
	 * @param msg the msg
	 */
	public abstract void info(final String title, final String msg);

	/**
	 * Info.
	 *
	 * @param msg the msg
	 */
	public abstract void info(final String msg);

}
