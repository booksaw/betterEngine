package com.booksaw.betterEngine.object;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.movement.Location;
import com.booksaw.betterEngine.objectRendering.ObjectRenderer;
import com.booksaw.betterEngine.objectRendering.TestRender;

public class CanvasItem extends Object {

	public CanvasItem(Game game, Location location, double width, double height) {
		super(game, location, width, height);
	}

	@Override
	protected void onCreate() {

	}

	@Override
	protected ObjectRenderer createRenderer() {
		return new TestRender(this);
	}

}
