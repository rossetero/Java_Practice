package org.example;

public class Hamster extends Animal implements Herbivore{
    Hamster(String name,int age){
        super(name,age);
    }

    @Override
    public String toString() {
        return "Hamster name = "+getName()+", age = "+getAge()+chill();
    }

    @Override
    public String chill(){
        return ". I chill for 8 hours";
    }
}