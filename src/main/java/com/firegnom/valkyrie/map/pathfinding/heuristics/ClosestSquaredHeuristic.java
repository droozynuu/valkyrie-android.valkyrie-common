package com.firegnom.valkyrie.map.pathfinding.heuristics;

import com.firegnom.valkyrie.map.pathfinding.AStarHeuristic;
import com.firegnom.valkyrie.map.pathfinding.Mover;
import com.firegnom.valkyrie.map.pathfinding.Pathfindable;

// TODO: Auto-generated Javadoc
/**
 * A heuristic that uses the tile that is closest to the target as the next best
 * tile. In this case the sqrt is removed and the distance squared is used
 * instead
 * 
 * @author Kevin Glass
 */
public class ClosestSquaredHeuristic implements AStarHeuristic {

	/**
	 * Gets the cost.
	 *
	 * @param map the map
	 * @param mover the mover
	 * @param x the x
	 * @param y the y
	 * @param tx the tx
	 * @param ty the ty
	 * @return the cost
	 * @see AStarHeuristic#getCost(Pathfindable, Mover, int, int, int, int)
	 */
	public float getCost(Pathfindable map, Mover mover, int x, int y, int tx,
			int ty) {
		float dx = tx - x;
		float dy = ty - y;

		return ((dx * dx) + (dy * dy));
	}

}
