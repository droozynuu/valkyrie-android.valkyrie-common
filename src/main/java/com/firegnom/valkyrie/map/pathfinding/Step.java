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
