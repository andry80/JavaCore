package com.javacore.lesson06;

import java.time.LocalDateTime;

public class Time {
    public static String time(LocalDateTime time) {
        return time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + "|" + time.getYear() + "-" + time.getMonthValue() + "-" + time.getDayOfMonth();
    }
}
