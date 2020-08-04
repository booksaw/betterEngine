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
		return getCameraWidthPixels() / scale;
	}

	/**
	 * @return The in game height of the camera
	 */
	public double getHeight() {
		return getCameraHeightPixels() / scale;
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

	/**
	 * This method is used to change the scale of the camera. It will assume the
	 * intended scale type is ScaleType.CENTRE
	 * 
	 * @param scale The new scale of the camera
	 */
	public void setScale(double scale) {
		setScale(scale, ScaleType.CENTRE);
	}

	/**
	 * Used to set the scale of the camera using the specified scale type
	 * 
	 * @param scale The new scale of the camera
	 * @param type  The type of scaling
	 * @see ScaleType ScaleType
	 */
	public void setScale(double scale, ScaleType type) {
		switch (type) {
		case CENTRE:
			// a more complex process
			// the starting width and height
			double sw = getWidth();
			double sh = getHeight();

			// setting the scale
			this.scale = scale;

			// moving the x and y coord
			x += (sw - getWidth()) / 2;
			y += (sh - getHeight()) / 2;
			break;
		case CORNER:
			// a simple alteration of the scale
			this.scale = scale;
			break;

		}
	}

	/**
	 * This method is used to check if an object is on camera, and thus should be
	 * rendered
	 * 
	 * @return A rectangle which is the collision of this camera within in game
	 *         units
	 */
	public Rectangle getLooseCollision() {
		return new Rectangle((int) x + 1, (int) y + 1, (int) getWidth() + 1, (int) getHeight() + 1);
	}

}
