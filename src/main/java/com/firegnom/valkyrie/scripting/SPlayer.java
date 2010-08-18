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

import com.firegnom.valkyrie.net.protocol.Path;

// TODO: Auto-generated Javadoc
/**
 * The Interface SPlayer.
 */
public interface SPlayer {

	/**
	 * Instantly teleports player to specified position on the map.
	 *
	 * @param x map position x
	 * @param y map position y
	 */
	public abstract void goTo(int x, int y);

	/**
	 * Player try to find a path to given position and go there;.
	 *
	 * @param x map position x
	 * @param y map position y
	 */
	public abstract void move(int x, int y);

	/**
	 * Player try to find a path to given position and go there, this is
	 * blocking function so it wan't be released until player stops move.
	 * 
	 * @param x
	 *            map position x
	 * @param y
	 *            map position y
	 */
	public abstract void moveW(int x, int y);

	/**
	 * Try to find a path to given position.
	 *
	 * @param x map position x
	 * @param y map position y
	 * @return true if path was found
	 */
	public abstract boolean canReach(int x, int y);

	/**
	 * Try to find path to given position.
	 *
	 * @param x map position x
	 * @param y map position y
	 * @return Path or null if can't find path
	 */
	public abstract Path getPath(int x, int y);

	/**
	 * Show player position on the map.
	 */
	public abstract void show();

	/**
	 * Set Player speed the lower number faster speed min is 0.
	 *
	 * @param s speed of the player min is 0
	 */
	public abstract void speed(int s);

	/**
	 * Waits untill player finishes moving.
	 */
	public abstract void waitForMove();

	/**
	 * Gets a distance in pixels from given position.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the int
	 */
	public abstract int distance(int x, int y);

}
