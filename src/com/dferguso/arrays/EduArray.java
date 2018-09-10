/**
 * 
 */
package com.dferguso.arrays;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dan
 *
 */
public class EduArray {

	private static final int DEFAULT_INTEGER_VALUE = 0;
	private static final float DEFAULT_FLOAT_VALUE = 0F;
	private static final float DEFAULT_CAPACITY_SCALING_FACTOR = 1.5F;
	private static final int DEFAULT_ARRAY_SIZE = 10;
	private static final EduArrayType DEFAULT_ARRAY_TYPE = EduArrayType.INTEGER;
	private static final Level DEFAULT_ARRAY_LOGGING_LEVEL = Level.INFO;

	private final Logger logger = Logger.getLogger(EduArray.class.getName());
	private Level level = null;
	private EduArrayType type = null;

	// THE MAXIMUM NUMBER OF ELEMENTS IN THE ARRAY
	private int size = 0;
	// THE CURRENT NUMBER OF ELEMENTS IN THE ARRAY
	private int count = 0;

	static class EduArrayProperties {
		private Level level = DEFAULT_ARRAY_LOGGING_LEVEL;
		private EduArrayType type = DEFAULT_ARRAY_TYPE;
		private int size = DEFAULT_ARRAY_SIZE;
		private float cacpacityScalingFactor = DEFAULT_CAPACITY_SCALING_FACTOR;

		private boolean optionalTypes = false;

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public Level getLevel() {
			return level;
		}

		public void setLevel(Level level) {
			this.level = level;
		}

		public EduArrayType getType() {
			return type;
		}

		public void setType(EduArrayType type) {
			this.type = type;
		}

		public boolean isOptionalTypes() {
			return optionalTypes;
		}

		public void setOptionalTypes(boolean optionalTypes) {
			this.optionalTypes = optionalTypes;
		}

		public float getCacpacityScalingFactor() {
			return cacpacityScalingFactor;
		}

		public void setCacpacityScalingFactor(float cacpacityScalingFactor) {
			this.cacpacityScalingFactor = cacpacityScalingFactor;
		}

	}

	private int[] intArray;
	private float[] floatArray;

	public EduArray(EduArrayProperties eduArrayProperties) {

		this.size = eduArrayProperties.getSize();
		this.level = eduArrayProperties.getLevel();
		this.type = eduArrayProperties.getType();

		this.logger.setLevel(eduArrayProperties.getLevel());

		switch (this.type) {
		case FLOAT:
			this.floatArray = new float[size];
			break;
		case INTEGER:
			this.intArray = new int[size];
			break;
		default:
			this.intArray = new int[size];
			// CONSIDER THROWING AN ERROR HERE
			break;
		}
	}

	public int getArraySize() {
		return size;
	}

	public void setArraySize(int arraySize) {
		this.size = arraySize;
	}

	public Level getLoggingLevel() {
		return level;
	}

	public void setLoggingLevel(Level level) {
		this.level = level;
	}

	public void write(int index, int i) {
		if (this.type == EduArrayType.INTEGER) {
			if (index < this.size) {
				this.intArray[index] = i;
				this.count++;
			} else {
				// INCREASE ARRAY SIZE
				// RE-ATTEMPT
			}
		}
	}

	public void write(int index, float f) {
		if (this.type == EduArrayType.FLOAT) {
			if (index < this.size) {
				this.floatArray[index] = f;
				this.count++;
			} else {
				// INCREASE ARRAY SIZE
				// RE-ATTEMPT
			}
		}
	}

	public Optional<Integer> readInteger(int index) {
		Optional<Integer> returnThis = Optional.empty();

		if (this.type == EduArrayType.INTEGER) {
			if (index < this.size) {
				returnThis = Optional.ofNullable(this.intArray[index]);
			} else {
				returnThis = Optional.empty();
			}
		} else {
			returnThis = Optional.empty();
		}

		return returnThis;
	}

	public Optional<Float> readFloat(int index) {
		Optional<Float> returnThis = Optional.empty();

		if (this.type == EduArrayType.FLOAT) {
			if (index < this.size) {
				returnThis = Optional.ofNullable(this.floatArray[index]);
			} else {
				returnThis = Optional.empty();
			}
		} else {
			returnThis = Optional.empty();
		}

		return returnThis;
	}

	public void clearIntegers() {
		for (int i = 0; i < this.count; i++) {
			intArray[i] = DEFAULT_INTEGER_VALUE;
		}
	}

	public void clearFloats() {
		for (int i = 0; i < this.count; i++) {
			floatArray[i] = DEFAULT_FLOAT_VALUE;
		}
	}

	/*
	 * need this array to have a visualize method need this to also have a logging
	 * method to show how this behaves need this to also have implementations of
	 * Java 8 array methods so I can add the logging and visualization components
	 * 
	 * need this to also dynamically re-allocate space
	 */

	public enum EduArrayType {
		INTEGER, FLOAT;
	}

}
