package com.sarunas;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {


        scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("> " + rows);
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();
        System.out.println("> " + columns);

        String[][] seats = printCinemaSeats(rows, columns);
        rezerveSeat(rows, seats);
        printRezerveSeats(seats);
    }

    static int ticketPrice = 0;
    static int numberOfSeats = 0;

    public static String[][] printCinemaSeats(int rows, int columns) {
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
        return seats;
    }

    public static void rezerveSeat(int rows, String[][] seats) {
        System.out.println("\nEnter a row number:");
        int rowNumber = scanner.nextInt() - 1;
        System.out.println("> " + (rowNumber + 1));
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt() - 1;
        System.out.println("> " + (seatNumber + 1));
        seats[rowNumber][seatNumber] = "B";

        int midleRows = rows / 2;

        if (numberOfSeats <= 60) {
            ticketPrice = 10;
            System.out.println("\nTicket price: $" + ticketPrice);


        } else {
            if (rowNumber < midleRows) {
                ticketPrice = 10;
                System.out.println("Ticket price: $" + ticketPrice);
            } else {
                ticketPrice = 8;
                System.out.println("Ticket price: $" + ticketPrice);
            }
        }
    }

    public static void printRezerveSeats(String[][] seats) {
        System.out.println("\nCinema:");
        System.out.print(" ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}
