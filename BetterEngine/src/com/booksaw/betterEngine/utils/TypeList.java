package com.booksaw.betterEngine.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Used to store a list of classes not in instance form
 * 
 * @author booksaw
 *
 * @param <T> The parent type of all the classes
 */
public class TypeList<T> {

	private final HashMap<String, Class<? extends T>> registeredClasses = new HashMap<>();

	/**
	 * Used to add a new value to the type list
	 * 
	 * @param key        The key of the class to add
	 * @param toRegister The class to register
	 * @throws NullPointerException if the key or value is null
	 */
	public void add(String key, Class<? extends T> toRegister) {

		if (toRegister == null || key == null) {
			throw new NullPointerException("Key or value cannot be null");
		}

		registeredClasses.put(key, toRegister);
	}

	/**
	 * Used to remove a value from the
	 * 
	 * @param key The key of the value to remove
	 * @throws NullPointerException If the key provided is null
	 */
	public void remove(String key) {
		if (key == null) {
			throw new NullPointerException("Key or value cannot be null");
		}
		registeredClasses.remove(key);

	}

	/**
	 * Used to get the class stored with that key
	 * 
	 * @param key The key to get the class of
	 */
	public Class<? extends T> get(String key) {
		return registeredClasses.get(key);
	}

	/**
	 * Used to check if a specific key is within the type list
	 * 
	 * @param key The key to check for
	 * @return If the list contains the key
	 */
	public boolean containsKey(String key) {
		return registeredClasses.containsKey(key);
	}

	/**
	 * Used to check if a specific value is within the type list
	 * 
	 * @param value The value to check for
	 * @return If the list contains the value
	 */
	public boolean containsValue(Class<? extends T> value) {
		return registeredClasses.containsValue(value);
	}

	/**
	 * Used to create an instance of that type has no constructor
	 * 
	 * @param instance The instance to create
	 * @return The created instance
	 * @throws SecurityException         Error caused by creating an instance
	 * @throws NoSuchMethodException     Error caused by creating an instance
	 * @throws InvocationTargetException Error caused by creating an instance
	 * @throws IllegalArgumentException  Error caused by creating an instance
	 * @throws IllegalAccessException    Error caused by creating an instance
	 * @throws InstantiationException    Error caused by creating an instance
	 */
	public T createInstance(Class<? extends T> type)
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NullPointerException {

		if (type == null) {
			throw new NullPointerException("Type provided cannot be null");
		}

		Constructor<? extends T> construct = type.getConstructor();
		return construct.newInstance();
	}

	/**
	 * Used to create an instance of that type that has no constructor
	 * 
	 * @param key The key of the type
	 * @return the created instance
	 * @throws NoSuchMethodException     Error caused by creating an instance
	 * @throws SecurityException         Error caused by creating an instance
	 * @throws InstantiationException    Error caused by creating an instance
	 * @throws IllegalAccessException    Error caused by creating an instance
	 * @throws IllegalArgumentException  Error caused by creating an instance
	 * @throws InvocationTargetException Error caused by creating an instance
	 * @throws NullPointerException      Error caused by creating an instance
	 */
	public T createInstance(String key) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NullPointerException {
		return createInstance(get(key));
	}

}
