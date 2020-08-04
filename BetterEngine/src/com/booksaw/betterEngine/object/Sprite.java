package com.booksaw.betterEngine.object;

import java.util.List;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.movement.Location;
import com.booksaw.betterEngine.movement.Movement;

public class Sprite extends CanvasItem {

	private List<Movement> moveSet;

	public Sprite(Game game, Location location, double width, double height) {
		super(game, location, width, height);
	}

	@Override
	public void update() {
		super.update();

		moveSet.forEach(movement -> {
			movement.updateMovement();
		});
	}

}
