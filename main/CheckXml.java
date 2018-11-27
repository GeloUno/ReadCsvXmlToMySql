package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckXml {
    private String samlpeXml;
    private String headXmlhelper = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
    private String bodyXmlhelper = "<persons>";


    /**
     *
     * @param fileName Url and file name to read
     * @return first line not empty
     */

    public String readFirstLine(String fileName) {
        BufferedReader bRead = null;
        try {
            bRead = new BufferedReader(new FileReader(fileName));
            do {
                this.samlpeXml = bRead.readLine();
            } while (this.samlpeXml.length() == 0);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return this.samlpeXml;
    }

        /**
         *
         * @return   // return false if file don't have head xml
         */

        public boolean checkXmlHead () {

            if (this.samlpeXml.indexOf(this.headXmlhelper) == 0) {
                return true;
            } else {
                return false;
            }
        }

        /**
         *
         * @return  // return false if file don't have body object persons xml
         */

        public boolean checkXmlBody () {
            if (this.samlpeXml.indexOf(this.bodyXmlhelper) == 0) {
                return true;
            }
            return false;
        }
    }
