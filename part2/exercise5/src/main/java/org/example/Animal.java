package org.example;

public abstract class Animal {
    private String name;
    private int age;

    Animal(String name, int age) throws Exception {
        this.name = name;
        if (age > 0) {
            this.age = age;
        } else {
            throw new Exception("Incorrect input. Age <= 0");
        }
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public abstract double goToWalk();
}
