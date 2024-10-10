package org.example;

import java.util.ArrayList;

public class Main {
    static long programStartTime = System.currentTimeMillis();


    public static void main(String[] args) {

        try {
            ArrayList<Animal> pets = InputAnimal.input();
            System.out.println(System.currentTimeMillis() - Main.programStartTime);
            System.out.println(System.currentTimeMillis() - Main.programStartTime);

            for (Animal pet : pets) {
                Thread thread = new Thread(() -> {
                    long walkStartTime = System.currentTimeMillis() - Main.programStartTime;
                    pet.goToWalk();
                    long walkStopTime = System.currentTimeMillis() - Main.programStartTime;
                    System.out.println(pet.toString()
                            + ", start time = "
                            + String.format("%.2f", ((double) walkStartTime / 1000))
                            + ", end time = "
                            + String.format("%.2f", ((double) walkStopTime / 1000)));
                });
                thread.start();
            }



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}