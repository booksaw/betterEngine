package com.booksaw.betterEngine.event;

/**
 * Used to store the priorities of events
 * 
 * @author booksaw
 *
 */
public enum EventPriority {

	/**
	 * Lowest is run first, Highest is run last
	 */
	LOWEST(0), LOW(1), NORMAL(2), HIGHT(3), HIGHEST(4), MONITOR(5);

	/**
	 * This is the value that the priority has, used for sorting the list of events
	 */
	private final int value;

	private EventPriority(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
