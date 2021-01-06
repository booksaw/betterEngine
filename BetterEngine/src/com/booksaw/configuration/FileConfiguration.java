package com.booksaw.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.booksaw.betterEngine.utils.Validate;

public abstract class FileConfiguration {

	/**
	 * Storing details about this configuration
	 */
	protected ConfigurationOptions configurationOptions;

	public FileConfiguration() {

		configurationOptions = getConfigurationOptions();

	}

	/**
	 * Used to load configuration information from a file
	 * 
	 * @param f The file to load information from
	 * @throws FileNotFoundException thrown for any file errors
	 */
	public void load(File f) throws IOException {
		Validate.exists(f);

		load(new BufferedReader(new FileReader(f)));
	}

	/**
	 * Used to load information from the given reader
	 * 
	 * @param reader The reader to load information from
	 * @throws FileNotFoundException Thrown for any file errors
	 */
	public void load(Reader reader) throws IOException {
		Validate.notNull(reader, "Provided reader cannot be null");

		BufferedReader input = (reader instanceof BufferedReader) ? (BufferedReader) reader
				: new BufferedReader(reader);
		StringBuilder builder = new StringBuilder();
		try {
			String line;
			while ((line = input.readLine()) != null) {
				builder.append(line);
				builder.append(configurationOptions.lineEndStr);
			}
		} finally {
			input.close();
		}
		loadFromString(builder.toString());
	}

	// ABSTRACT METHODS

	/**
	 * Used to load information into this configuration section (not requiring file
	 * reading etc)
	 * 
	 * @param contents The values
	 */
	public abstract void loadFromString(String contents);

	/**
	 * Used to return all values required for loading this specific type of
	 * configuration
	 * 
	 * @return The configuration options
	 */
	public abstract ConfigurationOptions getConfigurationOptions();

	/**
	 * Used to get the object with that reference
	 * 
	 * @param reference The reference to search for
	 * @return The object to get
	 */
	public abstract Object get(String reference);

	/**
	 * Used to get the string with that reference
	 * 
	 * @param reference The reference to search for
	 * @return The object to get
	 */
	public abstract String getString(String reference);

	public abstract void save(File f) throws IOException;
}
