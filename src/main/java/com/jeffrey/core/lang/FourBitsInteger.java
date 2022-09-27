package com.jeffrey.core.lang;

/**
 * Represents a 4-bits only signed integer.
 *
 * <p>
 * The {@code FourBitsInteger} class wraps a value of the primitive type
 * {@code int} in an object. An object of type {@code FourBitsInteger}
 * contains a single field whose type is {@code int}.
 * </p>
 *
 * <p>
 * In addition, this class is immutable therefore once the object is created,
 * its interval value cannot be modified and all the provided API will return
 * a new object with the the latest value.
 * </p>
 *
 * <p>
 * Demonstrating how 2's complement work for arithmetic operations in integer
 * <ul>
 *     <li>overflow (when addition results in a value larger than the max value can be held by the number of bits</li>
 *     <li>underflow (when subtraction results in a value smaller than the smallest value can be held by the number of bits</li>
 * </ul>
 * </p>
 *
 * This class is immutable so it can be shared.
 */
public class FourBitsInteger {
    /**
     * Total number of bits used by the 4-bits only signed integer
     */
    private static final int NUM_OF_BITS = 4;

    /**
     * Number of bits available for representing the value
     *
     * The left-most bit is always reserved for the sign bit (0 indicate positive, 1 indicate negative),
     * leaving only 3 bits for representing the value.
     */
    private static final int VALUE_BITS = NUM_OF_BITS - 1;

    /**
     * Number of values can be stored by a 4-bits signed integer
     *
     * binary | decimal
     * ------ | -------
     * 0000   | 0
     * 0001   | 1
     * 0010   | 2
     * 0011   | 3
     * 0100   | 4
     * 0101   | 5
     * 0110   | 6
     * 0111   | 7
     * 1000   | -8 (using 2's complements, binary value of 8 is 1000, inverse it to 0111, then add 1 so it becomes 1000)
     * 1001   | -7 (using 2's complements, binary value of 7 is 0111, inverse it to 1000, then add 1 so it becomes 1001)
     * 1010   | -6 (using 2's complements, binary value of 6 is 0110, inverse it to 1001, then add 1 so it becomes 1010)
     * 1011   | -5 (using 2's complements, binary value of 5 is 0101, inverse it to 1010, then add 1 so it becomes 1011)
     * 1100   | -4 (using 2's complements, binary value of 4 is 0100, inverse it to 1011, then add 1 so it becomes 1100)
     * 1101   | -3 (using 2's complements, binary value of 3 is 0011, inverse it to 1100, then add 1 so it becomes 1101)
     * 1110   | -2 (using 2's complements, binary value of 2 is 0010, inverse it to 1101, then add 1 so it becomes 1110)
     * 1111   | -1 (using 2's complements, binary value of 1 is 0001, inverse it to 1110, then add 1 so it becomes 1111)
     *
     * Total number of values can be stored by a 4-bits signed integer = 2^4 = 16 (including zero)
     */
    private static final int NUM_OF_VALUES = Double.valueOf(Math.pow(2, NUM_OF_BITS)).intValue();

    /**
     * For a 4-bits signed integer, the largest positive value can be hold is 0111 (instead of 1111) since
     * the left-most bit is reserved as sign bit, as illustrated below:
     *
     * binary | decimal
     * ------ | -------
     * 0000   | 0
     * 0001   | 1
     * 0010   | 2
     * 0011   | 3
     * 0100   | 4
     * 0101   | 5
     * 0110   | 6
     * 0111   | 7
     *
     * Converting 0111 (binary) to decimal is 7, which is equivalent to (2^(4-1) - 1).
     */
    public static final int MAX_VALUE = Double.valueOf(Math.pow(2, VALUE_BITS)).intValue() - 1;
    /**
     * For a 4-bits signed integer, the largest negative value can be hold is 1111 (-1) and the smallest
     * negative value can be achieved by reducing 1, as illustrated below:
     *
     * binary | decimal
     * ------ | -------
     * 1111   | -1
     * 1110   | -2
     * 1101   | -3
     * 1100   | -4
     * 1011   | -5
     * 1010   | -6
     * 1001   | -7
     * 1000   | -8
     *
     * The minimum value is -8, which is equivalent to -2^(4-1).
     */
    public static final int MIN_VALUE = Double.valueOf(Math.pow(-2, VALUE_BITS)).intValue();
    private int _i;

    /**
     * @param i the primitive integer value to initialize
     */
    public FourBitsInteger(int i) {
        if (i > NUM_OF_VALUES || i < -NUM_OF_VALUES) i = i % NUM_OF_VALUES;

        if (i > MAX_VALUE) { // handle overflow within the range of first cycle
            this._i = MIN_VALUE + (i - MAX_VALUE - 1);
        } else if (i < MIN_VALUE) { // handle underflow within the range of first cycle
            this._i = MAX_VALUE - (MIN_VALUE - i - 1);
        } else {
            this._i = i;
        }
    }

    /**
     * @return the value in primitives
     */
    public int intValue() {
        return this._i;
    }

    /**
     * Adding an integer to the 4-bits integer to produce a new 4-bits integer.
     *
     * If the result exceed the maximum value can be held, an overflow happens and
     * the operation go cyclic which continue from the minimum value.
     * 6 + 3 = 9 which is larger than the max value 7 by 2, the cyclic operation
     * continues and that includes -8 and -7, therefore 6 + 3 = -7 for a 4-bits
     * integer.
     *
     * @param i the integer to add
     * @return
     */
    public FourBitsInteger add(int i) {
        if (this._i + i > MAX_VALUE) {
            return new FourBitsInteger(MIN_VALUE + (this._i + i - MAX_VALUE - 1));
        } else if (this._i + i < MIN_VALUE) {
            return new FourBitsInteger(MAX_VALUE - ((MIN_VALUE - (this._i + i)) -1));
        } else {
            return new FourBitsInteger(this._i + i);
        }
    }

    public FourBitsInteger minus(int i) {
        if (this._i - i < MIN_VALUE) {
            return new FourBitsInteger(MAX_VALUE - (MIN_VALUE - (this._i - i) - 1));
        } else if (this._i - i > MAX_VALUE) {
            return new FourBitsInteger(MIN_VALUE + (this._i - i - MAX_VALUE - 1));
        } else {
            return new FourBitsInteger(this._i - i);
        }
    }

}
