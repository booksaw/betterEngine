package com.booksaw.betterEngine.event.events;

import com.booksaw.betterEngine.event.Cancellable;
import com.booksaw.betterEngine.event.Event;
import com.booksaw.betterEngine.event.HandlerList;

public class ExampleEvent extends Event implements Cancellable {

	private static final HandlerList HANDLERS_LIST = new HandlerList();

	public static final HandlerList getHandlersList() {
		return HANDLERS_LIST;
	}

	@Override
	public HandlerList getHandlerList() {
		return HANDLERS_LIST;
	}

	private boolean cancelled = false ;

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}
