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
	 * The sprite that this movement instance is for
	 */
	protected final Sprite sprite;

	public Movement(Sprite sprite) {
		this.sprite = sprite;
	}

	public abstract void updateMovement();

}
