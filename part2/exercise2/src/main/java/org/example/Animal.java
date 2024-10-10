package org.example;

public abstract class Animal {
    private String name;
    private int age;
    private double weight;

    Animal(String name, int age, double weight) throws Exception {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {return weight;}

    public double getFeedInfoKg(){
        return weight*0.3;
    }
}
