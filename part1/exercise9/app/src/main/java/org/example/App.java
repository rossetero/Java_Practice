package org.example;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static ArrayList<String> filter(ArrayList<String> a, String subStr){
        ArrayList<String> filtered = new ArrayList<String>();
        for(String s: a){
            if(s.contains(subStr)) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<String> a = new ArrayList<String>(n);
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextLine());
        }
        String subStr = scanner.nextLine();
        ArrayList<String> b = filter(a,subStr);
        for (String s : b) {
            System.out.println(s);
        }
    }
}
