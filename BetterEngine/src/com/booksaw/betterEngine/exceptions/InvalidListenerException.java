package com.booksaw.betterEngine.exceptions;

/**
 * This is thrown when an event fails to register due to a missing static method
 * 
 * @author booksaw
 *
 */
public class InvalidListenerException extends IllegalArgumentException {

	private static final long serialVersionUID = -7097287210710900617L;

	public InvalidListenerException(Class<?> cls) {
		super("Expected to find the public method: 'public static List<Listener> getHandlersList()' in " + cls
				+ " but did not. Event could not be registered");
	}

}
