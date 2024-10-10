package org.example;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal {
    Cat(String name,int age) throws Exception{
        super(name,age);
    }

    @Override
    public String toString() {
        return "Cat name = "+getName()+", age = "+getAge();
    }

    @Override
    public double goToWalk(){
        double strollTime = getAge() * 0.5;
        try {
            TimeUnit.SECONDS.sleep((long) (getAge() * 0.25));
        }
        catch (InterruptedException ex){}
        return strollTime;
    }
}
