package com.booksaw.betterEngine;

import java.awt.Graphics;
import java.util.HashMap;

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

	public void paint(Graphics g) {

		objects.forEach((obj, renderer) -> {
			renderer.paint(g, 5, 400);
		});
	}

	public void addObject(Object object) {
		objects.put(object, object.getRenderer());
	}
	
}
