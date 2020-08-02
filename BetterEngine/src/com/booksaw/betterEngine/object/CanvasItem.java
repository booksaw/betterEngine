package com.booksaw.betterEngine.object;

import com.booksaw.betterEngine.objectRendering.ObjectRenderer;
import com.booksaw.betterEngine.objectRendering.TestRender;

public class CanvasItem extends Object {

	public CanvasItem(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	protected void onCreate() {

	}

	@Override
	protected ObjectRenderer createRenderer() {
		return new TestRender(this);
	}

}
