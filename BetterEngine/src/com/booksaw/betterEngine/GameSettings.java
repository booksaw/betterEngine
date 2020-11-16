package com.booksaw.betterEngine;

/**
 * Used to store all information about a game, for example version
 * 
 * @author booksaw
 *
 */
public interface GameSettings {

	/**
	 * @return The name of the game
	 */
	public abstract String getName();

	/**
	 * @return The current version of the game
	 */
	public abstract String getVersion();

	/**
	 * @return The authors of the game (short string) - More detail for the credits
	 *         can be saved elsewhere
	 */
	public abstract String getAuthors();

}
