package com.sarunas;

import java.util.Scanner;

public class Cinema {

    private static Scanner scanner = new Scanner(System.in);


    static double ticketPrice = 0;
    static int numberOfSeats = 0;
    static int reservedPlace = 0;
    static double currentIncomes = 0;


    public static String[][] totalCinemaSeats(int rows, int columns) {
        String[][] seats = new String[rows][columns];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                seats[i][j] = "S";;
                numberOfSeats++;
            }
        }
        return seats;
    }

    public static void buyTickets(int rows, String[][] seats) {
        while (true) {
            System.out.println("\nEnter a row number:");
            int rowNumber = scanner.nextInt() - 1;
            System.out.println("> " + (rowNumber + 1));
            System.out.println("Enter a seat number in that row:");
            int seatNumber = scanner.nextInt() - 1;
            System.out.println("> " + (seatNumber + 1));
            scanner.nextLine();
            if (rowNumber < 0 || rowNumber >= seats.length || seatNumber < 0 || seatNumber >= seats[0].length) {
                System.out.println("\nWrong input!");
            } else if (seats[rowNumber][seatNumber] == "B") {
                System.out.println("\nThat ticket has already been purchased!");
            } else {
                seats[rowNumber][seatNumber] = "B";
                reservedPlace++;

                int midleRows = rows / 2;

                if (numberOfSeats <= 60) {
                    ticketPrice = 10;
                    currentIncomes += ticketPrice;
                    System.out.printf("\nTicket price: $%.0f%n", ticketPrice);
                } else {
                    if (rowNumber < midleRows) {
                        ticketPrice = 10;
                        currentIncomes += ticketPrice;
                        System.out.printf("\nTicket price: $%.0f%n", ticketPrice);
                    } else {
                        ticketPrice = 8;
                        currentIncomes += ticketPrice;
                        System.out.printf("\nTicket price: $%.0f%n", ticketPrice);
                    }
                }
                break;
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

    public static void statistics(String[][] seats) {
        int totalIncomes = countTotalIncomes(seats);
        double percentage = (reservedPlace / (double) numberOfSeats) * 100;
        System.out.println("Number of purchased tickets: " + reservedPlace);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%.0f\n", currentIncomes);
        System.out.println("Total income: $" + totalIncomes);
    }

    public static int countTotalIncomes(String[][] seats) {
        int totalSum = 0;
        if (numberOfSeats <= 60) {
            totalSum = numberOfSeats * 10;
        } else {
            int fowardSeats = 0;
            int backSeats = 0;
            int fowardSeatsPrice = 0;
            int backSeatsPrice = 0;
            int midleRow = seats.length / 2;
            for (int i = 0; i < midleRow; i++) {
                for (int j = 0; j < seats[0].length; j++) {
                    fowardSeats++;
                    fowardSeatsPrice = fowardSeats * 10;
                }
            }
            for (int i = midleRow; i < seats.length; i++) {
                for (int j = 0; j < seats[0].length; j++) {
                    backSeats++;
                    backSeatsPrice = backSeats * 8;
                }
            }
            totalSum = fowardSeatsPrice + backSeatsPrice;
        }
        return totalSum;
    }
}
