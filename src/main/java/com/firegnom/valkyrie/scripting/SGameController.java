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
 * script representation of Screen Controller.
 *
 * @author firegnom
 */
public interface SGameController {
	
	/**
	 * Loads a new zone with specified name.
	 *
	 * @param name of new zone to load
	 */
	public abstract void load(String name);

	/**
	 * Shows a movement layer the fields you can't reach should be in red.
	 */
	public abstract void moves();

	/**
	 * Make script to sleep for number of miliseconds.
	 *
	 * @param time miliseconds to wait
	 */
	public abstract void sleep(int time);

	/**
	 * Makes screen to follow player.
	 *
	 * @param b if true follow if false not
	 */
	public abstract void followPlayer(boolean b);

}
