package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  User database class.
 *  @version 1.0 16.03.2019
 *  @author Sergey Kotov
 */

public class BDUsers {
    /** Sets the standard color for text output to the console.*/
    private static final String ANSI_RESET = "\u001B[0m";
    /** Sets the blue color for text output to the console.*/
    private static final String ANSI_BLUE = "\u001B[34m";
    /** Sets the red color for text output to the console.*/
    private static final String ANSI_RED = "\u001B[31m";
    /** field containing information about user logins and passwords.*/
    private Map<String, String> users = new HashMap<>();
    private boolean userExist(final String login) {
        return users.get(login) != null;
    }

    /** A method that adds a new user to the database. */
    public void addUser() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String login;
        String password;

        System.out.print(ANSI_BLUE + "login: " + ANSI_RESET);
        login = scanner.nextLine();

        if (userExist(login)) {
            String answer;
            System.out.println(ANSI_RED + "Такой пользователь уже существует, "
                    + "хотите сменить пароль для пользователя "
                    + login + "? (yes / no)" + ANSI_RESET);

            answer = scanner.nextLine();
            if (answer.equals("no")) {
                addUser();
                scanner.close();
                return;
            }
        }
        System.out.print(ANSI_BLUE + "password: " + ANSI_RESET);
        password = scanner.nextLine();
        users.put(login, password);
    }

    /** A method that adds count of new users to the database.
     * @param count - count of users
     */
    public void addUser(final int count) {
        for (int i = 0; i < count; i++) {
            addUser();
        }
    }

    /** A method that returns a user password.
     * @return returns the user password for the login entered
     */
    public String getPassword() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String login;

        System.out.print(ANSI_BLUE + "login: " + ANSI_RESET);
        login = scanner.nextLine();
        scanner.close();
        if (userExist(login)) {
            System.out.print(ANSI_BLUE + "password: " + ANSI_RESET);
            return users.get(login);
        } else {
            return ANSI_RED + "Такого пользователя не существует" + ANSI_RESET;
        }
    }

}
