package com.sarunas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("> " + rows);
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();
        System.out.println("> " + columns);

        int numberOfSeats = 0;
        int totalSum = 0;

        int[][] seats = new int[rows][columns];
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < columns; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print("S ");
                numberOfSeats++;
            }
            System.out.println();
        }
        System.out.println(numberOfSeats);

        if (numberOfSeats <= 60) {
            totalSum = numberOfSeats * 10;
        } else {
            int fowardSeats = 0;
            int backSeats = 0;
            int fowardSeatsPrice = 0;
            int backSeatsPrice = 0;
            int midleRows = rows / 2;
            for (int i = 0; i < midleRows; i++) {
                for (int j = 0; j < columns; j++) {
                    fowardSeats++;
                    fowardSeatsPrice = fowardSeats * 10;
                }
            }
            for (int i = midleRows; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    backSeats++;
                    backSeatsPrice = backSeats * 8;
                }
            }
            totalSum = fowardSeatsPrice + backSeatsPrice;
        }
        System.out.println("Total income:");
        System.out.println("$" + totalSum);
    }
}
