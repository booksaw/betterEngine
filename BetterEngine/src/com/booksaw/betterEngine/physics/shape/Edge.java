package com.booksaw.betterEngine.physics.shape;

import java.util.ArrayList;
import java.util.List;

import com.booksaw.betterEngine.movement.Location;

/**
 * Used to represent an edge of a shape
 * 
 * @author booksaw
 *
 */
public class Edge extends Shape {

	/**
	 * Used to get the gradient between two points
	 * 
	 * @param a The first point
	 * @param b The second point
	 * @return The gradient of the connecting line
	 */
	public static double getGradient(Location a, Location b) {

		// if b is smaller than a, running this method in inverted order
		if (b.getX() < a.getX()) {
			return getGradient(b, a);
		}

		return (b.getY() - a.getY()) / (b.getX() - a.getX());

	}

	private Location a, b;

	public Edge(Location a, Location b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public BoundingBox getBoundingBox() {
		// inline if statements to find bottom left corner
		// simple finding 1d differences to get width / height
		return new BoundingBox(a.getX() < b.getX() ? a.getX() : b.getX(), a.getY() < b.getY() ? a.getY() : b.getY(),
				Math.abs(a.getX() - b.getX()), Math.abs(a.getY() - b.getY()));
	}

	/**
	 * @return The gradient of this line
	 */
	public double getGradient() {
		return getGradient(a, b);
	}

	/**
	 * @return The Y intercept if this edge was extended to a linear equation
	 */
	public double getYIntercept() {
		return a.getY() - (getGradient() * a.getX());
	}

	@Override
	public List<Location> getVerticies() {
		List<Location> verticies = new ArrayList<>();

		verticies.add(a);
		verticies.add(b);

		return verticies;
	}

	public boolean isColliding(Edge edge) {
		double m1 = getGradient();
		double m2 = edge.getGradient();

		// parallel
		if (m1 == m2) {
			// if their y intercept is the same
			if (getYIntercept() == edge.getYIntercept()) {
				return true;
			}
			return false;
		}

		// checking if they share an x coord
		double x = (getYIntercept() - edge.getYIntercept()) / (edge.getGradient() - getGradient());
		// this will always produce a response as 2 non parallel lines will always
		// collide somewhere...
		// checking if the collision is within the actual collision part of the line
		BoundingBox intersection = BoundingBox.getIntersectingBox(getBoundingBox(), edge.getBoundingBox());
		if (intersection.getX() >= x && intersection.getWidth() + intersection.getX() <= x) {
			return true;
		}
		return false;
	}
}
