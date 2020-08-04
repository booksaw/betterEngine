package com.booksaw.betterEngine.object;

import com.booksaw.betterEngine.event.EventManager;
import com.booksaw.betterEngine.event.events.ObjectMoveEvent;
import com.booksaw.betterEngine.event.events.ObjectTeleportEvent;
import com.booksaw.betterEngine.movement.Location;
import com.booksaw.betterEngine.objectRendering.ObjectRenderer;

public abstract class Object {

	// CONSTRUCTORS

	public Object(Location location, double width, double height) {
		this.location = location;
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

	private Location location;

	/**
	 * Used to store the exact size of the object
	 */
	protected double width, height;

	/**
	 * The angle of the object, stored in radians as it is easier for calculations
	 */
	protected double angle;

	public double getX() {
		return location.getX();

	}

	/**
	 * Used to get the x location of the top left corner
	 * 
	 * @return
	 */
	public double getCornerX() {
		return getX() - (width / 2);
	}

	private void setX(double x) {
		Location loc = location.getCopy();
		loc.setX(x);
		setLocation(loc);
	}

	public double getY() {
		return location.getY();
	}

	private void setY(double y) {
		Location loc = location.getCopy();
		loc.setY(y);
		setLocation(loc);
	}

	public double getCornerY() {
		return getY() - (width / 2);
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

	/**
	 * Used to relocate the object to the new location using an ObjectMoveEvent
	 * 
	 * @see teleport Teleport method for other use cases of movement
	 * 
	 * @param location The location to set the object to
	 */
	private void setLocation(Location location) {

		ObjectMoveEvent event = new ObjectMoveEvent(this, location);

		EventManager.callEvent(event);
		// the event is cancelled
		if (!event.isCancelled()) {
			return;
		}

		location = event.getNewLocation();

	}

	public Location getLocation() {
		return location;
	}

	/**
	 * Used when the object is being teleported. This should not be used when the
	 * object is being moved in a close location, but instead to completely
	 * reposition the object
	 * 
	 * @param location The location that the object is to be teleported to
	 */
	public void teleport(Location location) {
		ObjectTeleportEvent event = new ObjectTeleportEvent(this, location);

		// the event is cancelled
		if (!event.isCancelled()) {
			return;
		}

		location = event.getNewLocation();
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
