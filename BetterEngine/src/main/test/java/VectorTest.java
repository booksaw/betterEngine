package main.test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.booksaw.betterEngine.movement.Vector;

class VectorTest {

	@Test
	void subtractVectorTest() {
		Vector v = Vector.createVectorFromXY(0, 0);
		Vector v2 = Vector.createVectorFromXY(1, 1);

		v.subtractVector(v2);

		assertEquals(-1, v.getX());
		assertEquals(-1, v.getY());
	}

	@Test
	void dotProductTest1() {
		// TEST 1
		Vector v = Vector.createVectorFromXY(0, 0);
		Vector v2 = Vector.createVectorFromXY(1, 1);

		double result = Vector.dotProduct(v, v2);

		assertEquals(0, result);
	}

	@Test
	void dotProductTest2() {
		// TEST 2
		Vector v3 = Vector.createVectorFromXY(2, 2);
		Vector v4 = Vector.createVectorFromXY(1, 1);

		double result2 = Vector.dotProduct(v3, v4);

		assertEquals(4, result2);
	}

}
