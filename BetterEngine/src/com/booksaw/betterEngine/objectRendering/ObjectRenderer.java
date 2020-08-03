package com.booksaw.betterEngine.objectRendering;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.booksaw.betterEngine.camera.Camera;
import com.booksaw.betterEngine.object.Object;

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

	// CONVERTING LOCATION INTO RENDERED LOCATION
	// TODO include camera scale in all rendered values

	/**
	 * Used to get the top left corner of where the object should be rendered
	 * 
	 * @param scale The scale of the camera compared to in game units
	 * @return the on screen x coord of the top left corner of the object
	 */
	protected int getRenderedX(Camera camera) {
		return (int) (((object.getX() - camera.getX()) - (object.getWidth() / 2)) * camera.getScale());
	}

	/**
	 * Used to get the y coord of the top left corner of where the object should be
	 * rendered
	 * 
	 * @param scale        The scale of the camera compared to in game units
	 * @param cameraHeight the height of the camera in pixels
	 * @return the on screen y coord of the top left corner of the object
	 */
	protected int getRenderedY(Camera camera) {
		return camera.getCameraHeightPixels() - getRenderedYNoCamera(camera);
	}

	/**
	 * Used to get the rendered width of the object
	 * 
	 * @param scale The scale of the camera compared to in game units
	 * @return the width on screen of the object
	 */
	protected int getRenderedWidth(Camera camera) {
		return (int) (camera.getScale() * object.getWidth());
	}

	/**
	 * Used to get the rendered height of the object
	 * 
	 * @param scale The scame of the camera compared to in game units
	 * @return the height on screen of the object
	 */
	protected int getRenderedHeight(Camera camera) {
		return (int) (camera.getScale() * object.getHeight());
	}

	/**
	 * This method is used to get the y value of the
	 * 
	 * @param scale
	 * @return
	 */
	private int getRenderedYNoCamera(Camera camera) {
		return ((int) (((object.getY() - camera.getY()) - (object.getHeight() / 2)) * camera.getScale()));
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
		paint(g, camera, getRenderedHeight(camera), getRenderedHeight(camera), getRenderedWidth(camera),
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
		g.drawImage(getImage(), x, y, width, height, null);
	}

	// END OF RENDERING CODE

}
