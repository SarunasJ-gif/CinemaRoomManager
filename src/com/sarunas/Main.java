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

        int ticketPrice = 0;
        int numberOfSeats = 0;
        int totalSum = 0;

        String[][] seats = new String[rows][columns];
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < columns; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats[0].length; j++) {
                seats[i][j] = "S";
                System.out.print(seats[i][j] + " ");
                numberOfSeats++;
            }
            System.out.println();
        }


        if (numberOfSeats <= 60) {
            ticketPrice = 10;
            totalSum = numberOfSeats * ticketPrice;
        } else {
            int fowardSeats = 0;
            int backSeats = 0;
            int fowardSeatsPrice = 0;
            int backSeatsPrice = 0;
            int midleRows = rows / 2;
            for (int i = 0; i < midleRows; i++) {
                for (int j = 0; j < columns; j++) {
                    ticketPrice = 10;
                    fowardSeats++;
                    fowardSeatsPrice = fowardSeats * ticketPrice;
                }
            }
            for (int i = midleRows; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    ticketPrice = 8;
                    backSeats++;
                    backSeatsPrice = backSeats * ticketPrice;
                }
            }
            totalSum = fowardSeatsPrice + backSeatsPrice;
        }
        System.out.println("Total income:");
        System.out.println("$" + totalSum);
    }
}
