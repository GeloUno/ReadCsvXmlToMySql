package main;

import java.util.List;

public class PrintObjectCustomers {
    private List<Contacts> contactsList;
    private TypeContact TypeContact;
    private String Contact;

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
//        System.out.println(c.getContacts());
//        System.out.println(c.);

        System.out.println("STOP PRINT FROM OBJECT");
    }
}
