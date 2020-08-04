package com.booksaw.betterEngine.utils;

import java.io.File;
import java.io.InputStream;

/**
 * This class contains general useful methods which do not relate to any of the
 * more specific utils cases
 * 
 * @author booksaw
 *
 */
public class Utils {

	/**
	 * Used to get a resource compiled within the betterEngine.jar file. It will be
	 * assumed that the resource is in /resources/
	 * 
	 * @param name The name of the resource including any file path after
	 *             /resources/
	 * @return The resource stream for that compiled resource
	 */
	public static InputStream getCompiledResouce(String name) {
		return ClassLoader.getSystemResourceAsStream(
				"com" + File.separator + "booksaw" + File.separator + "resources" + File.separator + name);

	}

	/**
	 * Used to convert meters per second to meters per tick (for movement code)
	 * 
	 * @param mps The meters per second value
	 * @return The converted value
	 */
	public static double mpsToMpt(double mps) {
		return mps / 100;
	}

	/**
	 * Used to convert meters per tick to meters per seconds (for movement code)
	 * 
	 * @param mpt The meters per second value
	 * @return The converted value
	 */
	public static double mptToMps(double mpt) {
		return mpt * 100;
	}

}
