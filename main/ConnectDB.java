package main;


import java.sql.*;

public class ConnectDB {

    //JDBC driver name & database URL
//    static final  String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    // fix problems witch time zone in local host
    static final  String DB_URL= "jdbc:mysql://localhost/customersdata?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // DB credential
    static final String USER ="root";
    static final  String PASS ="";
    public void connecting(){
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting ....");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement ...");
            statement = connection.createStatement();
          //  String query;

            // the mysql insert statement
            String query = " insert into contacts (`id`, `id_customers`, `type`, `contact`)"
                    + " values (LAST_INSERT_ID(), ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, 5);
            preparedStmt.setInt (2, 5);
          //  preparedStmt.setInt   (3, 1);
            preparedStmt.setInt(3, 114114114);


            // execute the preparedstatement
            preparedStmt.execute();

//            query =("SELECT * FROM `contacts`");
//            ResultSet resultSet = statement.executeQuery(query);
//            System.out.println(resultSet);
//            while (resultSet.next()){
//                System.out.print(resultSet.getInt("id"));
//                System.out.print(" - ");
//                System.out.print(resultSet.getInt("contact"));
//                System.out.print(" - ");
//                System.out.println(resultSet.getInt("type"));
//            }
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
