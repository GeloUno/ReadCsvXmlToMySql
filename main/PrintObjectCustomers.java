package main;

import java.util.List;

public class PrintObjectCustomers {
    private List<Contacts> contactsList;

    void print(Customers c) {
        System.out.println("START PRINT FROM OBJECT");
        System.out.println(c.getName());
        System.out.println(c.getSurname());
        System.out.println(c.getAge());
        contactsList = c.getContacts();
        for(Contacts l:contactsList){
            System.out.println(l.getTypeContact());
            System.out.println(l.getContact());
        }

        System.out.println("STOP PRINT FROM OBJECT");

        ConnectDB insertDB = new InsertDB();
        insertDB.connecting(c);
    }
}
