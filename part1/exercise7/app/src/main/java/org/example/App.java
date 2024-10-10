package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class App {

    static int input(Scanner scanner) throws Exception {
        int n = -1;
        n = Integer.parseInt(scanner.nextLine());
        if (n <= 0)
            throw new Exception("Input error. Size <= 0");
        return n;
    }

    static void output(float[] arr){
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
        try(FileWriter f = new FileWriter("app/src/main/resources/result.txt")){
            float min=arr[0];
            float max=arr[0];
            for(float el: arr){
                if(el>max) max=el;
                if(el<min) min=el;
            }
            f.write(min+" "+max);
            System.out.println("Saving min and max values in file");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    static float[] inputArr(String filename) throws Exception {
        try (Scanner scanner = new Scanner(new File("app/src/main/resources/"+filename))) {
            scanner.useLocale(Locale.ENGLISH);
            int n = input(scanner);
            float[] arr = new float[n];
            int i=0;
            for (; i < n && scanner.hasNext(); i++) {
                try {
                    arr[i] = scanner.nextFloat();
                } catch (InputMismatchException ex) {
                    scanner.next();
                    --i;
                }
            }
            if (i<n){
                throw new Exception("Input error. Insufficient number of elements");
            }
            return arr;
        } catch (FileNotFoundException ex){
            throw new Exception("Input error. File isn't exist");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            String f = s.nextLine();
            float[] arr = inputArr(f);
            output(arr);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
