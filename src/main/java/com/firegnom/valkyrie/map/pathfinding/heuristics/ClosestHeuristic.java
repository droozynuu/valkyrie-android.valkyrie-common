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

import java.io.Serializable;

import com.firegnom.valkyrie.map.pathfinding.AStarHeuristic;
import com.firegnom.valkyrie.map.pathfinding.Mover;
import com.firegnom.valkyrie.map.pathfinding.Pathfindable;

// TODO: Auto-generated Javadoc
/**
 * A heuristic that uses the tile that is closest to the target as the next best
 * tile.
 * 
 * @author Kevin Glass
 */
public class ClosestHeuristic implements AStarHeuristic, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

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
		final float dx = tx - x;
		final float dy = ty - y;

		final float result = (float) (Math.sqrt((dx * dx) + (dy * dy)));

		return result;
	}

}
