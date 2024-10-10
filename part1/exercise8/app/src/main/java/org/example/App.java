package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = 0, cur = 0, prev = 0;
        try {
            prev = scanner.nextInt();
            while (true) {
                ++cnt;
                cur = scanner.nextInt();
                if (cur < prev) {
                    throw new RuntimeException("The sequence is not ordered from the ordinal number of the number " + cur);
                }
                prev = cur;
            }
        } catch (InputMismatchException iex) {
            if (cnt > 0) {
                System.out.println("The sequence is ordered in ascending order");
            } else {
                System.out.println("Input error");
            }
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        }
    }
}
