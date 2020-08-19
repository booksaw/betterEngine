package com.booksaw.betterEngine.modifier;

/**
 * Class used to store a modifier value for an object or the level as a whole
 * 
 * @author booksaw
 *
 */
public class Modifier {

	private final String reference;

	private Object value;

	public Modifier(String reference, Object value) {
		this.reference = reference;
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getReference() {
		return reference;
	}

	/**
	 * @return the modifier value as a string type
	 */
	public String getString() {
		return value.toString();
	}

	/**
	 * @return the modifier value as an int type. Will return 0 if the modifier is
	 *         not an integer
	 */
	public int getInt() {

		if (value instanceof Integer) {
			return (Integer) value;
		}
		try {
			return Integer.parseInt(getString());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/**
	 * @return The modifier value as a double type. Will return 0 if the modifier is
	 *         not a double
	 */
	public double getDouble() {
		if (value instanceof Double) {
			return (Double) value;
		}

		try {
			return Double.parseDouble(getString());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/**
	 * @return the modifier value as a boolean type. Will return false if the
	 *         modifier is not a boolean
	 */
	public boolean getBoolean() {
		if (value instanceof Boolean) {
			return (Boolean) value;
		}

		return Boolean.parseBoolean(getString());
	}

}
