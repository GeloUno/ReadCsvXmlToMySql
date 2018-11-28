package main;


import java.sql.*;

public class InsertDB extends ConnectDB {

       //ConnectDB driver name & database URL
//    static final  String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    // fix problems witch time zone in local host
    static final String DB_URL= "jdbc:mysql://localhost/customersDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    public void connecting(){}
    public void connecting(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting ....");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement ...");
            statement = connection.createStatement();
          //  Select query;

            query =("SELECT MAX(id) FROM contacts");
            ResultSet resultSet = statement.executeQuery(query);
           // System.out.println(resultSet);
            resultSet.next();
            id =(resultSet.getInt("MAX(id)"))+1;
//            while (resultSet.next()){
//                System.out.print(" - ");
//                System.out.print(resultSet.getInt("contact"));
//                System.out.print(" - ");
//                System.out.println(resultSet.getInt("type"));
//            }
            // the mysql insert statement
             query = " insert into contacts (`id`, `id_customers`, `type`, `contact`)"
                    + " values ("+id+", ?, ?, ?)";

//           query = " insert into contacts (`id`, `id_customers`, `type`, `contact`)"
//                    + " values (LAST_INSERT_ID(), ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, 5);
            preparedStmt.setInt (2, 5);
            //  preparedStmt.setInt   (3, 1);
            preparedStmt.setInt(3, 114114114);


            // execute the preparedstatement
            preparedStmt.execute();

            statement.close();
            connection.close();

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connnection DB Error");
            e.printStackTrace();
        }
    }

}
