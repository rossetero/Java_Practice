package org.example;

public class GuineaPig extends Animal implements Herbivore{
    GuineaPig(String name,int age){
        super(name,age);
    }

    @Override
    public String toString() {
        return "GuineaPig name = "+getName()+", age = "+getAge()+chill();
    }

    @Override
    public String chill(){
        return ". I chill for 12 hours";
    }
}

