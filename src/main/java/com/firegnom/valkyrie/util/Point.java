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
//   Point.java
//   Java Spatial Index Library
//   Copyright (C) 2002 Infomatiq Limited
//  
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Lesser General Public
//  License as published by the Free Software Foundation; either
//  version 2.1 of the License, or (at your option) any later version.
//  
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Lesser General Public License for more details.
//  
//  You should have received a copy of the GNU Lesser General Public
//  License along with this library; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307 USA

package com.firegnom.valkyrie.util;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * Currently hardcoded to 2 dimensions, but could be extended.
 * 
 * @author aled.morris@infomatiq.co.uk
 * @version 1.0b2
 */
public class Point implements Serializable,Cloneable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Number of dimensions in a point. In theory this could be exended to three
	 * or more dimensions.
	 */
	private final static int DIMENSIONS = 2;

	/**
	 * The (x, y) coordinates of the point.
	 */
	public int[] coordinates;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            The x coordinate of the point
	 * @param y
	 *            The y coordinate of the point
	 */
	public Point(int x, int y) {
		coordinates = new int[DIMENSIONS];
		coordinates[0] = x;
		coordinates[1] = y;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return coordinates[0];
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return coordinates[1];
	}

	/**
	 * In range.
	 *
	 * @param p the p
	 * @param range the range
	 * @return true, if successful
	 */
	public boolean inRange(Point p, int range) {
		double dx = p.coordinates[0] - coordinates[0];
		double dy = p.coordinates[1] - coordinates[1];
		// distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		return distance <= range;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Point(" + coordinates[0] + "," + coordinates[1] + ")";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Point clone() throws CloneNotSupportedException {
		return new Point(coordinates[0],coordinates[1]);
	}
}
