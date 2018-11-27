package main;

import java.io.BufferedReader;
import java.io.IOException;

abstract public class ReadFile {
    String OneObjectPerson;
    String line;
    Customers customersl;

 //   abstract String ReadOneObject();

    abstract void ReadAllObject();

    String readLine(BufferedReader b) {
        try {
            do {
                this.line = b.readLine();
            } while (this.line.length() == 0);
        } catch (IOException ex) {
            System.out.println("Can't read Line in file");
        }
        return this.line;
    }
}
