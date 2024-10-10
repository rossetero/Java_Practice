package org.example;

public class Dog extends Animal {
    Dog(String name,int age,double weight) throws Exception{
        super(name,age,weight);
    }

    @Override
    public String toString() {
        return "Dog name = "+getName()+", age = "+getAge()+" mass = "+getWeight()+" feed = "+getFeedInfoKg();
    }


}
