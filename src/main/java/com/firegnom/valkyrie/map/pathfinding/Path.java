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

import java.util.Iterator;
import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * A path determined by some path finding algorithm. A series of steps from the
 * starting location to the target location. This includes a step for the
 * initial location.
 * 
 * @author Kevin Glass
 */
public class Path implements Iterable<Step> {

	/** The list of steps building up this path. */
	public LinkedList<Step> steps = new LinkedList<Step>();

	/**
	 * Create an empty path.
	 */
	public Path() {

	}

	/**
	 * Instantiates a new path.
	 * 
	 * @param path
	 *            the path
	 */
	public Path(final com.firegnom.valkyrie.net.protocol.Path path) {
		for (int i = 0; i < path.step.length; i++) {
			steps.add(new Step(path.step[i].x, path.step[i].y));
		}
	}

	/**
	 * Append a step to the path.
	 * 
	 * @param x
	 *            The x coordinate of the new step
	 * @param y
	 *            The y coordinate of the new step
	 */
	public void appendStep(final int x, final int y) {
		steps.add(new Step(x, y));
	}

	/**
	 * Check if this path contains the given step.
	 * 
	 * @param x
	 *            The x coordinate of the step to check for
	 * @param y
	 *            The y coordinate of the step to check for
	 * @return True if the path contains the given step
	 */
	public boolean contains(final int x, final int y) {
		return steps.contains(new Step(x, y));
	}

	// TODO: not optimised
	/**
	 * Convert to net path.
	 * 
	 * @return the com.firegnom.valkyrie.net.protocol. path
	 */
	public com.firegnom.valkyrie.net.protocol.Path convertToNetPath() {
		final com.firegnom.valkyrie.net.protocol.Path p = new com.firegnom.valkyrie.net.protocol.Path();
		final com.firegnom.valkyrie.net.protocol.Step[] st = new com.firegnom.valkyrie.net.protocol.Step[this.steps
				.size()];
		for (int i = 0; i < st.length; i++) {
			st[i] = new com.firegnom.valkyrie.net.protocol.Step();
			st[i].setX((short) this.steps.get(i).position.x);
			st[i].setY((short) this.steps.get(i).position.y);
		}
		p.setStep(st);
		return p;
	}

	/**
	 * Get the length of the path, i.e. the number of steps
	 * 
	 * @return The number of steps in this path
	 */
	public int getLength() {
		return steps.size();
	}

	/**
	 * Get the step at a given index in the path.
	 * 
	 * @param index
	 *            The index of the step to retrieve. Note this should be >= 0
	 *            and < getLength();
	 * @return The step information, the position on the map.
	 */
	public Step getStep(final int index) {
		// steps.
		return steps.get(index);
	}

	/**
	 * Get the x coordinate for the step at the given index.
	 * 
	 * @param index
	 *            The index of the step whose x coordinate should be retrieved
	 * @return The x coordinate at the step
	 */
	public int getX(final int index) {
		return getStep(index).position.x;
	}

	/**
	 * Get the y coordinate for the step at the given index.
	 * 
	 * @param index
	 *            The index of the step whose y coordinate should be retrieved
	 * @return The y coordinate at the step
	 */
	public int getY(final int index) {
		return getStep(index).position.y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Step> iterator() {
		// TODO Auto-generated method stub
		return steps.iterator();
	}

	/**
	 * Prepend a step to the path.
	 * 
	 * @param x
	 *            The x coordinate of the new step
	 * @param y
	 *            The y coordinate of the new step
	 */
	public void prependStep(final int x, final int y) {
		steps.add(0, new Step(x, y));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ret = "Path :";
		for (final Step s : this) {
			ret += "(" + s.position.x + "," + s.position.y + ")";
		}
		return ret;

	}

}
