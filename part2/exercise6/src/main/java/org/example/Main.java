package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try{
            ArrayList<Animal> pets = InputAnimal.input();
            AnimalIterator animalIterator = new AnimalIterator(pets);
            while (animalIterator.hasNext()){
                System.out.println(animalIterator.next().toString());
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}