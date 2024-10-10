package org.example;

public class Dog extends Animal {
    Dog(String name,int age) throws Exception{
        super(name,age);
    }

    @Override
    public String toString() {
        return "Dog name = "+getName()+", age = "+getAge();
    }


}
