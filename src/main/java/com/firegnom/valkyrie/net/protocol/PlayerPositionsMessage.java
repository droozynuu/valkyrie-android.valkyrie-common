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
package com.firegnom.valkyrie.net.protocol;

// TODO: Auto-generated Javadoc
/**
 * MooDS Class File for Java.
 * 
 * @author Generated by MooDS Generator v2.1.0 - 2006 CNAM, INT, Filao
 */

public class PlayerPositionsMessage {

	// attributes
	/** The player position message. */
	public PlayerPositionMessage[] playerPositionMessage;

	// constructor
	/**
	 * Instantiates a new player positions message.
	 */
	public PlayerPositionsMessage() {
	}

	// setter/getter methods
	/**
	 * Gets the player position message.
	 *
	 * @return the player position message
	 */
	public PlayerPositionMessage[] getPlayerPositionMessage() {
		return playerPositionMessage;
	}

	/**
	 * Sets the player position message.
	 *
	 * @param _local_var the new player position message
	 */
	public void setPlayerPositionMessage(PlayerPositionMessage[] _local_var) {
		playerPositionMessage = _local_var;
	}

}
