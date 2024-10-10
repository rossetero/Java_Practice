package org.example;

public class Dog extends Animal implements Omnivore {
    Dog(String name,int age){
        super(name,age);
    }

    @Override
    public String toString() {
        return "Dog name = "+getName()+", age = "+getAge()+ hunt();
    }

    @Override
    public String hunt(){
        return ". I hunt for robbers";
    }
}