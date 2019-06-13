package blatt_7;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static String username = "";
    private static String passwort = "";
    public static void main(String[] args) {

        System.out.println("--ConnectionTest--");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Kein jdbc Treiber");
            e.printStackTrace();
            return;

        }

        System.out.println("jdbc gefunden");

        System.out.println("Please enter your username");

        Scanner scan = new Scanner(System.in);

        username = scan.next();

        System.out.println("Please enter your password");

        passwort = scan.next();

        scan.close();

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14 ", username, passwort);

        } catch (SQLException e) {

            System.out.println("Connection failed, pls check output");
            e.printStackTrace();
            return;

        }

        if (connection != null) {

            System.out.println("You made it, take control your database now!");

        } else {

            System.out.println("Failed to make connection!");

        }

    }
}
