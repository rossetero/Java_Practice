package org.example;

import java.util.ArrayList;

public class Main {

    static void print(ArrayList<Animal> animals){
        animals.stream().filter(animal -> animal instanceof Herbivore).map(Animal::toString).forEach(System.out::println);
        animals.stream().filter(animal -> animal instanceof Omnivore).map(Animal::toString).forEach(System.out::println);
    }

    public static void main(String[] args) {
        try{
            ArrayList<Animal> animals = InputAnimal.input();
            print(animals);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}