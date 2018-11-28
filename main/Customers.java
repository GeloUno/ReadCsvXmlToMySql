package main;

import java.util.ArrayList;
import java.util.List;

public class Customers {

    private String Name;
    private String Surname;
    private int Age;
    private List<Contacts> Contacts = new ArrayList<Contacts>();

    public List<main.Contacts> getContacts() {
        return Contacts;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public int getAge() {
        return Age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setContacts(List<main.Contacts> contacts) {
        Contacts = contacts;
    }
}
