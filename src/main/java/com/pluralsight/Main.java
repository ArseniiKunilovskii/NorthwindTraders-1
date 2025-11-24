package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                "root",
                "yearup"
        );

        Statement statement = connection.createStatement();

        String query = """
                SELECT * from products
                """;

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            String name = resultSet.getString("productName");
            System.out.println(name);
        }
        connection.close();

    }
}
