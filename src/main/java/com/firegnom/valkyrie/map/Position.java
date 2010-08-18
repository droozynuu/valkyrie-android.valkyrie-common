package com.firegnom.valkyrie.map;

// TODO: Auto-generated Javadoc
/**
 * The Class Position.
 */
public class Position {

	/**
	 * Instantiates a new position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Instantiates a new position.
	 */
	public Position() {
		// TODO Auto-generated constructor stub
	}

	/** The x. */
	public int x;
	
	/** The y. */
	public int y;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuffer().append("Position: (").append(x).append(",")
				.append(y).append(")").toString();
	}

	/**
	 * Equals.
	 *
	 * @param p the p
	 * @return true, if successful
	 */
	public boolean equals(Position p) {
		return ((x == p.x) && (y == p.y));
	}

	/**
	 * Equals.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	public boolean equals(int x, int y) {
		return ((this.x == x) && (this.y == y));
	}

	/**
	 * In range.
	 *
	 * @param p the p
	 * @param range the range
	 * @return true, if successful
	 */
	public boolean inRange(Position p, int range) {
		double dx = p.x - x;
		double dy = p.y - y;
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		return distance <= range;
	}

	/**
	 * Sets the xy.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;

	}

}
