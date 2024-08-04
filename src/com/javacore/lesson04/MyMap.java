package com.javacore.lesson04;

import java.time.LocalDate;
import java.util.*;

public class MyMap {
    public static void main(String[] args) {
        Map<String, LocalDate> map = new HashMap<> ();

        map.put("Mccarthy", LocalDate.of(2006, 8, 12));
        map.put("Ayers", LocalDate.of(2008, 1, 23));
        map.put("Rasmussen", LocalDate.of(2009, 10, 9));
        map.put("Goodman", LocalDate.of(1998, 7, 20));
        map.put("Davenport", LocalDate.of(1979, 12, 1));
        map.put("Saunders", LocalDate.of(1987, 5, 8));
        map.put("Mercado", LocalDate.of(2000, 11, 27));
        map.put("Bond", LocalDate.of(2001, 6, 10));
        map.put("Whitaker", LocalDate.of(2002, 4, 19));
        map.put("Sherman", LocalDate.of(1999, 2, 13));



        Iterator<Map.Entry<String,LocalDate>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String,LocalDate> i = it.next();
            System.out.println(i.getKey()+ " => " + i.getValue());

            if (i.getValue().getMonth().getValue() == 12 || i.getValue().getMonth().getValue() == 2 || i.getValue().getMonth().getValue() == 1) {
                it.remove();
            }
        }

        System.out.println();

        for(Map.Entry<String,LocalDate> entry : map.entrySet()) {
            String key = entry.getKey();
            LocalDate value = entry.getValue();
            System.out.println(key + " => " + value);
        }
    }
}
