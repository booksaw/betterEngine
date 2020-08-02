package com.booksaw.betterEngine.objectRendering;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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
	protected int getRenderedX(double scale) {
		return (int) ((object.getX() - (object.getWidth() / 2)) * scale);
	}

	/**
	 * Used to get the y coord of the top left corner of where the object should be
	 * rendered
	 * 
	 * @param scale        The scale of the camera compared to in game units
	 * @param cameraHeight the height of the camera in pixels
	 * @return the on screen y coord of the top left corner of the object
	 */
	protected int getRenderedY(double scale, int cameraHeight) {
		return cameraHeight - getRenderedYNoCamera(scale);
	}

	/**
	 * Used to get the rendered width of the object
	 * 
	 * @param scale The scale of the camera compared to in game units
	 * @return the width on screen of the object
	 */
	protected int getRenderedWidth(double scale) {
		return (int) (scale * object.getWidth());
	}

	/**
	 * Used to get the rendered height of the object
	 * 
	 * @param scale The scame of the camera compared to in game units
	 * @return the height on screen of the object
	 */
	protected int getRenderedHeight(double scale) {
		return (int) (scale * object.getHeight());
	}

	/**
	 * This method is used to get the y value of the
	 * 
	 * @param scale
	 * @return
	 */
	private int getRenderedYNoCamera(double scale) {
		return ((int) ((object.getY() - (object.getHeight() / 2)) * scale));
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

}
