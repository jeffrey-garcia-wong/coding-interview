package io.jeffrey.interviewbit.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static io.jeffrey.interviewbit.array.PickFromBothSides.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PickFromBothSidesTests {

    @Test
    public void test001() {
        final List<Integer> input = List.of(1, 2);
        final int target = 1;
        assertEquals(2, execute(input, target));
    }

    @Test
    public void test002() {
        final List<Integer> input = List.of(5, -2, 3 , 1, 2);
        final int target = 3;
        assertEquals(8, execute(input, target));
    }

    @Test
    public void test003() {
        final List<Integer> input = List.of(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35);
        final int target = 48;
        assertEquals(6253, execute(input, target));
    }

}
