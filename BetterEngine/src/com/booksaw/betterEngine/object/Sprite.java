package com.booksaw.betterEngine.object;

import java.util.ArrayList;
import java.util.List;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.movement.Location;
import com.booksaw.betterEngine.movement.Movement;

public class Sprite extends CanvasItem {

	private final List<Movement> moveSet = new ArrayList<>();

	public Sprite(Game game, Location location, double width, double height) {
		super(game, location, width, height);
	}

	@Override
	public void update() {
		super.update();

		moveSet.forEach(movement -> {
			movement.updateMovement(this);
		});
	}

	/**
	 * Used to add a new movement to this object
	 */
	public void addMovement(Movement movement) {
		moveSet.add(movement);
	}

}
