package com.booksaw.betterEngine.object;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.event.EventManager;
import com.booksaw.betterEngine.event.events.ObjectMoveEvent;
import com.booksaw.betterEngine.event.events.ObjectTeleportEvent;
import com.booksaw.betterEngine.movement.Location;
import com.booksaw.betterEngine.movement.Vector;
import com.booksaw.betterEngine.objectRendering.ObjectRenderer;
import com.booksaw.betterEngine.physics.Collision;
import com.booksaw.betterEngine.physics.shape.BoundingBox;
import com.booksaw.betterEngine.timing.Updatable;

/**
 * 
 * This class is for any object which is displayed within the game, no matter
 * the specifics of the object
 * 
 * @author booksaw
 *
 */
public abstract class Object implements Updatable {

	private final Collision collision;
	private final Game game;
	// CONSTRUCTORS

	public Object(Game game, Location location, double width, double height) {
		this.location = location;
		this.width = width;
		this.height = height;
		this.game = game;
		velocity = Vector.createBlankVector();

		onCreate();

		renderer = createRenderer();

		game.getGameClock().addUpdateable(this);
		collision = new Collision(this);

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

	private Vector velocity;

	public double getX() {
		return location.getX();

	}

	/**
	 * @return the x location of the top left corner
	 */
	public double getCornerX() {
		return getX() - (width / 2);
	}

//	/**
//	 * Used only when applying vectors to the object. This will trigger an
//	 * ObjectMoveEvent
//	 * 
//	 * @param x The new x location of the object
//	 */
//	private void setX(double x) {
//		Location loc = location.getCopy();
//		loc.setX(x);
//		setLocation(loc);
//	}

	public double getY() {
		return location.getY();
	}

//	/**
//	 * Used only when applying vectors to the object. This will trigger an
//	 * ObjectMoveEvent
//	 * 
//	 * @param y The new y location of the object
//	 */
//	private void setY(double y) {
//		Location loc = location.getCopy();
//		loc.setY(y);
//		setLocation(loc);
//	}

	public double getCornerY() {
		return getY() - (height / 2);
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

	/**
	 * @return the vertical axis aligned height of the object collision including
	 *         rotation
	 */
	public double getRotatedHeight() {
		double w = getWidth();
		double h = getHeight();

		return w * Math.abs(Math.sin(getAngle())) + (h * Math.abs(Math.cos(getAngle())));

	}

	/**
	 * @return The horizontal axis aligned height of the object collision including
	 *         rotation.
	 */
	public double getRotatedWidth() {
		double w = getWidth();
		double h = getHeight();

		return w * Math.abs(Math.cos(getAngle())) + (h * Math.abs(Math.sin(getAngle())));
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
		if (event.isCancelled()) {
			return;
		}

		this.location = event.getNewLocation();

	}

	/**
	 * This method is used to update the velocity and apply the velocity vector
	 */
	private void applyVelocityVector() {
		Location finalLoc = location.getCopy();

		// applying the hard limit to the velocity of width/2 - (width *0.0001)
		// this is done so in a single update, an object cannot fully clip into another
		// object
		double xLim = width / 2 - (width * 0.0001);

		if (xLim < velocity.getY()) {
			velocity.setY(xLim);
		}

		double yLim = height / 2 - (height * 0.0001);

		if (yLim < velocity.getY()) {
			velocity.setY(yLim);
		}

		finalLoc.setX(finalLoc.getX() + velocity.getX());
		finalLoc.setY(finalLoc.getY() + velocity.getY());
		Location current = location;
		setLocation(finalLoc);

		if (game.checkCollisions(this)) {
			setLocation(current);
		}

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
		if (event.isCancelled()) {
			return;
		}

		location = event.getNewLocation();
	}

	public Vector getVelocity() {
		return velocity;
	}

	/**
	 * Used to add the provided vector to this objects current velocity vectort
	 * 
	 * @param vector The vector to add to this vector
	 */
	public void applyVector(Vector vector) {
		velocity.addVector(vector);
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

	// PHYSICS DETAILS

	private double restitution = 0;
	private double mass;

	/**
	 * Used to get the collision of this object
	 * 
	 * @return
	 */
	public Collision getCollision() {
		return collision;
	}

	// TODO this is just for testing
	public BoundingBox getBoundingBox() {
		return new BoundingBox(getCornerX(), getCornerY(), getRotatedWidth(), getRotatedHeight());
	}

	/**
	 * @return the Coefficient of restitution of this object
	 */
	public double getRestitution() {
		return restitution;
	}

	public void setRestitution(double restitution) {
		this.restitution = restitution;
	}

	public double getMass() {
		return mass;
	}

	public double getInverseMass() {
		if (mass == 0) {
			return 0;
		} else {
			return 1 / mass;
		}
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	// END OF PHYSICS DETAILS

	@Override
	public void update() {
		applyVelocityVector();
		System.out.println(getBoundingBox() + " " + velocity);
	}

}
