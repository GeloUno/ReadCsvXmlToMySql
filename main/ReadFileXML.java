package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileXML extends ReadFile {

    BufferedReader bRead = null;
    String fileName = "dane-osoby.txt";
    String xmlBodyOne = "";

    private boolean removeHeadXML;

    public void setHeadToRemoweXML(boolean removeHeadXML) {
        this.removeHeadXML = removeHeadXML;
    }

//    @Override
//    String ReadOneObject() {
//        return null;
//    }

    @Override
    public void ReadAllObject() {
        try {
            bRead = new BufferedReader(new FileReader(fileName));
            if (this.removeHeadXML) {
                readLine(bRead);
            }
            do {
                do {
                    xmlBodyOne += readLine(bRead);

                } while (line.indexOf("/person") == -1);
                System.out.println(xmlBodyOne);
                xmlBodyOne = "";

            } while (line.indexOf("/persons") == -1);// </persons>

            line.trim();
        } catch (IOException ex) {
            System.out.printf("can't read file");
        }


    }
}
