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
/** 
 * MooDS Encoder/Decoder for Flash.
 * Encoding version: 1200
 * @author Generated by MooDS Generator v2.1.0 - 2006 CNAM, INT, Filao 
 */

package com.firegnom.valkyrie.net.protocol.client;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.Hashtable;

import com.firegnom.valkyrie.net.protocol.ChangeGameMode;
import com.firegnom.valkyrie.net.protocol.ChatMessage;
import com.firegnom.valkyrie.net.protocol.ChatUserJoined;
import com.firegnom.valkyrie.net.protocol.ChatUserLeft;
import com.firegnom.valkyrie.net.protocol.ConfirmMove;
import com.firegnom.valkyrie.net.protocol.CreateUserMessage;
import com.firegnom.valkyrie.net.protocol.Path;
import com.firegnom.valkyrie.net.protocol.PlayerDisconnected;
import com.firegnom.valkyrie.net.protocol.PlayerInfoMessage;
import com.firegnom.valkyrie.net.protocol.PlayerMove;
import com.firegnom.valkyrie.net.protocol.PlayerPositionMessage;
import com.firegnom.valkyrie.net.protocol.PlayerPositionsMessage;
import com.firegnom.valkyrie.net.protocol.PlayerStats;
import com.firegnom.valkyrie.net.protocol.RequestPlayerInfoMessage;
import com.firegnom.valkyrie.net.protocol.RequestPlayersPositionMessage;
import com.firegnom.valkyrie.net.protocol.Step;

// TODO: Auto-generated Javadoc
//This class has been generated by MooDS Generator to handle objects
// for binarisation input/output.
/**
 * The Class CustomTypes.
 */
public class CustomTypes {

	// types
	/** The Constant TYPE_PLAYERMOVE. */
	public final static byte TYPE_PLAYERMOVE = 1;
	
	/** The Constant TYPE_CONFIRMMOVE. */
	public final static byte TYPE_CONFIRMMOVE = 2;
	
	/** The Constant TYPE_PLAYERDISCONNECTED. */
	public final static byte TYPE_PLAYERDISCONNECTED = 3;
	
	/** The Constant TYPE_CHATMESSAGE. */
	public final static byte TYPE_CHATMESSAGE = 4;
	
	/** The Constant TYPE_CHATUSERJOINED. */
	public final static byte TYPE_CHATUSERJOINED = 5;
	
	/** The Constant TYPE_CHATUSERLEFT. */
	public final static byte TYPE_CHATUSERLEFT = 6;
	
	/** The Constant TYPE_CHANGEGAMEMODE. */
	public final static byte TYPE_CHANGEGAMEMODE = 7;
	
	/** The Constant TYPE_REQUESTPLAYERINFOMESSAGE. */
	public final static byte TYPE_REQUESTPLAYERINFOMESSAGE = 8;
	
	/** The Constant TYPE_CREATEUSERMESSAGE. */
	public final static byte TYPE_CREATEUSERMESSAGE = 9;
	
	/** The Constant TYPE_PLAYERINFOMESSAGE. */
	public final static byte TYPE_PLAYERINFOMESSAGE = 10;
	
	/** The Constant TYPE_PLAYERPOSITIONSMESSAGE. */
	public final static byte TYPE_PLAYERPOSITIONSMESSAGE = 11;
	
	/** The Constant TYPE_PLAYERPOSITIONMESSAGE. */
	public final static byte TYPE_PLAYERPOSITIONMESSAGE = 12;
	
	/** The Constant TYPE_REQUESTPLAYERSPOSITIONMESSAGE. */
	public final static byte TYPE_REQUESTPLAYERSPOSITIONMESSAGE = 13;

