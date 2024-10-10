package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try{
            ArrayList<Animal> animals = InputAnimal.input();
            animals.stream().map(Animal::toString).forEach(System.out::println);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}