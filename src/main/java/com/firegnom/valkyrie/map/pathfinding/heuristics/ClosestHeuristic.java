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

		float result = (float) (Math.sqrt((dx * dx) + (dy * dy)));

		return result;
	}

}
