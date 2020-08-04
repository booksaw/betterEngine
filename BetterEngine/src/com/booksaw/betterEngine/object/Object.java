package com.booksaw.betterEngine.object;

import com.booksaw.betterEngine.objectRendering.ObjectRenderer;

public abstract class Object {

	// CONSTRUCTORS

	public Object(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		onCreate();

		renderer = createRenderer();

	}

	// END OF CONSTRUCTORS

	// USEFUL ABSTRACT METHODS
	/**
	 * Called immediately an Object is created. The only code run before this method
	 * is storing details provided in the constructor
	 */
	protected abstract void onCreate();
	// END OF USEFUL ABSTRACT METHODS

	// LOCATION RELATED CODE

	/**
	 * Used to store the exact location of the object
	 */
	protected double x, y, width, height;

	/**
	 * The angle of the object, stored in radians as it is easier for calculations
	 */
	protected double angle;

	public double getX() {
		return x;

	}

	/**
	 * Used to get the x location of the top left corner
	 * 
	 * @return
	 */
	public double getCornerX() {
		return x - (width / 2);
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

	public double getCornerY() {
		return y - (width / 2);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	// END OF LOCATION RELATED CODE

	// RENDERING CODE

	protected ObjectRenderer renderer;

	/**
	 * @return Used to get the renderer which is managing the rendering of this
	 *         object
	 */
	public ObjectRenderer getRenderer() {
		return renderer;
	}

	/**
	 * Used to get the renderer of this specific image
	 * 
	 * @return the object renderer of this type of object
	 */
	protected abstract ObjectRenderer createRenderer();

	// END OF RENDERING CODE

}
