package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Main {



    public static void main(String[] args) {
        try{
            ArrayList<Animal> pets = InputAnimal.input();
            pets.stream().filter(Objects::nonNull).map(Animal::toString).forEach(System.out::println);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}