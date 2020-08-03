package com.booksaw.betterEngine.timing;

import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.booksaw.betterEngine.Logger;

public abstract class Clock implements ActionListener {

	/**
	 * The timer which is being used to call the action
	 */
	private final Timer timer;

	/**
	 * Used to create a new rendering clock
	 * 
	 * @param manager the game manager which the render clock is associated with
	 */
	public Clock(int delay) {
		timer = new Timer(delay, this);
	}

	/**
	 * 
	 * @return if the rendering time is active
	 */
	public boolean isActive() {
		return timer.isRunning();
	}

	/**
	 * Sets if the rendering timer is active or not
	 * 
	 * @param active if the timer should be active
	 */
	public void setActive(boolean active) {
		if (active && !isActive()) {
			Logger.info("Starting clock instance: " + this);
			timer.start();
		} else if (isActive() && !active) {
			Logger.info("Stopping clock instance: " + this);
			timer.stop();
		}
	}

	public void toggleActive() {
		setActive(!isActive());
	}

	/**
	 * Used for a more readable timer start
	 */
	public void start() {
		setActive(true);
	}

	/**
	 * Used for a more readable timer stop
	 */
	public void stop() {
		setActive(false);
	}
}
