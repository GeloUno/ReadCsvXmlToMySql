package main;

import java.io.BufferedReader;
import java.io.IOException;

abstract public class ReadFile {

    String line;
    BufferedReader bRead = null;
    protected String fileName;


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

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