	// encodeData root method
	/**
	 * Encode data.
	 *
	 * @param h the h
	 * @param dos the dos
	 * @throws Exception the exception
	 */
	public static void encodeData(Hashtable h, DataOutput dos) throws Exception {
		dos.writeShort(1200);
		dos.writeShort(h.size());
		int nbSend = h.size();
		for (int i = 0; i < nbSend; i++) {
			Object o = h.get("" + i);
			if (o instanceof PlayerMove) {
				dos.writeByte(TYPE_PLAYERMOVE);
				encodePlayerMove(dos, ((PlayerMove) o));
			}
			if (o instanceof ConfirmMove) {
				dos.writeByte(TYPE_CONFIRMMOVE);
				encodeConfirmMove(dos, ((ConfirmMove) o));
			}
			if (o instanceof PlayerDisconnected) {
				dos.writeByte(TYPE_PLAYERDISCONNECTED);
				encodePlayerDisconnected(dos, ((PlayerDisconnected) o));
			}
			if (o instanceof ChatMessage) {
				dos.writeByte(TYPE_CHATMESSAGE);
				encodeChatMessage(dos, ((ChatMessage) o));
			}
			if (o instanceof ChatUserJoined) {
				dos.writeByte(TYPE_CHATUSERJOINED);
				encodeChatUserJoined(dos, ((ChatUserJoined) o));
			}
			if (o instanceof ChatUserLeft) {
				dos.writeByte(TYPE_CHATUSERLEFT);
				encodeChatUserLeft(dos, ((ChatUserLeft) o));
			}
			if (o instanceof ChangeGameMode) {
				dos.writeByte(TYPE_CHANGEGAMEMODE);
				encodeChangeGameMode(dos, ((ChangeGameMode) o));
			}
			if (o instanceof RequestPlayerInfoMessage) {
				dos.writeByte(TYPE_REQUESTPLAYERINFOMESSAGE);
				encodeRequestPlayerInfoMessage(dos,
						((RequestPlayerInfoMessage) o));
			}
			if (o instanceof CreateUserMessage) {
				dos.writeByte(TYPE_CREATEUSERMESSAGE);
				encodeCreateUserMessage(dos, ((CreateUserMessage) o));
			}
			if (o instanceof PlayerInfoMessage) {
				dos.writeByte(TYPE_PLAYERINFOMESSAGE);
				encodePlayerInfoMessage(dos, ((PlayerInfoMessage) o));
			}
			if (o instanceof PlayerPositionsMessage) {
				dos.writeByte(TYPE_PLAYERPOSITIONSMESSAGE);
				encodePlayerPositionsMessage(dos, ((PlayerPositionsMessage) o));
			}
			if (o instanceof PlayerPositionMessage) {
				dos.writeByte(TYPE_PLAYERPOSITIONMESSAGE);
				encodePlayerPositionMessage(dos, ((PlayerPositionMessage) o));
			}
			if (o instanceof RequestPlayersPositionMessage) {
				dos.writeByte(TYPE_REQUESTPLAYERSPOSITIONMESSAGE);
				encodeRequestPlayersPositionMessage(dos,
						((RequestPlayersPositionMessage) o));
			}
		}
	}

	// decodeData rooy method
	/**
	 * Decode data.
	 *
	 * @param dis the dis
	 * @return the hashtable
	 * @throws Exception the exception
	 */
	public static Hashtable decodeData(DataInput dis) throws Exception {
		dis.readShort();
		Hashtable h = new Hashtable();
		short nb = dis.readShort();
		int nbObj = nb;
		while (nb != 0) {
			String key = "" + (nbObj - nb);
			byte type = dis.readByte();
			if (type == 1) {
				PlayerMove customType = decodePlayerMove(dis);
				h.put(key, customType);
			}
			if (type == 2) {
				ConfirmMove customType = decodeConfirmMove(dis);
				h.put(key, customType);
			}
			if (type == 3) {
				PlayerDisconnected customType = decodePlayerDisconnected(dis);
				h.put(key, customType);
			}
			if (type == 4) {
				ChatMessage customType = decodeChatMessage(dis);
				h.put(key, customType);
			}
			if (type == 5) {
				ChatUserJoined customType = decodeChatUserJoined(dis);
				h.put(key, customType);
			}
			if (type == 6) {
				ChatUserLeft customType = decodeChatUserLeft(dis);
				h.put(key, customType);
			}
			if (type == 7) {
				ChangeGameMode customType = decodeChangeGameMode(dis);
				h.put(key, customType);
			}
			if (type == 8) {
				RequestPlayerInfoMessage customType = decodeRequestPlayerInfoMessage(dis);
				h.put(key, customType);
			}
			if (type == 9) {
				CreateUserMessage customType = decodeCreateUserMessage(dis);
				h.put(key, customType);
			}
			if (type == 10) {
				PlayerInfoMessage customType = decodePlayerInfoMessage(dis);
				h.put(key, customType);
			}
			if (type == 11) {
				PlayerPositionsMessage customType = decodePlayerPositionsMessage(dis);
				h.put(key, customType);
			}
			if (type == 12) {
				PlayerPositionMessage customType = decodePlayerPositionMessage(dis);
				h.put(key, customType);
			}
			if (type == 13) {
				RequestPlayersPositionMessage customType = decodeRequestPlayersPositionMessage(dis);
				h.put(key, customType);
			}
			nb--;
		}
		return h;
	}

