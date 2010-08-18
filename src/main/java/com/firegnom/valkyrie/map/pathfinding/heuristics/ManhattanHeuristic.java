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
	private int minimumCost;

	/**
	 * Create a new heuristic.
	 *
	 * @param minimumCost The minimum movement cost from any one square to the next
	 */
	public ManhattanHeuristic(int minimumCost) {
		this.minimumCost = minimumCost;
	}

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
		return minimumCost * (Math.abs(x - tx) + Math.abs(y - ty));
	}

}
