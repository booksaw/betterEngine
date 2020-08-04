package com.booksaw.betterEngine.movement;

/**
 * A wrapper class to store a 2d location
 * 
 * @author booksaw
 *
 */
public class Location {

	private double x, y;

	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Used to get another instance of this location without effecting this one
	 * 
	 * @return
	 */
	public Location getCopy() {
		return new Location(x, y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
