package com.firegnom.valkyrie.map.pathfinding;

import com.firegnom.valkyrie.map.Position;

// TODO: Auto-generated Javadoc
/**
 * The Class Step.
 */
public class Step {
	
	/** The position. */
	Position position;

	/**
	 * Create a new step.
	 *
	 * @param x The x coordinate of the new step
	 * @param y The y coordinate of the new step
	 */
	public Step(int x, int y) {
		position = new Position();
		this.position.x = x;
		this.position.y = y;
	}

	/**
	 * Instantiates a new step.
	 */
	public Step() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get the x coordinate of the new step.
	 *
	 * @return The x coodindate of the new step
	 */
	public int getX() {
		return position.x;
	}

	/**
	 * Get the y coordinate of the new step.
	 *
	 * @return The y coodindate of the new step
	 */
	public int getY() {
		return position.y;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return position.x * position.y;
	}

	/**
	 * Equals.
	 *
	 * @param other the other
	 * @return true, if successful
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Step) {
			Step o = (Step) other;
			return (o.position == position) && (o.position.x == position.x)
					&& (o.position.y == position.y);
		}

		return false;
	}
}