	// encoding method for each custom type
	/**
	 * Encode step.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodeStep(DataOutput dos, Step customType)
			throws Exception {
		dos.writeShort(customType.getX());
		dos.writeShort(customType.getY());
	}

	/**
	 * Encode path.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodePath(DataOutput dos, Path customType)
			throws Exception {
		Step[] table1 = customType.getStep();
		int table1_l0 = table1.length;
		dos.writeInt((int) table1_l0);
		if (table1_l0 > 0) {
			for (int i0 = 0; i0 < table1_l0; i0++) {
				encodeStep(dos, table1[i0]);
			}
		}

	}

	/**
	 * Encode player move.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodePlayerMove(DataOutput dos, PlayerMove customType)
			throws Exception {
		dos.writeUTF(customType.getPlayerName());
		dos.writeInt(customType.getPlayerClass());
		encodePath(dos, customType.getPath());
	}

	/**
	 * Encode confirm move.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodeConfirmMove(DataOutput dos, ConfirmMove customType)
			throws Exception {
		dos.writeShort(customType.getId());
	}

	/**
	 * Encode player disconnected.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodePlayerDisconnected(DataOutput dos,
			PlayerDisconnected customType) throws Exception {
		dos.writeUTF(customType.getPlayerName());
	}

	/**
	 * Encode chat message.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodeChatMessage(DataOutput dos, ChatMessage customType)
			throws Exception {
		dos.writeUTF(customType.getUsername());
		dos.writeUTF(customType.getMessage());
	}

	/**
	 * Encode chat user joined.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodeChatUserJoined(DataOutput dos,
			ChatUserJoined customType) throws Exception {
		dos.writeUTF(customType.getUsername());
	}

	/**
	 * Encode chat user left.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodeChatUserLeft(DataOutput dos,
			ChatUserLeft customType) throws Exception {
		dos.writeUTF(customType.getUsername());
	}

	/**
	 * Encode change game mode.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodeChangeGameMode(DataOutput dos,
			ChangeGameMode customType) throws Exception {
		dos.writeInt(customType.getType());
	}

	/**
	 * Encode request player info message.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodeRequestPlayerInfoMessage(DataOutput dos,
			RequestPlayerInfoMessage customType) throws Exception {
	}

	/**
	 * Encode create user message.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodeCreateUserMessage(DataOutput dos,
			CreateUserMessage customType) throws Exception {
		dos.writeInt(customType.getPlayerClass());
	}

	/**
	 * Encode player info message.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodePlayerInfoMessage(DataOutput dos,
			PlayerInfoMessage customType) throws Exception {
		dos.writeInt(customType.getPlayerClass());
		dos.writeUTF(customType.getZoneName());
		encodePlayerPositionMessage(dos, customType.getPosition());
		encodePlayerStats(dos, customType.getStats());
	}

	/**
	 * Encode player positions message.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodePlayerPositionsMessage(DataOutput dos,
			PlayerPositionsMessage customType) throws Exception {
		PlayerPositionMessage[] table1 = customType.getPlayerPositionMessage();
		int table1_l0 = table1.length;
		dos.writeInt((int) table1_l0);
		if (table1_l0 > 0) {
			for (int i0 = 0; i0 < table1_l0; i0++) {
				encodePlayerPositionMessage(dos, table1[i0]);
			}
		}

	}

	/**
	 * Encode player position message.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodePlayerPositionMessage(DataOutput dos,
			PlayerPositionMessage customType) throws Exception {
		dos.writeUTF(customType.getUserName());
		dos.writeInt(customType.getPlayerClass());
		dos.writeShort(customType.getX());
		dos.writeShort(customType.getY());
	}

	/**
	 * Encode player stats.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodePlayerStats(DataOutput dos, PlayerStats customType)
			throws Exception {
		dos.writeInt(customType.getHp());
		dos.writeInt(customType.getMaxHp());
		dos.writeInt(customType.getMp());
		dos.writeInt(customType.getMaxMp());
	}

	/**
	 * Encode request players position message.
	 *
	 * @param dos the dos
	 * @param customType the custom type
	 * @throws Exception the exception
	 */
	public static void encodeRequestPlayersPositionMessage(DataOutput dos,
			RequestPlayersPositionMessage customType) throws Exception {
	}

