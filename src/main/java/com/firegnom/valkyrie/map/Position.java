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
