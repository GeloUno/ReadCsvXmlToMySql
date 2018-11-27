package main;

public enum TypeContact {
    UNKNOWN(0),
    EMAIL(1),
    PHONE(2),
    JABBER(3);
private int numberContact;

    TypeContact(int numberContact) {
        this.numberContact = numberContact;
    }

    public int getNumberContact() {
        return numberContact;
    }
}
