package io.jeffrey.hackajob;

import java.util.Calendar;
import java.util.TimeZone;

class WhatDayIsIt {

    static String execute(String birthday_date) {
        return solutionV1(birthday_date);
    }

    private static String solutionV1(String birthday_date) {
        String [] birthday = birthday_date.split("-");
        int day = Integer.parseInt(birthday[0]);
        int month = Integer.parseInt(birthday[1]);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<50; i++) {
            int year = 2016 + i;

            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month - 1);
            c.set(Calendar.DAY_OF_MONTH, day);
            c.set(Calendar.HOUR, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.setTimeZone(TimeZone.getDefault());
//            System.out.println(c.getTime());

            int j = c.get(Calendar.DAY_OF_WEEK);
            switch (j) {
                case 6: { // Fri
                    checkDate(c, year, month, day, "Fri-", sb);
                    break;
                }
                case 7: { // Sat
                    checkDate(c, year, month, day, "Sat-", sb);
                    break;
                }
                case 1: { // Sun
                    checkDate(c, year, month, day, "Sun-", sb);
                    break;
                }
            }
        }

        return sb.toString();
    }

    private static void checkDate(Calendar c, int year, int month, int day, String prefix, StringBuilder sb) {
        // defensive measure against leap year
        if (c.get(Calendar.MONTH)+1 == month && c.get(Calendar.DAY_OF_MONTH)==day) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(prefix + (year));
        }
    }

}
