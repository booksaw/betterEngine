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
	 * @return The created vector
	 */
	public static Vector createVectorFromModArg(double mod, double argument) {
		Vector v = new Vector();
		v.setModArg(mod, argument);
		return v;
	}

	/**
	 * Used to create a vector with an x and y component of 0
	 * 
	 * @return The created vector
	 */
	public static Vector createBlankVector() {
		return new Vector();
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
	public static double dotProduct(Vector v1, Vector v2) {
		return (v1.x * v2.x) + (v1.y * v2.y);
	}

	/**
	 * Used to get the angle between two vectors
	 * 
	 * @param v1 The first vector
	 * @param v2 The second vector
	 * @return The angle between the two vectors in radians
	 */
	public static double getAngle(Vector v1, Vector v2) {
		return Math.acos(dotProduct(v1, v2) / (v1.getModulus() * v2.getModulus()));
	}

	public static double crossProduct(Vector v1, Vector v2) {
		return (v1.x * v2.y) + (v1.y * v2.x);
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

	/**
	 * Used to multiply this vector with another vector
	 * 
	 * @param vector the other vector
	 */
	public void multiplyVector(Vector vector) {
		x *= vector.x;
		y *= vector.y;
	}

	/**
	 * Used to divide this vector by another vector
	 * 
	 * @param vector the other vector
	 */
	public void divideVector(Vector vector) {
		x /= vector.x;
		y /= vector.y;
	}

	/**
	 * Used to turn this vector into a unit vector of the same direction
	 */
	public void normalize() {
		divideScaler(getModulus());
	}

	/**
	 * Used to invert the vector so it is the exact opposite direction
	 */
	public void invert() {
		x = -x;
		y = -y;
	}

	// END OF VECTOR MANIPULATION

	/**
	 * Used to compare two vectors
	 * 
	 * @param vector The vector to compare this vector to
	 * @return True if they are the same, False if they are different
	 */
	public boolean equals(Vector vector) {
		return (x == vector.x) && (y == vector.y);
	}

	/**
	 * @return A new vector with the exact details as this one
	 */
	public Vector getCopy() {
		Vector v = new Vector();
		v.x = x;
		v.y = y;
		return v;
	}

	@Override
	public String toString() {
		return "Vector[" + x + ", " + y + "]";
	}
}
