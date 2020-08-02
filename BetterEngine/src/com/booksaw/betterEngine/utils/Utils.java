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

}
