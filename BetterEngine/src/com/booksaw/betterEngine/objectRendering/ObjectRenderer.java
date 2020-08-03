package com.booksaw.betterEngine.objectRendering;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.booksaw.betterEngine.camera.Camera;
import com.booksaw.betterEngine.object.Object;
import com.booksaw.betterEngine.utils.ImageUtils;

public abstract class ObjectRenderer {

	private final Object object;

	public ObjectRenderer(Object object) {
		this.object = object;
	}

	/**
	 * Used to get the texture of the current
	 * 
	 * @return
	 */
	public abstract BufferedImage getImage();

	/**
	 * Used to get the correctly rotated version of the Object.object image
	 * 
	 * @return The rotated version of the rendered image
	 */
	public BufferedImage getRotatedImage(double angle) {
		// less graphics intensive rendering
		if (angle == 0) {
			BufferedImage image = getImage();
			return ImageUtils.rotateImageByRadians(image, angle);
		} else {
			// ensuring the image is a large enough scale
			// TODO improve massively
			BufferedImage temp = ImageUtils.toBufferedImage(
					ImageUtils.getScaledInstance(getImage(), (int) object.getWidth(), (int) object.getHeight()));
			BufferedImage image = ImageUtils.toBufferedImage(ImageUtils.getScaledInstance(temp, getMinimum()));
			return ImageUtils.rotateImageByRadians(image, angle);
		}
	}

	/**
	 * This method is used to calculate the minimum size of the image to show a
	 * smooth edge without intense processing
	 * 
	 * @return the minimum side length for the shape to look correct
	 */
	private int getMinimum() {
		// TODO
		return 500;
	}

	// CONVERTING LOCATION INTO RENDERED LOCATION

	/**
	 * Used to get the top left corner of where the object should be rendered
	 * 
	 * @param camera The camera which is viewing the object
	 * @return the on screen x coord of the top left corner of the object
	 */
	protected int getRenderedX(Camera camera) {
		return (int) ((object.getX() - camera.getX()) * camera.getScale()) - (getRenderedWidth(camera) / 2);
	}

	/**
	 * This method is used to get the y value of the object without flipping it to
	 * match the renderer
	 * 
	 * @param camera The camera which is viewing the object
	 * @return The y value of object
	 */
	private int getRenderedYNoCamera(Camera camera) {
		return (int) ((object.getY() - camera.getY()) * camera.getScale()) + (getRenderedHeight(camera) / 2);
	}

	/**
	 * Used to get the y coord of the top left corner of where the object should be
	 * rendered
	 * 
	 * @param camera The camera which is viewing the object
	 * @return the on screen y coord of the top left corner of the object
	 */
	protected int getRenderedY(Camera camera) {
		return camera.getCameraHeightPixels() - getRenderedYNoCamera(camera);
	}

	/**
	 * Used to get the rendered width of the object
	 * 
	 * @param camera The camera which is viewing the object
	 * @return the width on screen of the object
	 */
	protected int getRenderedWidth(Camera camera) {
		double w = object.getWidth();
		double h = object.getHeight();

		return (int) ((w * Math.abs(Math.cos(object.getAngle())) + (h * Math.abs(Math.sin(object.getAngle()))))
				* camera.getScale());
	}

	/**
	 * Used to get the rendered height of the object
	 * 
	 * @param camera The camera which is viewing the object
	 * @return the height on screen of the object
	 */
	protected int getRenderedHeight(Camera camera) {
		double w = object.getWidth();
		double h = object.getHeight();

		return (int) ((w * Math.abs(Math.sin(object.getAngle())) + (h * Math.abs(Math.cos(object.getAngle()))))
				* camera.getScale());
	}

	/**
	 * This is used to calculate the scaled width of the object without rotation
	 * 
	 * @param camera The camera, this is used to get the scale
	 * @return the scaled width
	 */
	protected double getScaledWidth(Camera camera) {
		return camera.getScale() * object.getWidth();
	}

	/**
	 * This is used to calculate the scaled height of the object without rotation
	 * 
	 * @param camera The camera, this is used to get the scale
	 * @return the scaled height
	 */
	protected double getScaledHeight(Camera camera) {
		return camera.getScale() * object.getHeight();
	}

	/**
	 * This method is used to detect if the rendering code should be run for this.
	 * This method provides a object.
	 * <p>
	 * This rectangle is using the game y coord (so it is not flipped for actual
	 * rendering)
	 * </p>
	 * 
	 * @return A rough rectangle in which this object will be contained by
	 */
	public Rectangle getLooseCollision() {
		return new Rectangle((int) object.getX(), (int) object.getY(), (int) object.getWidth(),
				(int) object.getHeight());
	}

	// END OF LOCATION CONVERSION

	// RENDERING CODE

	/**
	 * Called whenever this object should be drawn to the screen
	 * 
	 * @param g      the graphics component of the container
	 * @param camera The camera which the object is being viewed through
	 */
	public void paint(Graphics g, Camera camera) {
		// calculating the positions of the rendered location
		paint(g, camera, getRenderedX(camera), getRenderedY(camera), getRenderedWidth(camera),
				getRenderedHeight(camera), object.getAngle());
	}

	/**
	 * Called by paint, override if standard graphics do not do what your subclass
	 * needs it to
	 * 
	 * @param g      The graphics component of the container
	 * @param camera The camera which the object is being viewed through
	 * @param x      The x location of the top left corner of the object (in pixels)
	 * @param y      the y location of the top right corner of the object (in
	 *               pixels)
	 * @param width  the width of the object (in pixels)
	 * @param height the height of the object (in pixels)
	 * @param angle  the angle at which the object is at
	 */
	private void paint(Graphics g, Camera camera, int x, int y, int width, int height, double angle) {
		g.drawImage(getRotatedImage(angle), x, y, width, height, null);
	}

	// END OF RENDERING CODE

}
