package com.javacore.lesson02.models.client;

public class Client {

    private String name;
    private String surname;
    public Client.Animal pet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void createPet(String petName, int age, String petType) {
        pet = new Animal(petName, age, petType);
    }

    public class Animal {

        private String name;
        private int age;
        private String type;

        public Animal(String name, int age, String type) {
            this.name = name;
            this.age = age;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getType() {
            return type;
        }
    }
}
