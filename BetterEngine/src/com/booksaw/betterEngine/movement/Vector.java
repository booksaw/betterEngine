package com.booksaw.betterEngine.movement;

public class Vector {

	// VECTOR CREATION METHODS
	/**
	 * used to create a vector from an x and y component
	 * 
	 * @param x The x vector component
	 * @param y The y vector component
	 * @return The created vector
	 */
	public static Vector createVectorFromXY(double x, double y) {
		Vector v = new Vector();
		v.setX(x);
		v.setY(y);
		return v;
	}

	/**
	 * Used to create a vector from the modulus and argument
	 * 
	 * @param mod      The modulus (magnitude) of the vector
	 * @param argument The argument (angle) of the vector in radians
	 */
	public static Vector createVectorFromModArg(double mod, double argument) {
		Vector v = new Vector();
		v.setModArg(mod, argument);
		return v;
	}

	// END OF VECTOR CREATION METHODS

	// STATIC VECTOR MANIPULATION METHODS

	/**
	 * Used to find the dot product between two vectors
	 * 
	 * @param v1 The first vector
	 * @param v2 the second vector
	 * @return The dot product of the two vectors
	 */
	public double dotProduct(Vector v1, Vector v2) {
		return (v1.x * v2.x) + (v1.y * v2.y);
	}

	/**
	 * Used to get the angle between two vectors
	 * 
	 * @param v1 The first vector
	 * @param v2 The second vector
	 * @return The angle between the two vectors in radians
	 */
	public double getAngle(Vector v1, Vector v2) {
		return Math.acos(dotProduct(v1, v2) / (v1.getModulus() * v2.getModulus()));
	}

	// END OF STATIC VECTOR MANIPULATION METHODS

	private double x = 0;
	private double y = 0;

	private Vector() {

	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the modulus (magnitude) of this vector
	 */
	public double getModulus() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	/**
	 * @return the argument (angle) of this vector
	 */
	public double getArgument() {
		return Math.atan(y / x);
	}

	/**
	 * Used to set the modulus and argument of the vector
	 * 
	 * @param mod      The modulus (magnitude) of the vector
	 * @param argument The argument (angle) of the vector in radians
	 */
	public void setModArg(double mod, double argument) {
		x = Math.cos(argument) * mod;
		y = Math.sin(argument) * mod;
	}

	// VECTOR MANIPULATION

	/**
	 * This is used to add the provided vector to this one
	 * 
	 * @param vector The vector to add to this one
	 * 
	 */
	public void addVector(Vector vector) {
		x += vector.x;
		y += vector.y;
	}

	/**
	 * This is used to subtract the provided vector from this one
	 * 
	 * @param vector The vector to subtract from this one
	 * 
	 */
	public void subtractVector(Vector vector) {
		x -= vector.x;
		y -= vector.y;
	}

	/**
	 * Used to multiply both axes by a scalar
	 * 
	 * @param scaler The scaler to multiply by
	 */
	public void multiplyScaler(double scaler) {
		x *= scaler;
		y *= scaler;
	}

	/**
	 * Used to divide both axes by a scaler
	 * 
	 * @param scaler The scaler to multiply by
	 */
	public void divideScaler(double scaler) {
		x /= scaler;
		y /= scaler;
	}

	// END OF VECTOR MANIPULATION

}
