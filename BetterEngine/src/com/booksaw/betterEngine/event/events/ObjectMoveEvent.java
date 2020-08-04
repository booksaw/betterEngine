package com.booksaw.betterEngine.event.events;

import com.booksaw.betterEngine.event.Cancellable;
import com.booksaw.betterEngine.event.HandlerList;
import com.booksaw.betterEngine.movement.Location;

/**
 * Called whenever an object moves (the setX() or setY() method is called)
 * 
 * @author booksaw
 *
 */
public class ObjectMoveEvent extends ObjectEvent implements Cancellable {
	private static final HandlerList HANDLERS_LIST = new HandlerList();

	public static HandlerList getHandlersList() {
		return HANDLERS_LIST;
	}

	@Override
	public HandlerList getHandlerList() {
		return HANDLERS_LIST;
	}

	// only required for cancellable events
	private boolean cancelled = false;

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	private Location newLocation;

	public ObjectMoveEvent(com.booksaw.betterEngine.object.Object object, Location newLocation) {
		super(object);
		this.newLocation = newLocation;
	}

	public Location getNewLocation() {
		return newLocation;
	}

	public Location getCurrentLocation() {
		return getObject().getLocation();
	}

	public void setNewLocation(Location newLocation) {
		this.newLocation = newLocation;
	}

}
