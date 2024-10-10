package org.example;

class User{
    private String name;
    private int age;

    User(String name, int age) throws Exception{
        this.name=name;
        if(age>0)
            this.age = age;
        else
            throw new Exception("Incorrect input. Age <= 0");
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name+" "+age;
    }
}
