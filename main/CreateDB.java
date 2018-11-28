package main;

import java.sql.*;

public class CreateDB {

    //JDBC driver name & database URL

    // fix problems witch time zone in local host
    static final String DB_URL_CREATE_BD = "jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // DB credential
    static final String USER = "root";
    static final String PASS = "";

    public void connecting() {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        int id;
        String query;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting ....");
            connection = DriverManager.getConnection(DB_URL_CREATE_BD, USER, PASS);

            System.out.println("Creating DB ...");
            statement = connection.createStatement();
            //  Select query;

            query = ("CREATE DATABASE IF NOT EXISTS customersDB");
            resultSet = statement.executeUpdate(query);


            query = (" CREATE TABLE IF NOT EXISTS `customersDB`.`Customers` ( `id` INT NOT NULL AUTO_INCREMENT " +
                    ", `name` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL " +
                    ", `surname` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL " +
                    ", `age` INT(2) NOT NULL " +
                    ", PRIMARY KEY (`id`)) ENGINE = InnoDB");
            resultSet = statement.executeUpdate(query);


            query = ("CREATE DATABASE IF NOT EXISTS contacts");
            resultSet = statement.executeUpdate(query);


            query = (" CREATE TABLE IF NOT EXISTS `customersDB`.`contacts` ( `id` INT NOT NULL AUTO_INCREMENT " +
                    ", `id_customers` INT NOT NULL , `type` INT NULL " +
                    ", `contact` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL " +
                    ", PRIMARY KEY (`id`)) ENGINE = InnoDB;\n");
            resultSet = statement.executeUpdate(query);

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Create DB Error");
            e.printStackTrace();
        }
    }

}

