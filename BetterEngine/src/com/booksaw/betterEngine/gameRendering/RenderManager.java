package com.booksaw.betterEngine.gameRendering;

import java.util.ArrayList;
import java.util.List;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.timing.RenderClock;

/**
 * Used to manage the rendering all instances of a game
 * 
 * @author booksaw
 *
 */
public class RenderManager {

	private final RenderClock clock;

	public RenderManager(Game game) {
		clock = new RenderClock(game);
	}

	/**
	 * @return the clock which manages rendering
	 */
	public RenderClock getClock() {
		return clock;
	}

	private final List<GameRenderer> instances = new ArrayList<>();

	/**
	 * Used to add a new instance of a renderer to the list
	 * 
	 * @param render the renderer to add
	 */
	public void addInstance(GameRenderer render) {
		instances.add(render);
	}

	/**
	 * Used to remove an instance of a renderer from the list
	 * 
	 * @param render the renderer to remove
	 */
	public void removeInstance(GameRenderer render) {
		instances.remove(render);
	}

	/**
	 * Used to repaint all instances of the renderer
	 */
	public void repaint() {
		instances.forEach(render -> {
			render.repaint();
		});
	}

}
