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
package com.firegnom.valkyrie.net.protocol.helper;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;

import com.firegnom.valkyrie.net.ByteBufferDataInput;
import com.firegnom.valkyrie.net.ByteBufferDataOutput;
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
import com.firegnom.valkyrie.net.protocol.client.CustomTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class Protocol.
 */
public class Protocol implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant MAX_MESSAGE_SIZE. */
	public static final int MAX_MESSAGE_SIZE = 1024*4;

	/** The VERSION. */
	private static short VERSION = 7;

	/** The listener. */
	private MessageListener listener;

	/**
	 * Instantiates a new protocol.
	 */
	public Protocol() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new protocol.
	 *
	 * @param ml the ml
	 */
	public Protocol(MessageListener ml) {
		listener = ml;
	}

	/**
	 * Doesn't flip.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(PlayerMove m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_PLAYERMOVE);
			CustomTypes.encodePlayerMove(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(PlayerMove m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(ChatMessage m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_CHATMESSAGE);
			CustomTypes.encodeChatMessage(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(ChatMessage m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(ChatUserLeft m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(ChatUserLeft m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_CHATUSERLEFT);
			CustomTypes.encodeChatUserLeft(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(ChatUserJoined m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(ChatUserJoined m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_CHATUSERJOINED);
			CustomTypes.encodeChatUserJoined(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(ChangeGameMode m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(ChangeGameMode m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_CHANGEGAMEMODE);
			CustomTypes.encodeChangeGameMode(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(CreateUserMessage m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(CreateUserMessage m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_CREATEUSERMESSAGE);
			CustomTypes.encodeCreateUserMessage(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(PlayerDisconnected m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_PLAYERDISCONNECTED);
			CustomTypes.encodePlayerDisconnected(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bb.flip();
		return bb;

	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(PlayerPositionMessage m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(PlayerPositionMessage m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_PLAYERPOSITIONMESSAGE);
			CustomTypes.encodePlayerPositionMessage(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(RequestPlayerInfoMessage m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(RequestPlayerInfoMessage m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_REQUESTPLAYERINFOMESSAGE);
			CustomTypes.encodeRequestPlayerInfoMessage(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(PlayerInfoMessage m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(PlayerInfoMessage m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_PLAYERINFOMESSAGE);
			CustomTypes.encodePlayerInfoMessage(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(PlayerPositionsMessage m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(PlayerPositionsMessage m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_PLAYERPOSITIONSMESSAGE);
			CustomTypes.encodePlayerPositionsMessage(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @return the byte buffer
	 */
	public static ByteBuffer encode(RequestPlayersPositionMessage m) {
		ByteBuffer bb = ByteBuffer.allocate(MAX_MESSAGE_SIZE);
		encode(m, bb);
		bb.flip();
		return bb;
	}

	/**
	 * Encode.
	 *
	 * @param m the m
	 * @param bb the bb
	 */
	public static void encode(RequestPlayersPositionMessage m, ByteBuffer bb) {
		DataOutput dos = new ByteBufferDataOutput(bb);
		try {
			dos.writeShort(Protocol.VERSION);
			dos.writeShort(1);
			dos.writeByte(CustomTypes.TYPE_REQUESTPLAYERSPOSITIONMESSAGE);
			CustomTypes.encodeRequestPlayersPositionMessage(dos, m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Register message listener.
	 *
	 * @param ml the ml
	 */
	public void registerMessageListener(MessageListener ml) {
		listener = ml;
	}

	/**
	 * Decode.
	 *
	 * @param bb the bb
	 */
	public void decode(ByteBuffer bb) {

		DataInput dis = new ByteBufferDataInput(bb);
		try {

			short ver = dis.readShort();
			short nb = dis.readShort();
			while (nb != 0) {
				byte type = dis.readByte();
				if (type == CustomTypes.TYPE_PLAYERMOVE) {
					PlayerMove customType = CustomTypes.decodePlayerMove(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_CONFIRMMOVE) {
					ConfirmMove customType = CustomTypes.decodeConfirmMove(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_PLAYERDISCONNECTED) {
					PlayerDisconnected customType = CustomTypes
							.decodePlayerDisconnected(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_CHATMESSAGE) {
					ChatMessage customType = CustomTypes.decodeChatMessage(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_CHATUSERJOINED) {
					ChatUserJoined customType = CustomTypes
							.decodeChatUserJoined(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_CHATUSERLEFT) {
					ChatUserLeft customType = CustomTypes
							.decodeChatUserLeft(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_CREATEUSERMESSAGE) {
					CreateUserMessage customType = CustomTypes
							.decodeCreateUserMessage(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_CHANGEGAMEMODE) {
					ChangeGameMode customType = CustomTypes
							.decodeChangeGameMode(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_PLAYERPOSITIONMESSAGE) {
					PlayerPositionMessage customType = CustomTypes
							.decodePlayerPositionMessage(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_REQUESTPLAYERINFOMESSAGE) {
					RequestPlayerInfoMessage customType = CustomTypes
							.decodeRequestPlayerInfoMessage(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_PLAYERINFOMESSAGE) {
					PlayerInfoMessage customType = CustomTypes
							.decodePlayerInfoMessage(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_PLAYERPOSITIONSMESSAGE) {
					PlayerPositionsMessage customType = CustomTypes
							.decodePlayerPositionsMessage(dis);
					listener.received(customType);
				}
				if (type == CustomTypes.TYPE_REQUESTPLAYERSPOSITIONMESSAGE) {
					RequestPlayersPositionMessage customType = CustomTypes
							.decodeRequestPlayersPositionMessage(dis);
					listener.received(customType);
				}
				nb--;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
