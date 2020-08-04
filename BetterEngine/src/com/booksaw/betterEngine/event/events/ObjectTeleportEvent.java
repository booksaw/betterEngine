package com.booksaw.betterEngine.event.events;

import com.booksaw.betterEngine.event.HandlerList;
import com.booksaw.betterEngine.movement.Location;
import com.booksaw.betterEngine.object.Object;

/**
 * Called when an object is going to be teleported between locations
 * 
 * @author nfgg2
 *
 */
public class ObjectTeleportEvent extends ObjectMoveEvent {

	private static final HandlerList HANDLERS_LIST = new HandlerList();

	public static HandlerList getHandlersList() {
		return HANDLERS_LIST;
	}

	@Override
	public HandlerList getHandlerList() {
		return HANDLERS_LIST;
	}

	public ObjectTeleportEvent(Object object, Location newLocation) {
		super(object, newLocation);
	}

}
