package main;

import java.sql.Connection;
import java.sql.Statement;

abstract public class ConnectDB {

    static final String USER ="root";
    static final  String PASS ="";

    Connection connection = null;
    Statement statement = null;
    int id;
    String query;

    abstract public void connecting();
    abstract public void connecting(Customers customers);
}
