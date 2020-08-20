package com.booksaw.betterEngine.physics.shape;

/**
 * A class to describe a bounding box which can handle doubles instead of using
 * the java inbuilt one which cannot
 */
public class BoundingBox extends Rectangle {

	/**
	 * Used to get the bounding box which contains the intersection of the the
	 * bounding boxes
	 * <p>
	 * TODO fix if the boxes are not colliding
	 * </p>
	 * 
	 * @param a The first box
	 * @param b The second box
	 * @return The area which contains the intersection of the bounding boxes
	 */
	public static BoundingBox getIntersectingBox(BoundingBox a, BoundingBox b) {

		return new BoundingBox(a.getX() < b.getX() ? b.getX() : a.getX(), a.getY() < b.getY() ? b.getY() : a.getY(),
				Math.abs(a.getX() - b.getX()), Math.abs(a.getY() - b.getY()));

	}

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
