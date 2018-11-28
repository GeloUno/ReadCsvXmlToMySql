package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserCsv {
    Customers customers;
    Contacts contacts;
    List<Contacts> contactsList;

    List<String> bodyCSV;
    PrintObjectCustomers printObjectCustomers;


    public void parser(String bodyLineCsv) {
        IsInteger is_Number = new IsInteger();
        bodyCSV = new ArrayList<>();
        customers = new Customers();
        printObjectCustomers = new PrintObjectCustomers();
        contactsList = new ArrayList<>();


        bodyCSV = Arrays.asList(bodyLineCsv.split(","));

        customers.setName(bodyCSV.get(0));
        customers.setSurname(bodyCSV.get(1));


        if (is_Number.isInteger(bodyCSV.get(2))) {
            customers.setAge(Integer.parseInt((bodyCSV.get(2))));
        } else {
            customers.setAge(0);
        }
        for (int i = 4; i < bodyCSV.size(); i++) {

            /**
             * if is a number
             */

            if (is_Number.isInteger(bodyCSV.get(i).replace(" ", ""))) {
                int intHelper = Integer.valueOf((bodyCSV.get(i).replace(" ", "")));

                /**
                 * if number is length 9 word it is a phone
                 */

                if (bodyCSV.get(i).replace(" ", "").length() == 9) {
                    contacts = new Contacts();
                    contacts.setTypeContact(TypeContact.PHONE);
                    contacts.setContact(String.valueOf(intHelper));
                    contactsList.add(contacts);

                } else {
                    /**
                     * code for icq
                     * number not length 9
                     */
                }
            }

            /**
             * if word have @ it is a e-mail
             */

            else if(bodyCSV.get(i).indexOf("@")!=-1 ) {
                contacts = new Contacts();
                contacts.setTypeContact(TypeContact.EMAIL);
                contacts.setContact(bodyCSV.get(i));
                contactsList.add(contacts);
            }
            /**
             *  if it is not a number it is a string
             *  if length after trim is more that 0 is jabber
             */
            else if(!(is_Number.isInteger(bodyCSV.get(i).replace(" ", "")))&&(bodyCSV.get(i).trim().length()>0)) {
                contacts = new Contacts();
                contacts.setTypeContact(TypeContact.JABBER);
                contacts.setContact(bodyCSV.get(i));
                contactsList.add(contacts);
            }
            /**
             * if it not a number
             * and if it not a string
             * and it
             * it is UNKNOW
             */
            else if(bodyCSV.get(i).trim().length()>0) {
                     System.out.println("UNKNOW"+bodyCSV.get(i));
                contacts = new Contacts();
                contacts.setTypeContact(TypeContact.UNKNOWN);
                contacts.setContact(bodyCSV.get(i));
                contactsList.add(contacts);
            }
        }
        customers.setContacts(contactsList);
        printObjectCustomers.print(customers);
    }
}
