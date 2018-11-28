package main;

public class ReadXmlCsv {

    public static void main(String[] args) {

        String fileName = "dane-osoby.txt";

     ConnectDB createDB = new CreateDB();
        createDB.connecting();

        CheckXml checkXml = new CheckXml();
        checkXml.readFirstLine(fileName);

        ReadFile readFile;

        if (checkXml.checkXmlHead()) {
            System.out.println("To jest XML z naglowkiem");
            readFile = new ReadFileXML();
            readFile.setFileName(fileName);
            ((ReadFileXML) readFile).setHeaderToRemoweXML(true);
            readFile.ReadAllObject();
        } else if (checkXml.checkXmlBody() ) {
            System.out.println("To jest XML bez naglowka");
            readFile = new ReadFileXML();
            readFile.setFileName(fileName);
            ((ReadFileXML) readFile).setHeaderToRemoweXML(false);
            readFile.ReadAllObject();
        }else {
            System.out.println("To jest CSV");
            readFile = new ReadFileCSV();
            readFile.setFileName(fileName);
            readFile.ReadAllObject();
        }
    }
}
