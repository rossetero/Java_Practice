package org.example;

public class Cat extends Animal {
    Cat(String name,int age,double weight) throws Exception{
        super(name,age,weight);
    }

    @Override
    public String toString() {
        return "Cat name = "+getName()+", age = "+getAge()+" mass = "+getWeight()+" feed = "+getFeedInfoKg();
    }

    @Override
    public double getFeedInfoKg() {
        return getWeight()*0.1;
    }
}
