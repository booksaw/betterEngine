package com.booksaw.betterEngine.physics.shape;

import com.booksaw.betterEngine.movement.Location;

public class Circle {

	private Location location;
	private double radius;

	public Circle(Location location, double radius) {
		this.location = location;
		this.radius = radius;
	}

	public boolean isColliding(Circle circle) {
		double r = radius + circle.radius;
		r *= r;
		return r < Math.pow((location.getX() + circle.location.getX()), 2)
				+ Math.pow((location.getY() + circle.location.getY()), 2);
	}

	public Location getLocation() {
		return location;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
