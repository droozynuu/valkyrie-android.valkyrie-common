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
package com.firegnom.valkyrie.net.protocol.helper;

import com.firegnom.valkyrie.net.protocol.ChangeGameMode;
import com.firegnom.valkyrie.net.protocol.ChatMessage;
import com.firegnom.valkyrie.net.protocol.ChatUserJoined;
import com.firegnom.valkyrie.net.protocol.ChatUserLeft;
import com.firegnom.valkyrie.net.protocol.ConfirmMove;
import com.firegnom.valkyrie.net.protocol.CreateUserMessage;
import com.firegnom.valkyrie.net.protocol.PlayerDisconnected;
import com.firegnom.valkyrie.net.protocol.PlayerInfoMessage;
import com.firegnom.valkyrie.net.protocol.PlayerMove;
import com.firegnom.valkyrie.net.protocol.PlayerPositionMessage;
import com.firegnom.valkyrie.net.protocol.PlayerPositionsMessage;
import com.firegnom.valkyrie.net.protocol.RequestPlayerInfoMessage;
import com.firegnom.valkyrie.net.protocol.RequestPlayersPositionMessage;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving message events. The class that is
 * interested in processing a message event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addMessageListener<code> method. When
 * the message event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see MessageEvent
 */
public interface MessageListener {

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(ChangeGameMode customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(ChatMessage customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(ChatUserJoined customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(ChatUserLeft customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(ConfirmMove customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(CreateUserMessage customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(PlayerDisconnected customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(PlayerInfoMessage customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(PlayerMove customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(PlayerPositionMessage customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(PlayerPositionsMessage customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(RequestPlayerInfoMessage customType);

	/**
	 * Received.
	 * 
	 * @param customType
	 *            the custom type
	 */
	void received(RequestPlayersPositionMessage customType);

}
