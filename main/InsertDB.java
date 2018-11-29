package main;


import java.sql.*;
import java.util.List;

public class InsertDB extends ConnectDB {

    private List<Contacts> contactsList;

    /**
     * ConnectDB driver URL
     */

    @Override
    public void connecting() {
    }

    @Override
    public void connecting(Customers c) {
        PreparedStatement preparedStmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting ....");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement ...");
            statement = connection.createStatement();

            query = ("SELECT MAX(id) FROM customers");
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            id = (resultSet.getInt("MAX(id)")) + 1;

            query = " insert into customers (`id`, `name`, `surname`, `age`)"
                    + " values (?, ?, ?, ?)";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.setString(2, c.getName());
            preparedStmt.setString(3, c.getSurname());
            preparedStmt.setInt(4, c.getAge());
            preparedStmt.execute();

            contactsList = c.getContacts();

            for (Contacts l : contactsList) {

                query = " insert into contacts (`id`, `id_customers`, `type`, `contact`)"
                        + " values (" + null + " ,?, ?, ?)";

                /**
                 * create the mysql insert preparedstatement
                 */
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, id);
                preparedStmt.setInt(2, l.getTypeContact().getNumberContact());
                preparedStmt.setString(3, l.getContact());

                preparedStmt.execute();
            }
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Insert DB Error");
            e.printStackTrace();
        }
    }
}
