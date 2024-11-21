package com.javacore.lesson12;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Employee employee = new Employee();

        employee.setName("sdfgsfg dsfgsdfg");
//        employee.setEmail("qpmzj@example.com");
        employee.setPhone("123123123");
        employee.setSalary(1000);

        try {
            fieldChecker(employee);
        } catch (NullValueException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void fieldChecker(Employee employee) throws NullValueException, IllegalAccessException {
        Class clazz = employee.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            boolean change = false;
            if (!field.canAccess(employee)) {
                System.out.println(field.getName() + " is private");
                field.setAccessible(true);
                change = true;
            }

            Object value = field.get(employee);

            System.out.println(" value "+ field.getName()+ " " + field.isAnnotationPresent(NotNullValue.class)+ ": " + value);

            if (field.isAnnotationPresent(NotNullValue.class) && value == null) {
                throw new NullValueException(field.getName());
            }
            if (change) {
                field.setAccessible(false);
            }

        }}
}

