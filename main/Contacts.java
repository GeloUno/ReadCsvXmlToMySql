package main;

public class Contacts {
   private TypeContact TypeContact;
   private String Contact;

    public void setTypeContact(main.TypeContact typeContact) {
        TypeContact = typeContact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public main.TypeContact getTypeContact() {
        return TypeContact;
    }

    public String getContact() {
        return Contact;
    }
}
