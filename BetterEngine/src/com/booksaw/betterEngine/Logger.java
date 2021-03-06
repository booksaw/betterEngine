package com.booksaw.betterEngine;

public class Logger {

	/**
	 * Used to log a message after all formatting is carried out
	 * 
	 * @param message the message to log
	 */
	private static void logRawMessage(String message) {
		System.out.println(message);
	}

	/**
	 * Used to log information to the console
	 * 
	 * @param message the information to log
	 */
	public static void info(String message) {
		logRawMessage("[INFO] " + message);
	}

	/**
	 * Used to log a warning message to the console
	 * 
	 * @param message the warning message
	 */
	public static void warning(String message) {
		logRawMessage("[WARN] " + message);
	}

	/**
	 * Used to log an error message to the console
	 * 
	 * @param message the error message
	 */
	public static void error(String message) {
		logRawMessage("[ERROR] " + message);
	}

}
