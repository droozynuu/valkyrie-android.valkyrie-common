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
package com.firegnom.valkyrie.map.pathfinding;

// TODO: Auto-generated Javadoc
/**
 * A description of an implementation that can find a path from one location on
 * a tile map to another based on information provided by that tile map.
 * 
 * @see Pathfindable
 * @author Kevin Glass
 */
public interface PathFinder {

	/**
	 * Find a path from the starting location provided (sx,sy) to the target
	 * location (tx,ty) avoiding blockages and attempting to honour costs
	 * provided by the tile map.
	 * 
	 * @param mover
	 *            The entity that will be moving along the path. This provides a
	 *            place to pass context information about the game entity doing
	 *            the moving, e.g. can it fly? can it swim etc.
	 * 
	 * @param sx
	 *            The x coordinate of the start location
	 * @param sy
	 *            The y coordinate of the start location
	 * @param tx
	 *            The x coordinate of the target location
	 * @param ty
	 *            Teh y coordinate of the target location
	 * @return The path found from start to end, or null if no path can be
	 *         found.
	 */
	public Path findPath(Mover mover, int sx, int sy, int tx, int ty);
}
