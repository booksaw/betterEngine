package com.booksaw.betterEngine.physics.shape;

/**
 * A class to describe a bounding box which can handle doubles instead of using
 * the java inbuilt one which cannot
 */
public class BoundingBox extends Rectangle {

	public BoundingBox(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	public BoundingBox() {
		super();
	}

	@Override
	public BoundingBox getBoundingBox() {
		return this;
	}

}
