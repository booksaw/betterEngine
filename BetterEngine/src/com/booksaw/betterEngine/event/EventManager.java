package com.booksaw.betterEngine.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.booksaw.betterEngine.exceptions.InvalidListenerException;

public class EventManager {

	/**
	 * Used to add all the events in the class to the correct handeler lists
	 * 
	 * @param listen the instance of the listener class to use
	 */
	public static void registerEvents(Listener listen) {

		// this could cause errors if not caught
		if (listen == null) {
			return;
		}

		for (Method method : listen.getClass().getMethods()) {
			// used to check if the event is valid
			updateEvent(listen, method, true);
		}

	}

	/**
	 * This method is used to register a specific method within an instance of a
	 * class, this is used when searching through all methods in that class
	 * 
	 * @param listen the instance of this class to add to the listeners
	 * @param method the method within this class to run checks for
	 * @param add    true if the event is to be added, false if the event is to be
	 *               removed
	 */
	private static void updateEvent(Listener listen, Method method, boolean add) {
		EventListener annotations = method.getAnnotation(EventListener.class);
		if (annotations == null) {
			// this specific method is not valid
			return;
		}

		// the method must have a single parameter
		if (method.getParameterCount() != 1) {
			return;
		}

		Class<?> cls = method.getParameters()[0].getType();
		if (!Event.class.isAssignableFrom(method.getParameters()[0].getType())) {
			// it is not a valid method
			return;
		}
		try {
			Method handlers = cls.getMethod("getHandlersList");
			Object obj = handlers.invoke(null);

			HandlerList listeners = (HandlerList) obj;
			if (add) {
				listeners.addHandler(method, listen, annotations);
			} else {
				listeners.removeHandler(listen);
			}

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new InvalidListenerException(cls);
		}
	}

	/**
	 * Used to remove all events from the handlers lists
	 * 
	 * @param listener
	 */
	public static void cancelEvents(Listener listener) {
		for (Method method : listener.getClass().getMethods()) {
			updateEvent(listener, method, false);
		}
	}

	/**
	 * Used to call an event
	 * 
	 * @param event the event to call
	 */
	public static void callEvent(Event event) {
		event.getHandlerList().runEvent(event);
	}

}
