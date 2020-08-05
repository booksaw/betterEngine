package com.booksaw.betterEngine.movement;

import com.booksaw.betterEngine.object.Sprite;

/**
 * Used to define a new vector manipulation which can dictate an objects
 * movement
 * 
 * @author booksaw
 *
 */
public abstract class Movement {

	/**
	 * Used to update the movement details for that sprite
	 */
	public abstract void updateMovement(Sprite sprite);

}
