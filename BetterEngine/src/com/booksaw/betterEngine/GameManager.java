package com.booksaw.betterEngine;

/**
 * This class is the main conduit between the game engine code and the code for
 * a specific game
 * <p>
 * When the game starts, create an instance of this class for the game to start
 * running correctly
 * </p>
 * <p>
 * This class is used to startup the game and correctly direct it as needed
 * </p>
 * 
 * @author booksaw
 *
 */
/**
 * @author nfgg2
 *
 */
public abstract class GameManager {

	private final GameSettings gameSettings;

	public GameManager() {
		gameSettings = generateGameSettings();

		// final thing to run
		onEnable();
	}

	/**
	 * Used to get all the game settings for this
	 * 
	 * @return
	 */
	public GameSettings getGameSettings() {
		return gameSettings;
	}

	// SUBMETHODS
	/**
	 * Called when the game is enabling
	 */
	public void onEnable() {

	}

	/**
	 * Called when the game is closing
	 */
	public void onDisable() {

	}

	/**
	 * Used to init and generate all the game settings
	 * 
	 * @return The game settings object
	 */
	protected abstract GameSettings generateGameSettings();

}
