package org.example;

public class Cat extends Animal {
    Cat(String name,int age) throws Exception{
        super(name,age);
    }

    @Override
    public String toString() {
        return "Cat name = "+getName()+", age = "+getAge();
    }


}
