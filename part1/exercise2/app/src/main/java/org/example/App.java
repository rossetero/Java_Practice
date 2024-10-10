package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try{
            int seconds=input();
            int[] hms = findHMS(seconds);
            print(hms);
        }   catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    static int[] findHMS(int seconds){
        return new int[]{seconds/3600,seconds/60%60,seconds%60};
    }

    static void print(int[] hms){
        String[] hmsStr=new String[3];
        for (int i = 0; i < 3; i++) {
            hmsStr[i]=String.valueOf(hms[i]);
        }
        for (int i = 0; i < 3; i++) {
            if (hmsStr[i].length()==1){
                hmsStr[i]="0"+hmsStr[i];
            }
        }
        System.out.println(hmsStr[0]+':'+hmsStr[1]+':'+hmsStr[2]);
    }

    static int input() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int seconds=-1;
        try {
            seconds = Integer.parseInt(scanner.nextLine());
            if (seconds<0){
                throw new Exception("Incorrect time");
            }
        } catch (NumberFormatException ex){
            System.out.println("Couldn't parse a number. Please, try again.");
            seconds = input();
        }

        return seconds;
    }
}
