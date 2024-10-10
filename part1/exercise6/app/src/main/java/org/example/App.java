/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class App {
    static int input() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        try {
            n = Integer.parseInt(scanner.nextLine());
            if (n <= 0)
                throw new Exception("Input error. Size <= 0");
        } catch (NumberFormatException ex) {
            System.out.println("Couldn't parse a number. Please, try again");
            n = input();
        }
        return n;
    }

    static float[] inputArr() throws Exception {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        int n = input();
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            try {
                arr[i] = scanner.nextFloat();
            } catch (InputMismatchException ex) {
                System.out.println("Couldn't parse a numbers. Please, try again");
                scanner.nextLine();
                i = -1;
            }
        }

        return arr;
    }

    static void selectionSort(float[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[i]>arr[j]){
                    float tmp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            float[] arr = inputArr();
            selectionSort(arr);
            System.out.println(Arrays.toString(arr));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
