package main.test.java.typeList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.booksaw.betterEngine.utils.TypeList;

class TypeListTest {

	@Test
	void addNullValue() {
		TypeList<TypeMain> list = new TypeList<>();

		try {
			list.add(null, null);
			fail("Expected error not thrown");
		} catch (NullPointerException e) {
			return;
		}

		fail("Wrong Error Thrown");

	}

	@Test
	void addValidValue() {
		TypeList<TypeMain> list = new TypeList<>();

		list.add("test", TypeMain.class);

		assertTrue(list.containsKey("test"));
		assertTrue(list.containsValue(TypeMain.class));

	}

	@Test
	void removeValidValue() {
		TypeList<TypeMain> list = new TypeList<>();

		list.add("test", TypeMain.class);
		list.remove("test");

		assertFalse(list.containsKey("test"));
		assertFalse(list.containsValue(TypeMain.class));
	}

	@Test
	void createInstance() {
		TypeList<TypeMain> list = new TypeList<>();

		list.add("test", TypeMain.class);

		try {
			TypeMain test = list.createInstance("test");
			if (!(test instanceof TypeMain)) {
				fail("Type of the produced instance was invalid");
			}
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NullPointerException e) {
			e.printStackTrace();
			fail("Error called when not expected");
		}

	}

}