	// decoding method for each custom type
	/**
	 * Decode step.
	 *
	 * @param dis the dis
	 * @return the step
	 * @throws Exception the exception
	 */
	public static Step decodeStep(DataInput dis) throws Exception {
		Step customType = new Step();

		customType.setX(dis.readShort());
		customType.setY(dis.readShort());
		return customType;
	}

	/**
	 * Decode path.
	 *
	 * @param dis the dis
	 * @return the path
	 * @throws Exception the exception
	 */
	public static Path decodePath(DataInput dis) throws Exception {
		Path customType = new Path();

		int table1_l0 = dis.readInt();
		if (table1_l0 > 0) {
			Step[] table1 = new Step[table1_l0];
			for (int i0 = 0; i0 < table1_l0; i0++) {
				table1[i0] = decodeStep(dis);
			}
			customType.setStep(table1);
		}
		return customType;
	}

	/**
	 * Decode player move.
	 *
	 * @param dis the dis
	 * @return the player move
	 * @throws Exception the exception
	 */
	public static PlayerMove decodePlayerMove(DataInput dis) throws Exception {
		PlayerMove customType = new PlayerMove();

		customType.setPlayerName(dis.readUTF());
		customType.setPlayerClass(dis.readInt());
		customType.setPath(decodePath(dis));
		return customType;
	}

	/**
	 * Decode confirm move.
	 *
	 * @param dis the dis
	 * @return the confirm move
	 * @throws Exception the exception
	 */
	public static ConfirmMove decodeConfirmMove(DataInput dis) throws Exception {
		ConfirmMove customType = new ConfirmMove();

		customType.setId(dis.readShort());
		return customType;
	}

	/**
	 * Decode player disconnected.
	 *
	 * @param dis the dis
	 * @return the player disconnected
	 * @throws Exception the exception
	 */
	public static PlayerDisconnected decodePlayerDisconnected(DataInput dis)
			throws Exception {
		PlayerDisconnected customType = new PlayerDisconnected();

		customType.setPlayerName(dis.readUTF());
		return customType;
	}

	/**
	 * Decode chat message.
	 *
	 * @param dis the dis
	 * @return the chat message
	 * @throws Exception the exception
	 */
	public static ChatMessage decodeChatMessage(DataInput dis) throws Exception {
		ChatMessage customType = new ChatMessage();

		customType.setUsername(dis.readUTF());
		customType.setMessage(dis.readUTF());
		return customType;
	}

	/**
	 * Decode chat user joined.
	 *
	 * @param dis the dis
	 * @return the chat user joined
	 * @throws Exception the exception
	 */
	public static ChatUserJoined decodeChatUserJoined(DataInput dis)
			throws Exception {
		ChatUserJoined customType = new ChatUserJoined();

		customType.setUsername(dis.readUTF());
		return customType;
	}

