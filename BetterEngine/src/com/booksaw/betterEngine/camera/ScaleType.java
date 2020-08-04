package com.booksaw.betterEngine.camera;

/**
 * This class is used to determine how the camera calculates its location during
 * scaling.
 * <p>
 * There are multiple scale types which should be used in different situations
 * </p>
 * 
 * @author booksaw
 *
 */
public enum ScaleType {

	/**
	 * This is useful when loading a level or a preset, this will scale the camera
	 * and only the bottom left pixel will remain in the same location
	 */
	CORNER,

	/**
	 * This method will act more like a camera zooming, the scale will increase, but
	 * the x and y coords will be adjusted so the centre of the enlargement will be
	 * the centre of the camera not the corner
	 */
	CENTRE;

}
