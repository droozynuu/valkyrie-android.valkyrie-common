package com.firegnom.valkyrie.scripting;

// TODO: Auto-generated Javadoc
/**
 * This object is responsible for controlling user interaction and dialogs.
 *
 * @author firegnom
 */
public interface SGui {
	
	/**
	 * show a short message which will disappear after a short period of time.
	 *
	 * @param msg text of the message
	 */
	public abstract void toast(final String msg);

	/**
	 * Question.
	 *
	 * @param msg the msg
	 * @return true, if successful
	 */
	public abstract boolean question(final String msg);

	/**
	 * Info.
	 *
	 * @param title the title
	 * @param msg the msg
	 */
	public abstract void info(final String title, final String msg);

	/**
	 * Info.
	 *
	 * @param msg the msg
	 */
	public abstract void info(final String msg);

}
