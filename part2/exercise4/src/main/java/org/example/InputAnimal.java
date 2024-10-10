package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    static int inputAge(Scanner scanner){
        int n = -1;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't parse a number. Please, try again");
            n = inputAge(scanner);
        }
        return n>10?n+1:n;
    }

    static String inputName(Scanner scanner){
        return scanner.nextLine();
    }

    static ArrayList<Animal> input() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int n = inputAmount(scanner);
        ArrayList<Animal> pets =  Stream.generate(() -> { Animal pet = null; try {
                String type = scanner.nextLine();
                 pet = switch (type) {
                            case "dog" -> new Dog(inputName(scanner), inputAge(scanner));
                            case "cat" -> new Cat(inputName(scanner), inputAge(scanner));
                            default -> throw new Exception("Incorrect input. Unsupported pet type");
                        };
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            return pet;
        }).limit(n).collect(Collectors.toCollection(ArrayList::new));
         return pets;
    }


}
