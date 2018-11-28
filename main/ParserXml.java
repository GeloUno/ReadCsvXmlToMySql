package main;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import java.util.ArrayList;
import java.util.List;

public class ParserXml extends DefaultHandler2 {
    boolean name = false;
    boolean surname = false;
    boolean age = false;
//    boolean city = false;
    boolean phone = false;
    boolean email = false;
//    boolean icq = false;
    boolean jabber = false;
    Customers customers;
 //   Contacts contacts;
    List<Contacts> contactsList;


    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        customers = new Customers();
        contactsList = new ArrayList<Contacts>();
//        contacts = new Contacts();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        customers.setContacts(contactsList);
        PrintObjectCustomers p = new PrintObjectCustomers();
        p.print(customers);

        System.out.println("END PARSING");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equalsIgnoreCase("name")) {
            name = true;
        }
        if (qName.equalsIgnoreCase("surname")) {
            surname = true;
        }
        if (qName.equalsIgnoreCase("age")) {
            age = true;
        }
//        if (qName.equalsIgnoreCase("city")) {
//            city = true;
//        }
        if (qName.equalsIgnoreCase("phone")) {
            phone = true;
        }
        if (qName.equalsIgnoreCase("email")) {
            email = true;
        }
//        if (qName.equalsIgnoreCase("icq")) {
//            icq = true;
//        }
        if (qName.equalsIgnoreCase("jabber")) {
            jabber = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

    }

    public void characters(char ch[], int start, int length) throws SAXException {
        super.characters(ch,start,length);
        if (name) {
            String _name = new String(ch, start, length);
        //    System.out.println("Name is : " + _name);
            customers.setName(_name);
            name = false;
        }
        if (surname) {
            String _Surname = new String(ch, start, length);
        //    System.out.println("Surname is : " + _Surname);
            customers.setSurname(_Surname);
            surname = false;
        } if (age) {
            String _age = new String(ch, start, length);
         //   System.out.println("Age is : " + _age);
            customers.setAge(Integer.valueOf(_age));
            age = false;
        }
//        if (city) {
//            String _city = new String(ch, start, length);
//            System.out.println("City is : " + _city);
//            city = false;
//        }
        if (phone) {
            String _phone = new String(ch, start, length);
        //    System.out.println("Phone is : " + _phone);
            Contacts contacts = new Contacts();
            contacts.setContact(_phone);
            contacts.setTypeContact(TypeContact.PHONE);
            contactsList.add(contacts);
            phone = false;
        } if (email) {
            String _email = new String(ch, start, length);
        //    System.out.println("e-mail is : " + _email);
            Contacts contacts = new Contacts();
            contacts.setContact(_email);
            contacts.setTypeContact(TypeContact.EMAIL);
            contactsList.add(contacts);
            email = false;
        }
//        if (icq) {
//            String _icq = new String(ch, start, length);
//            System.out.println("icq is : " + _icq);
//            contacts.setContact(_icq);
//         //   contacts.setTypeContact(TypeContact.);
//            contactsList.add(contacts);
//            icq = false;
//        }
        if (jabber) {
            String _jabber = new String(ch, start, length);
       //     System.out.println("jabber is : " + _jabber);
            Contacts contacts = new Contacts();
            contacts.setContact(_jabber);
            contacts.setTypeContact(TypeContact.JABBER);
            contactsList.add(contacts);
            jabber = false;
        }
    }

}
