package com.booksaw.betterEngine.event.events;

import com.booksaw.betterEngine.event.Cancellable;
import com.booksaw.betterEngine.event.Event;

/**
 * Class which contains code for handling an event associated with an object
 * 
 * @author booksaw
 *
 */
public abstract class ObjectEvent extends Event implements Cancellable {
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

	private final com.booksaw.betterEngine.object.Object object;

	public ObjectEvent(com.booksaw.betterEngine.object.Object object) {
		this.object = object;
	}

	public com.booksaw.betterEngine.object.Object getObject() {
		return object;
	}

}
