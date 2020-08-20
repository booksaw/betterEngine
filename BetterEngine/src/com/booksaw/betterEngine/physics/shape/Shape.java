package com.booksaw.betterEngine.physics.shape;

import java.util.List;

import com.booksaw.betterEngine.movement.Location;

public abstract class Shape {

	/**
	 * @return The AABB around this shape
	 */
	public abstract BoundingBox getBoundingBox();

	/**
	 * @return A list of all verticies within the shape
	 */
	public abstract List<Location> getVerticies();

}
