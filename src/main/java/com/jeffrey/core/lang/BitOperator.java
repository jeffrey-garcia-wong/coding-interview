package com.jeffrey.core.lang;

/**
 * <p>
 * This class provides the typical operations for
 * handling bits in a given integer.
 * </p>
 *
 * <p>
 *     <ul>
 *         <li>set bit in a particular position</li>
 *         <li>clear bit in a particular position</li>
 *         <li>test bit in a particular position</li>
 *         <li>verify odd/even</li>
 *         <li>flip bits</li>
 *     </ul>
 * </p>
 */
public class BitOperator {

    /**
     * Set a bit of an integer at the specified position. </p>
     *
     * <p>
     * This involves 2 operation
     * <ul>
     *     <li>create a mask with a bit set to 1 at the specified position</li>
     *     <li>mask the bits from step 1 and the integer with | operator </li>
     * </ul>
     * </p>
     *
     * <p>
     * An illustration of setting the bit at position 2 as below:
     * <pre>
     |                   | Binary   | Decimal    |
     |-------------------|----------|------------|
     | Integer           | 100      | 4          |
     | Mask              | 010      | 2          |
     | Integer & Inverse | 110      | 6          |
     * </pre>
     * </p>
     *
     * @param value the integer to set bit
     * @param pos the position of the bit to set (pos >= 1)
     * @return the integer with bit set
     */
    public static int setBit(int value, int pos) {
        int mask = 1 << pos;
        return value | mask;
    }

    /**
     * Clear a bit of an integer at the specified position. <p/>
     *
     * <p>
     * This involves 3 operations:
     * <ul>
     *     <li>create a mask with a bit set to 1 at the specified position</li>
     *     <li>inverse the mask</li>
     *     <li>mask the bits from step 1 and 2 with the & operator</li>
     * </ul>
     * </p>
     *
     * <p>
     * An illustration of clearing the bit at position 2 as below:
     * <pre>
     |                   | Binary   | Decimal    |
     |-------------------|----------|------------|
     | Integer           | 110      | 6          |
     | Mask              | 010      | 2          |
     | Inverse           | 101      | 5          |
     | Integer & Inverse | 100      | 4          |
     * </pre>
     * </p>
     *
     * @param value the integer to clear bit
     * @param pos the position of the bit to clear (pos >= 1)
     * @return the integer with bit cleared
     */
    public static int clearBit (int value, int pos) {
        int mask = ~(1 << pos);
        return value & mask;
    }

    /**
     * Verify a bit is set or not. </p>
     *
     * <p>
     * This involves 2 operations:
     * <ul>
     *     <li>create a mask with a bit set to 1 at the specified position</li>
     *     <li>mask the bits from step 1 and the integer with the & operator</li>
     * </ul>
     * </p>
     *
     * <p>
     * An illustration of the steps as below:
     * <pre>
     |                   | Binary   | Decimal    |
     |-------------------|----------|------------|
     | Integer           | 110      | 6          |
     | Mask              | 010      | 2          |
     | Integer & Mask    | 010      | 2          |
     * </pre>
     * The result is not zero, indicating that the bit at the specified position must be set.
     * </p>
     *
     * @param value the integer value to verify
     * @param pos the position of the bits to verify
     * @return true if the bit is set, otherwise false
     */
    public static boolean testBit(int value, int pos) {
        int mask = 1 << pos;
        return (value & mask) != 0;
    }

    /**
     * Verify if the integer is divisible by 2. </p>
     *
     * <p>
     * This involves 2 operations:
     * <ul>
     *     <li>create a mask with a bit set to 1 at the zero position</li>
     *     <li>mask the bits from step 1 and the integer with the & operator</li>
     * </ul>
     * </p>
     *
     * <p>
     * An illustration of the steps as below:
     * <pre>
     |                   | Binary   | Decimal    |
     |-------------------|----------|------------|
     | Integer           | 110      | 6          |
     | Mask              | 001      | 1          |
     | Integer & Mask    | 000      | 2          |
     * </pre>
     * The result is zero, indicating that the integer is an even number.
     * <i>If the integer is odd, its rightmost bit must be 1 and masking with 1
     * will always produce 1.</i>
     * </p>
     *
     * @param value the integer to be divided
     * @return true if the integer is even, otherwise false
     */
    public static boolean isDivisibleBy2(int value) {
        int mask = 1 << 0;
        return (value & mask) == 0;
    }

    /**
     * Flip the bits of an integer. <p/>
     *
     * The flip involves 3 operations:
     * <p>
     * <ul>
     *     <li>inverse the bits of the integer using the ^ operator</li>
     *     <li>create a mask with same number of bits as the integer and set all bits to 1</li>
     *     <li>mask the bits from step 1 and 2 with the & operator <br/>
     *         <i>the masking is necessary to clear all the preceding bits
     *         that were set to 1 when the inverse take place.</i>
     *      </li>
     * </ul>
     * </p>
     *
     * <p>
     * An illustration of the steps as below:
     * <pre>
     |                | Binary   | Decimal    |
     |----------------|----------|------------|
     | Integer        | 110      | 6          |
     | Inverse        | 001      | 1          |
     | Mask           | 111      | 7          |
     | Inverse & Mask | 001      | 1          |
     * </pre>
     * </p>
     *
     * @param i integer value to flip
     * @return flipped integer
     */
    public static int flipBits(int i) {
        int mask = (1 << Integer.toBinaryString(i).length()) - 1;
        return ~i & mask;
    }

}
