package io.jeffrey.hackajob;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static io.jeffrey.hackajob.WhatDayIsIt.execute;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhatDayIsItTests {

    private void verify(String output, int month, int day) {
        String[] outputs = output.split(" ");
        for (String s : outputs) {
            String[] tmp = s.split("-");
            String dayOfWeek = tmp[0];
            int year = Integer.parseInt(tmp[1]);
            int expDayOfWeek = -1;

            switch (dayOfWeek) {
                case "Fri": {
                    expDayOfWeek = 6;
                    break;
                }
                case "Sat": {
                    expDayOfWeek = 7;
                    break;
                }
                case "Sun": {
                    expDayOfWeek = 1;
                    break;
                }
            }

            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month - 1);
            c.set(Calendar.DAY_OF_MONTH, day);
            c.set(Calendar.HOUR, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.setTimeZone(TimeZone.getDefault());
//            System.out.println(c.getTime());

            int actualDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//            System.out.println(s);
            assertEquals(expDayOfWeek, actualDayOfWeek);
        }
    }

    @Test
    public void test_001() {
        int day = 8;
        int month = 12;
        String output = execute(day + "-" + month);
        System.out.println(output);
        verify(output, month, day);
    }

    @Test
    public void test_002() {
        int day = 11;
        int month = 6;
        String output = execute(day + "-" + month);
        System.out.println(output);
        verify(output, month, day);
    }

    @Test
    public void test_003() {
        int day = 3;
        int month = 11;
        String output = execute(day + "-" + month);
        System.out.println(output);
        verify(output, month, day);
    }

    @Test
    public void test_004() {
        int day = 29;
        int month = 3;
        String output = execute(day + "-" + month);
        System.out.println(output);
        verify(output, month, day);
    }

}
