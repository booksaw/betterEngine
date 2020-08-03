package com.booksaw.betterEngine.camera;

import java.awt.Dimension;
import java.awt.Rectangle;

public class Camera {

	/**
	 * The exact collision of the camera in in game units
	 */
	private double x, y;
	private double scale;
	private final Dimension actualDimensions;

	/**
	 * This is used to create a new camera object
	 * 
	 * @param actualDimensions the dimensions of the camera on screen in pixels
	 */
	public Camera(Dimension actualDimensions) {
		x = 0;
		y = 0;
		scale = 1;

		this.actualDimensions = actualDimensions;
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

	/**
	 * @return The in game width of the camera
	 */
	public double getWidth() {
		return getCameraWidthPixels() * scale;
	}

	/**
	 * @return The in game height of the camera
	 */
	public double getHeight() {
		return getCameraHeightPixels() * scale;
	}

	/**
	 * @return the camera width in pixels across the screen
	 */
	public int getCameraWidthPixels() {
		return actualDimensions.width;
	}

	/**
	 * @return the camera height in pixels across the screen
	 */
	public int getCameraHeightPixels() {
		return actualDimensions.height;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	/**
	 * This method is used to check if an object is on camera, and thus should be rendered
	 * 
	 * @return A rectangle which is the collision of this camera within in game
	 *         units
	 */
	public Rectangle getLooseCollision() {
		return new Rectangle((int) x, (int) y, (int) getWidth(), (int) getHeight());
	}

}
