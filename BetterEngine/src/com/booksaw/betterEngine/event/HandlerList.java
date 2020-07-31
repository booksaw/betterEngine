package com.booksaw.betterEngine.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HandlerList {

	private final List<Handler> handlers = new ArrayList<>();

	public void addHandler(Method method, Listener instance, EventListener details) {
		handlers.add(new Handler(method, instance, details));
		sortHandlers();
	}

	public List<Handler> getHandlers() {
		return handlers;
	}

	/**
	 * This is set to not have an access modifier as it should only be accessed by
	 * EventManager To call an event use EventManager.callEvent()
	 * 
	 * @param event the event to run
	 */
	void runEvent(Event event) {
		handlers.forEach(handler -> {
			handler.runEvent(event);
		});
	}

	/**
	 * This is used to sort the list based upon the respective priority of the
	 * events
	 */
	private void sortHandlers() {
		handlers.sort(new Comparator<Handler>() {

			@Override
			public int compare(Handler o1, Handler o2) {
				return o1.getDetails().priority().getValue() - o2.getDetails().priority().getValue();
			}
		});
	}

	/**
	 * Used to remove a specific instance of a listener object from the handler list
	 * 
	 * @param listen the instance to remove
	 */
	public void removeHandler(Listener listen) {

		// uses a clone to avoid concurrent modification
		new ArrayList<>(handlers).forEach(handle -> {
			if (handle.instance == listen) {
				handlers.remove(handle);
			}
		});
	}

	/**
	 * This class is used to store all information about a specific handler
	 * 
	 * @author booksaw
	 *
	 */
	private final class Handler {

		private final Method method;
		private final Listener instance;
		private final EventListener details;

		public Handler(Method method, Listener instance, EventListener details) {
			this.method = method;
			this.instance = instance;
			this.details = details;
		}

		public void runEvent(Event event) {
			try {
				if (details.ignoreCancelled() && event instanceof Cancellable && ((Cancellable) event).isCancelled()) {
					return;
				}

				method.invoke(instance, event);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		public EventListener getDetails() {
			return details;
		}

	}

}
