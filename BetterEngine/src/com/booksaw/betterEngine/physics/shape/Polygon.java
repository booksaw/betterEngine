package com.booksaw.betterEngine.physics.shape;

import java.util.List;

import com.booksaw.betterEngine.movement.Location;

/**
 * Used to define a polygon which does not have a specific class
 * 
 * @author booksaw
 *
 */
public class Polygon extends Shape {

	private List<Location> verticies;

	public Polygon(List<Location> verticies) {
		this.verticies = verticies;
	}

	@Override
	public BoundingBox getBoundingBox() {

		Double minx = null, miny = null, maxx = null, maxy = null;

		for (Location location : verticies) {
			if (minx == null || minx > location.getX()) {
				minx = location.getX();
			} else if (maxx == null || maxx < location.getX()) {
				maxx = location.getX();
			}

			if (miny == null || miny > location.getY()) {
				miny = location.getY();
			} else if (maxy == null || maxy < location.getY()) {
				maxy = location.getY();
			}
		}

		return new BoundingBox(minx, miny, maxx - minx, maxy - miny);
	}

	@Override
	public List<Location> getVerticies() {
		return verticies;
	}

}
