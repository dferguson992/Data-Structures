package com.dferguso.arrays;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dferguso.arrays.EduArray.EduArrayProperties;
import com.dferguso.arrays.EduArray.EduArrayType;

class EduArrayTest {

	static EduArray intArray;
	static EduArray floatArray;

	static EduArrayProperties intEduArrayProperties = new EduArrayProperties();
	static EduArrayProperties floatEduArrayProperties = new EduArrayProperties();

	@BeforeAll
	public static void initAll() {
		intEduArrayProperties.setLevel(Level.INFO);
		intEduArrayProperties.setSize(10);
		intEduArrayProperties.setType(EduArrayType.INTEGER);

		floatEduArrayProperties.setLevel(Level.INFO);
		floatEduArrayProperties.setSize(10);
		floatEduArrayProperties.setType(EduArrayType.FLOAT);

		intArray = new EduArray(intEduArrayProperties);
		floatArray = new EduArray(floatEduArrayProperties);
	}

	@BeforeEach
	public void init() {
		intArray = new EduArray(intEduArrayProperties);
		floatArray = new EduArray(floatEduArrayProperties);
	}

	@AfterEach
	public void destroy() {
		intArray.clearIntegers();
		floatArray.clearFloats();
	}

	@AfterAll
	public static void destroyAll() {
		intEduArrayProperties = null;
		floatEduArrayProperties = null;
		intArray = null;
		floatArray = null;
	}

	@Test
	void writeIntegerTest() {
		boolean result = false;
		int i = 1;
		int index = 0;
		intArray.write(index, i);
		if (intArray.readInteger(index).isPresent() && intArray.readInteger(index).get() == i) {
			result = true;
		}
		assertTrue(result);
	}

	@Test
	void writeFloatTest() {
		boolean result = false;
		float f = 1F;
		int index = 0;
		floatArray.write(index, f);
		if (floatArray.readFloat(index).isPresent() && floatArray.readFloat(index).get() == f) {
			result = true;
		}
		assertTrue(result);
	}

}
