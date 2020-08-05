package com.booksaw.betterEngine.object;

import com.booksaw.betterEngine.movement.Location;

public class Circle {

	public Location location;
	public double radius;

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

}
