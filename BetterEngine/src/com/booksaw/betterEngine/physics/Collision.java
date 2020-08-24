package com.booksaw.betterEngine.physics;

import com.booksaw.betterEngine.movement.Vector;
import com.booksaw.betterEngine.object.Object;
import com.booksaw.betterEngine.physics.shape.Circle;
import com.booksaw.betterEngine.physics.shape.Edge;

public class Collision {

	/**
	 * Used to resolve a collision between two objects
	 * 
	 * @param a The first object
	 * @param b The second object
	 */
	public static void resolveCollision(Object a, Object b) {
		Vector normal = Vector.getNormal(a.getVelocity(), b.getVelocity());
		System.out.println("resolving");
		// Calculate relative velocity
		Vector rv = b.getVelocity().getCopy();
		rv.subtractVector(a.getVelocity());

		// Calculate relative velocity in terms of the normal direction
		double velAlongNormal = Vector.dotProduct(rv, normal);

		// Do not resolve if velocities are separating
//		if (velAlongNormal > 0) {
//			return;
//		}

		// TODO fix velAlongNormal

		// Calculate restitution
		double e = Math.min(a.getRestitution(), b.getRestitution());

		// Calculate impulse scalar
		double j = -(1 + e) /* * velAlongNormal */;

		j /= a.getInverseMass() + b.getInverseMass();

		// Apply impulse
		Vector impulse = Vector.multiplyScaler(normal, j);
		Vector aChange = Vector.multiplyScaler(impulse, a.getInverseMass());
		aChange.invert();
		System.out.println("applying a = " + aChange);
		a.applyVector(aChange);
		System.out.println("applying b  = " + Vector.multiplyScaler(impulse, b.getInverseMass()));
		b.applyVector(Vector.multiplyScaler(impulse, b.getInverseMass()));
	}

	/**
	 * Used to check if a circle is colliding with an edge
	 * <p>
	 * Only run if their bounding boxes collide else this will provide false
	 * positives
	 * </p>
	 * 
	 * @param circle The circle to check
	 * @param edge   The edge to check
	 * @return If they are colliding
	 */
	public boolean isColliding(Circle circle, Edge edge) {
		// TODO FIX
		// finding the shortest distance between the point and the line
		double distance = Math.abs((-edge.getGradient() * circle.getLocation().getX()) + circle.getLocation().getY()
				- edge.getYIntercept()) / Math.sqrt(Math.pow(edge.getGradient(), 2) + 1);

		if (distance <= circle.getRadius()) {
			return true;
		}

		return false;
	}

	// TODO
//	public static void PositionalCorrection(Object A, Object B) {
//	  final double percent = 0.2; // usually 20% to 80%
//	  
//	  Vector correction = penetrationDepth / (A.inv_mass + B.inv_mass)) * percent * n
//	  A.position -= A.inv_mass * correction
//	  B.position += B.inv_mass * correction
//	}

	public Collision(Object object) {

	}

}
