package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class InputAnimal {

    static int inputAmount(Scanner scanner) throws Exception {
        int n = -1;
        try {
            n = Integer.parseInt(scanner.nextLine());
            if (n <= 0)
                throw new Exception("Input error. Size <= 0");
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't parse a number. Please, try again");
            n = inputAmount(scanner);
        }
        return n;
    }

    static int inputAge(Scanner scanner) throws Exception{
        int n = -1;
        try {
            n = Integer.parseInt(scanner.nextLine());
            if (n<=0){
                throw new Exception("Input error. Age<=0");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't parse a number. Please, try again");
            n = inputAge(scanner);
        }
        return n;
    }

    static double inputWeight(Scanner scanner) throws Exception {
        double n = -1;
        try {
            n = Double.parseDouble(scanner.nextLine());
            if (n<1e-6){
                throw new Exception("Input error. Mass<=0");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't parse a number. Please, try again");
            n = inputWeight(scanner);
        }
        return n;
    }

    static String inputName(Scanner scanner){
        return scanner.nextLine();
    }

    static ArrayList<Animal> input() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int n = inputAmount(scanner);
        ArrayList<Animal> animals = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            try {
                String type = scanner.nextLine();
                animals.add(
                        switch (type) {
                            case "dog" -> new Dog(inputName(scanner), inputAge(scanner),inputWeight(scanner));
                            case "cat" -> new Cat(inputName(scanner), inputAge(scanner),inputWeight(scanner));
                            default -> throw new Exception("Incorrect input. Unsupported pet type");
                        });
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        return animals;
    }


}
