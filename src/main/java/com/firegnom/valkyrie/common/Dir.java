package com.firegnom.valkyrie.common;

// TODO: Auto-generated Javadoc
/**
 * The Class Dir.
 */
public class Dir {

	/** The Constant E. */
	public static final short E = 0;
	
	/** The Constant N. */
	public static final short N = 1;
	
	/** The Constant NE. */
	public static final short NE = 2;
	
	/** The Constant NW. */
	public static final short NW = 3;
	
	/** The Constant S. */
	public static final short S = 4;
	
	/** The Constant SE. */
	public static final short SE = 5;
	
	/** The Constant SW. */
	public static final short SW = 6;
	
	/** The Constant W. */
	public static final short W = 7;

	/** The Constant dirs. */
	public static final short dirs = 8;

	/** The Constant names. */
	public static final String[] names = { "East", "North", "Northeast",
			"Nortweast", "South", "Southeast", "Southwest", "West" };

	/** The Constant LAST. */
	public static final short LAST = E;

	/** The Constant DIR_MATRIX. */
	public static final short[][] DIR_MATRIX = { { SE, E, NE }, { S, E, N },
			{ SW, W, NW } };
}
