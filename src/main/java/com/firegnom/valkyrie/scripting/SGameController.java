package com.firegnom.valkyrie.scripting;

// TODO: Auto-generated Javadoc
/**
 * script representation of Screen Controller.
 *
 * @author firegnom
 */
public interface SGameController {
	
	/**
	 * Loads a new zone with specified name.
	 *
	 * @param name of new zone to load
	 */
	public abstract void load(String name);

	/**
	 * Shows a movement layer the fields you can't reach should be in red.
	 */
	public abstract void moves();

	/**
	 * Make script to sleep for number of miliseconds.
	 *
	 * @param time miliseconds to wait
	 */
	public abstract void sleep(int time);

	/**
	 * Makes screen to follow player.
	 *
	 * @param b if true follow if false not
	 */
	public abstract void followPlayer(boolean b);

}