package com.booksaw.betterEngine.event.events;

import com.booksaw.betterEngine.event.Cancellable;
import com.booksaw.betterEngine.event.Event;
import com.booksaw.betterEngine.event.HandlerList;

/**
 * An event which is never intended to be used, it is solely here to show
 * template code
 * 
 * @author booksaw
 *
 */
public class ExampleEvent extends Event implements Cancellable {

	// required for all events
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

}
