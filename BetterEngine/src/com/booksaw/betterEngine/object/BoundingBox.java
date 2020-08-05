package com.booksaw.betterEngine.object;

import com.booksaw.betterEngine.movement.Location;

/**
 * A class to describe a bounding box which can handle doubles instead of using
 * the java inbuilt one which cannot
 */
public class BoundingBox {

	public double x, y, width, height;

	/**
	 * Used to create a bounding box object
	 * 
	 * @param x      The x coord of the bounding box
	 * @param y      The y coord of the bounding box
	 * @param width  The width of the bounding box
	 * @param height the height of the bounding box
	 */
	public BoundingBox(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Used to make a bounding box with no collision
	 */
	public BoundingBox() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

	/**
	 * Used to check if this bounding box is colliding with another one
	 * 
	 * @return If this bounding is colliding with the other one
	 */
	public boolean isColliding(BoundingBox rect) {
		if (getMaxPoint().getX() < rect.getMinPoint().getX() || getMinPoint().getX() > rect.getMaxPoint().getX()) {
			return false;
		} else if (getMaxPoint().getY() < rect.getMinPoint().getY()
				|| getMinPoint().getY() > rect.getMaxPoint().getY()) {
			return false;
		}
		System.out.println("collding");
		return true;
	}

	/**
	 * Used to get the location at the bottom left of the bounding box
	 * 
	 * @return The point
	 */
	public Location getMinPoint() {
		return new Location(x, y);
	}

	/**
	 * Used to get the location at the top right of the bounding box
	 * 
	 * @return The point
	 */
	public Location getMaxPoint() {
		return new Location(x + width, y + height);
	}

	@Override
	public String toString() {
		return "Bounding[" + x + ", " + y + ", " + width + ", " + height + "]";
	}

}
