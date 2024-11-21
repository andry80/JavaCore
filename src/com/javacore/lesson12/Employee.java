package com.javacore.lesson12;

public class Employee {

    @NotNullValue
    private String name;

    @NotNullValue
     String email;

    @NotNullValue
    private String phone;

     int salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
