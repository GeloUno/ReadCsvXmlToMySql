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

    abstract void connecting();
}
