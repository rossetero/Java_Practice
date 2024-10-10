package org.example;

import java.util.concurrent.TimeUnit;

public class Dog extends Animal {
    Dog(String name,int age) throws Exception{
        super(name,age);
    }

    @Override
    public String toString() {
        return "Dog name = "+getName()+", age = "+getAge();
    }

    @Override
    public double goToWalk(){
        double strollTime = getAge() * 0.5;
        try {
            TimeUnit.SECONDS.sleep((long) (getAge() * 0.5));
        }
        catch (InterruptedException ex){}
        return strollTime;
    }


}
