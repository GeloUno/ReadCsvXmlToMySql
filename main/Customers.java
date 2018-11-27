package main;

import java.util.List;

public class Customers {
    private String IdCustomer;
    private String Name;
    private String Surname;
    private int Age;
    private List<TypeContact> Contacts;

    public String getIdCustomer() {
        return IdCustomer;
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

    public List<TypeContact> getContacts() {
        return Contacts;
    }

    public void setIdCustomer(String idCustomer) {
        IdCustomer = idCustomer;
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

    public void setContacts(List<TypeContact> contacts) {
        Contacts = contacts;
    }
}
