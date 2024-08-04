package com.javacore.lesson05;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private final String name;
    private final String surname;
    private EmpoyeeType type;
    private int salary;

    public Employee(String name, String surname, EmpoyeeType type, int salary) {
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public EmpoyeeType getType() {
        return type;
    }

    public void setType(EmpoyeeType type) {
        this.type = type;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.getSalary()-employee.getSalary();
    }
}
