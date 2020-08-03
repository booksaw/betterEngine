package com.booksaw.betterEngine.timing;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import com.booksaw.betterEngine.Logger;

/**
 * This is used within a game to track aspects of the game which need updating,
 * This clock will run 10 times a second
 * 
 * @author booksaw
 *
 */
public class GameClock extends Clock {

	/**
	 * This is used to track when the previous update occurred, so if there is a lag
	 * within the clock, it can be accounted for
	 */
	private transient long previousUpdate = -1;

	private final List<Updatable> toUpdate = new ArrayList<>();

	public GameClock() {
		super(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (previousUpdate == -1) {
			previousUpdate = System.currentTimeMillis();
			return;
		}

		int difference = (int) (System.currentTimeMillis() - previousUpdate);

		if (difference > 20) {
			Logger.warning("The game is running " + difference + " updates behind, skipping to present");
			difference = 1;
		}

		for (int i = 0; i < difference; i++) {
			update();
		}

		previousUpdate = System.currentTimeMillis();
	}

	public void addUpdateable(Updatable update) {
		toUpdate.add(update);
	}

	/**
	 * Used to run an update
	 */
	public void update() {
		toUpdate.forEach(update -> {
			update.update();
		});
	}

}
