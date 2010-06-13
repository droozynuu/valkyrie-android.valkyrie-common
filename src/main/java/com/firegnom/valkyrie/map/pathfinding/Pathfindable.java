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
package com.firegnom.valkyrie.map.pathfinding;

// TODO: Auto-generated Javadoc
/**
 * The description for the data we're pathfinding over. This provides the
 * contract between the data being searched (i.e. the in game map) and the path
 * finding generic tools
 * 
 * @author Kevin Glass
 */
public interface Pathfindable {
	/**
	 * Check if the given location is blocked, i.e. blocks movement of the
	 * supplied mover.
	 * 
	 * @param mover
	 *            The mover that is potentially moving through the specified
	 *            tile.
	 * @param x
	 *            The x coordinate of the tile to check
	 * @param y
	 *            The y coordinate of the tile to check
	 * @return True if the location is blocked
	 */
	public boolean blocked(Mover mover, int x, int y);

	/**
	 * Get the cost of moving through the given tile. This can be used to make
	 * certain areas more desirable. A simple and valid implementation of this
	 * method would be to return 1 in all cases.
	 * 
	 * @param mover
	 *            The mover that is trying to move across the tile
	 * @param sx
	 *            The x coordinate of the tile we're moving from
	 * @param sy
	 *            The y coordinate of the tile we're moving from
	 * @param tx
	 *            The x coordinate of the tile we're moving to
	 * @param ty
	 *            The y coordinate of the tile we're moving to
	 * @return The relative cost of moving across the given tile
	 */
	public float getCost(Mover mover, int sx, int sy, int tx, int ty);

	/**
	 * Get the height of the tile map. The slightly odd name is used to
	 * distiguish this method from commonly used names in game maps.
	 * 
	 * @return The number of tiles down the map
	 */
	public int getHeightInTiles();

	/**
	 * Get the width of the tile map. The slightly odd name is used to
	 * distiguish this method from commonly used names in game maps.
	 * 
	 * @return The number of tiles across the map
	 */
	public int getWidthInTiles();

	/**
	 * Notification that the path finder visited a given tile. This is used for
	 * debugging new heuristics.
	 * 
	 * @param x
	 *            The x coordinate of the tile that was visited
	 * @param y
	 *            The y coordinate of the tile that was visited
	 */
	public void pathFinderVisited(int x, int y);
}
