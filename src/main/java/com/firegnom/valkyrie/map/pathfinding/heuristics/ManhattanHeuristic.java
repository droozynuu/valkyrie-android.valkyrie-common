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
package com.firegnom.valkyrie.map.pathfinding.heuristics;

import com.firegnom.valkyrie.map.pathfinding.AStarHeuristic;
import com.firegnom.valkyrie.map.pathfinding.Mover;
import com.firegnom.valkyrie.map.pathfinding.Pathfindable;

// TODO: Auto-generated Javadoc
/**
 * A heuristic that drives the search based on the Manhattan distance between
 * the current location and the target.
 * 
 * @author Kevin Glass
 */
public class ManhattanHeuristic implements AStarHeuristic {

	/** The minimum movement cost from any one square to the next. */
	private final int minimumCost;

	/**
	 * Create a new heuristic.
	 * 
	 * @param minimumCost
	 *            The minimum movement cost from any one square to the next
	 */
	public ManhattanHeuristic(final int minimumCost) {
		this.minimumCost = minimumCost;
	}

	/**
	 * Gets the cost.
	 * 
	 * @param map
	 *            the map
	 * @param mover
	 *            the mover
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param tx
	 *            the tx
	 * @param ty
	 *            the ty
	 * @return the cost
	 * @see AStarHeuristic#getCost(Pathfindable, Mover, int, int, int, int)
	 */
	public float getCost(final Pathfindable map, final Mover mover,
			final int x, final int y, final int tx, final int ty) {
		return minimumCost * (Math.abs(x - tx) + Math.abs(y - ty));
	}

}