	/**
	 * Decode chat user left.
	 *
	 * @param dis the dis
	 * @return the chat user left
	 * @throws Exception the exception
	 */
	public static ChatUserLeft decodeChatUserLeft(DataInput dis)
			throws Exception {
		ChatUserLeft customType = new ChatUserLeft();

		customType.setUsername(dis.readUTF());
		return customType;
	}

	/**
	 * Decode change game mode.
	 *
	 * @param dis the dis
	 * @return the change game mode
	 * @throws Exception the exception
	 */
	public static ChangeGameMode decodeChangeGameMode(DataInput dis)
			throws Exception {
		ChangeGameMode customType = new ChangeGameMode();

		customType.setType(dis.readInt());
		return customType;
	}

	/**
	 * Decode request player info message.
	 *
	 * @param dis the dis
	 * @return the request player info message
	 * @throws Exception the exception
	 */
	public static RequestPlayerInfoMessage decodeRequestPlayerInfoMessage(
			DataInput dis) throws Exception {
		RequestPlayerInfoMessage customType = new RequestPlayerInfoMessage();

		return customType;
	}

	/**
	 * Decode create user message.
	 *
	 * @param dis the dis
	 * @return the creates the user message
	 * @throws Exception the exception
	 */
	public static CreateUserMessage decodeCreateUserMessage(DataInput dis)
			throws Exception {
		CreateUserMessage customType = new CreateUserMessage();

		customType.setPlayerClass(dis.readInt());
		return customType;
	}

	/**
	 * Decode player info message.
	 *
	 * @param dis the dis
	 * @return the player info message
	 * @throws Exception the exception
	 */
	public static PlayerInfoMessage decodePlayerInfoMessage(DataInput dis)
			throws Exception {
		PlayerInfoMessage customType = new PlayerInfoMessage();

		customType.setPlayerClass(dis.readInt());
		customType.setZoneName(dis.readUTF());
		customType.setPosition(decodePlayerPositionMessage(dis));
		customType.setStats(decodePlayerStats(dis));
		return customType;
	}

	/**
	 * Decode player positions message.
	 *
	 * @param dis the dis
	 * @return the player positions message
	 * @throws Exception the exception
	 */
	public static PlayerPositionsMessage decodePlayerPositionsMessage(
			DataInput dis) throws Exception {
		PlayerPositionsMessage customType = new PlayerPositionsMessage();

		int table1_l0 = dis.readInt();
		if (table1_l0 > 0) {
			PlayerPositionMessage[] table1 = new PlayerPositionMessage[table1_l0];
			for (int i0 = 0; i0 < table1_l0; i0++) {
				table1[i0] = decodePlayerPositionMessage(dis);
			}
			customType.setPlayerPositionMessage(table1);
		}
		return customType;
	}

	/**
	 * Decode player position message.
	 *
	 * @param dis the dis
	 * @return the player position message
	 * @throws Exception the exception
	 */
	public static PlayerPositionMessage decodePlayerPositionMessage(
			DataInput dis) throws Exception {
		PlayerPositionMessage customType = new PlayerPositionMessage();

		customType.setUserName(dis.readUTF());
		customType.setPlayerClass(dis.readInt());
		customType.setX(dis.readShort());
		customType.setY(dis.readShort());
		return customType;
	}

	/**
	 * Decode player stats.
	 *
	 * @param dis the dis
	 * @return the player stats
	 * @throws Exception the exception
	 */
	public static PlayerStats decodePlayerStats(DataInput dis) throws Exception {
		PlayerStats customType = new PlayerStats();

		customType.setHp(dis.readInt());
		customType.setMaxHp(dis.readInt());
		customType.setMp(dis.readInt());
		customType.setMaxMp(dis.readInt());
		return customType;
	}

	/**
	 * Decode request players position message.
	 *
	 * @param dis the dis
	 * @return the request players position message
	 * @throws Exception the exception
	 */
	public static RequestPlayersPositionMessage decodeRequestPlayersPositionMessage(
			DataInput dis) throws Exception {
		RequestPlayersPositionMessage customType = new RequestPlayersPositionMessage();

		return customType;
	}

}
