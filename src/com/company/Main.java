package com.company;

import java.util.Scanner;

/**
 *  Main class.
 *  Read user count and create database login - password
 *
 * @version 1.0 16.03.2019
 * @author Sergey Kotov
 */

public final class Main {
    private Main() { }
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int countUsers = -1;
        System.out.println("Enter number of users");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Enter number of users correctly");
        }
        countUsers = scanner.nextInt();
        scanner.nextLine();

        BDUsers users = new BDUsers();
        users.addUser(countUsers);

        System.out.println("Enter login of user");
        System.out.println(users.getPassword());
    }
}
