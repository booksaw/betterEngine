package com.booksaw.betterEngine.utils;

import java.io.File;
import java.io.IOException;

import com.booksaw.betterEngine.Logger;

/**
 * A class to contain all file management utilities
 * 
 * @author booksaw
 *
 */
public class FileUtils {

	/**
	 * This method is used to load a file
	 * <p>
	 * If the file does not exist, a new file in that place will be created
	 * </p>
	 * 
	 * @param path the path leading to the file
	 * @return The file that has been loaded
	 */
	public File loadOrCreate(String path) {

		File f = new File(path);

		if (!f.exists()) {
			try {
				Logger.warning("Could not find the file at " + path + " creating one.");
				f.createNewFile();
			} catch (IOException e) {
				Logger.error("Could not create the file at the path " + path);
				e.printStackTrace();
			}
		}

		return f;

	}

}
