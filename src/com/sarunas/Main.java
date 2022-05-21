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
        scanner.nextLine();
        String[][] seats = Cinema.totalCinemaSeats(rows, columns);


        while(true) {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            String option = scanner.nextLine();
            System.out.println("> " + option);
            switch (option) {
                case "0":
                    return;
                case "1":
                    Cinema.printRezerveSeats(seats);
                    break;
                case "2":
                    Cinema.buyTickets(rows, seats);
                    break;
                case "3":
                    Cinema.statistics(seats);
                    break;
                default:
                    System.out.println("Not valid option");
                    break;
            }
        }
    }
}
