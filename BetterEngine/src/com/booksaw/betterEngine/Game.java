package com.booksaw.betterEngine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;

import com.booksaw.betterEngine.camera.Camera;
import com.booksaw.betterEngine.object.Object;
import com.booksaw.betterEngine.objectRendering.ObjectRenderer;

/**
 * This class is used to manage an instance of a game
 * 
 * @author booksaw
 *
 */
public class Game {

	private final HashMap<Object, ObjectRenderer> objects = new HashMap<>();
	private Color backgroundColor;
	private Camera camera;

	public Game(Dimension gameDimensions) {
		camera = new Camera(gameDimensions);
	}

	public void paint(Graphics g) {

		// filling the background
		g.setColor(backgroundColor);
		g.fillRect(0, 0, 1000, 1000);
		Rectangle cameraCollision = camera.getLooseCollision();
		objects.forEach((obj, renderer) -> {
			if (cameraCollision.intersects(renderer.getLooseCollision())) {
				renderer.paint(g, camera);
			}
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

}
