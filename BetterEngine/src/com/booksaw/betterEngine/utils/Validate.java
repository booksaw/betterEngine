package com.booksaw.betterEngine.utils;

import java.io.File;

/**
 * Used to validate a variable contains the expected information
 * 
 * @author booksaw
 *
 */
public class Validate {

	/**
	 * Used to check if the given file exists
	 * 
	 * @param f The file to check for
	 */
	public static void exists(File f) {
		exists(f, "File: " + f.getAbsolutePath() + " was not found");
	}

	/**
	 * Used to check if the given file exists
	 * 
	 * @param f            The file to check for
	 * @param errorMessage The error message to throw
	 */
	public static void exists(File f, String errorMessage) {
		if (f == null || !f.exists()) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	/**
	 * Used to verify if the provided object is null
	 * 
	 * @param object The object to verify
	 */
	public static void notNull(Object object) {
		notNull(object, "Provided object was null");
	}

	/**
	 * Used to verify if the provided object is null
	 * 
	 * @param object       The object to verify
	 * @param errorMessage The error message to display if the object is null
	 */
	public static void notNull(Object object, String errorMessage) {
		if (object == null) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

}
