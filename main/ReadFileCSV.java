package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileCSV extends ReadFile {

    String csvBodyOne = "";
    ParserCsv parserCsv;

    @Override
    void ReadAllObject() {
        try {
            bRead = new BufferedReader(new FileReader(fileName));
            do {
                this.line = bRead.readLine();
                csvBodyOne = this.line;
                if (csvBodyOne != null) {
                    if (csvBodyOne.length() > 0) {
                        parserCsv = new ParserCsv();
                        parserCsv.parser(csvBodyOne);
                    }
                }
            } while (this.line != null);
        } catch (IOException ex) {
            System.out.printf("can't read file");
        }
    }
}



