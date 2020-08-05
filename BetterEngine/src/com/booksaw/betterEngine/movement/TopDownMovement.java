/**
 * 
 */
package com.booksaw.betterEngine.movement;

import com.booksaw.betterEngine.input.KeyboardManager;
import com.booksaw.betterEngine.object.Sprite;

/**
 * @author booksaw
 *
 */
public class TopDownMovement extends Movement {

	private double aHorizontal = 0.00001, aVertical = 0.00001;

	@Override
	public void updateMovement(Sprite sprite) {
		Vector v = Vector.createBlankVector();
		if (KeyboardManager.keyboardManager.isActive("player.1.up")) {
			v.addY(aVertical);
		}

		if (KeyboardManager.keyboardManager.isActive("player.1.down")) {
			v.addY(-aVertical);
		}
		if (KeyboardManager.keyboardManager.isActive("player.1.left")) {
			v.addX(-aHorizontal);
		}
		if (KeyboardManager.keyboardManager.isActive("player.1.right")) {
			v.addX(aHorizontal);
		}
//		System.out.println("applying " + v);
		sprite.applyVector(v);

	}

}
