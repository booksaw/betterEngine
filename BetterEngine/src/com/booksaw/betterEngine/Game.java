package com.booksaw.betterEngine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.booksaw.betterEngine.camera.Camera;
import com.booksaw.betterEngine.gameRendering.RenderManager;
import com.booksaw.betterEngine.object.Object;
import com.booksaw.betterEngine.objectRendering.ObjectRenderer;
import com.booksaw.betterEngine.physics.Collision;
import com.booksaw.betterEngine.timing.GameClock;
import com.booksaw.betterEngine.timing.Updatable;

/**
 * This class is used to manage an instance of a game
 * 
 * @author booksaw
 *
 */
public class Game implements Updatable {

	/**
	 * The default background color of the game
	 */
	private Color backgroundColor;

	/**
	 * The camera which manages what the user can see
	 */
	private Camera camera;

	/**
	 * A list of all objects contained within this level
	 */
	private final HashMap<Object, ObjectRenderer> objects = new HashMap<>();

	/**
	 * The class which manages all timing and repainting of the game render.
	 */
	private final RenderManager renderManager;

	/**
	 * Used to run any update events during the game
	 */
	private final GameClock gameClock;

	public Game(Dimension gameDimensions) {
		camera = new Camera(gameDimensions);
		gameClock = new GameClock();
		gameClock.addUpdateable(this);
		gameClock.setActive(true);

		renderManager = new RenderManager(this);
		renderManager.getClock().start();

		// loading the keybinds

	}

	public void paint(Graphics g) {

		// filling the background
		g.setColor(backgroundColor);
		g.fillRect(0, 0, 1000, 1000);
//		Rectangle cameraCollision = camera.getLooseCollision();
		objects.forEach((obj, renderer) -> {
			// TODO fix
//			if (cameraCollision.intersects(renderer.getLooseCollision())) {
			renderer.paint(g, camera);
//			}
		});
	}

	public void addObject(Object object) {
		objects.put(object, object.getRenderer());
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public GameClock getGameClock() {
		return gameClock;
	}

	public Camera getCamera() {
		return camera;
	}

	public RenderManager getRenderManager() {
		return renderManager;
	}

	@Override
	public void update() {
//		checkCollisions();
	}

	/**
	 * Used to cehck if this object is colliding with another
	 * <p>
	 * Any collision found between this object and another will be resolved
	 * </p>
	 * 
	 * @param object The object to check
	 * @return If any collisions have been resolved (used to cancel location
	 *         updates)
	 */
	public boolean checkCollisions(Object object) {
		boolean toReturn = false;
		for (Object i : objects.keySet()) {

			if (i == object) {
				continue;
			}

			if (object.getBoundingBox().isColliding(i.getBoundingBox())) {
				Collision.resolveCollision(object, i);
				toReturn = true;
			}

		}
		return toReturn;
	}

	/**
	 * Used to check and resolve all collisions, NOTE this will not push objects out
	 * of each other
	 */
	public void checkCollisions() {
		List<Object> checked = new ArrayList<>();
		for (Object obj : objects.keySet()) {
			checked.add(obj);

			for (Object i : objects.keySet()) {
				if (checked.contains(i)) {
					continue;
				}

				if (obj.getBoundingBox().isColliding(i.getBoundingBox())) {
					Collision.resolveCollision(obj, i);
				}

			}

		}
	}

}
