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
 * The description of a class providing a cost for a given tile based on a
 * target location and entity being moved. This heuristic controls what priority
 * is placed on different tiles during the search for a path
 * 
 * @author Kevin Glass
 */
public interface AStarHeuristic {

	/**
	 * Get the additional heuristic cost of the given tile. This controls the
	 * order in which tiles are searched while attempting to find a path to the
	 * target location. The lower the cost the more likely the tile will be
	 * searched.
	 * 
	 * @param map
	 *            The map on which the path is being found
	 * @param mover
	 *            The entity that is moving along the path
	 * @param x
	 *            The x coordinate of the tile being evaluated
	 * @param y
	 *            The y coordinate of the tile being evaluated
	 * @param tx
	 *            The x coordinate of the target location
	 * @param ty
	 *            Teh y coordinate of the target location
	 * @return The cost associated with the given tile
	 */
	public float getCost(Pathfindable map, Mover mover, int x, int y, int tx,
			int ty);
}
