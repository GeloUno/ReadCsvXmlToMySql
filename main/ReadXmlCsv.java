package main;

public class ReadXmlCsv {
    public static void main(String[] args) {
//        BufferedWriter bWrite = null;
//        BufferedReader bRead = null;
        String fileName = "dane-osoby.txt";
//        String line = "";
//        String line2 = "";
//        String xmlBodyOne = "";

//        try{
//            bWrite = new BufferedWriter(new FileWriter(fileName));
//            bWrite.write("Test");
//            bWrite.close();
//        }catch (IOException ex)
//        {
//            System.out.printf(ex+" ");
//        }


        CheckXml checkXml = new CheckXml();
        checkXml.readFirstLine(fileName);

        ReadFile readFile;
//        System.out.println(checkXml.checkXmlHead());
//        System.out.println(checkXml.checkXmlBody());
        if (checkXml.checkXmlHead()) {
            System.out.println("To jest XML z naglowkiem");
            readFile = new ReadFileXML();
            ((ReadFileXML) readFile).setHeadToRemoweXML(true);
            readFile.ReadAllObject();
        } else if (checkXml.checkXmlBody() ) {
            System.out.println("To jest XML bez naglowka");
            readFile = new ReadFileXML();
            ((ReadFileXML) readFile).setHeadToRemoweXML(false);
            readFile.ReadAllObject();
        }else {
            System.out.println("To NIE jest XML");
        }

//        try {
//            bRead = new BufferedReader(new FileReader(fileName));
//            do {
//                line = bRead.readLine();
//            } while (line.length() == 0);
//            System.out.println("TEST");
//            System.out.println(line);
//            line2 = bRead.readLine();
//
//            do {
//                xmlBodyOne = "";
//                do {
//                    line2 = bRead.readLine();
//                    xmlBodyOne += line2;
//                    //  System.out.println(xmlBodyOne);
////                      System.out.println(line2.indexOf("</person>"));
//                } while (line2.indexOf("person") == -1);
//                System.out.println(xmlBodyOne);
//            } while (line2.indexOf("persons") == -1);// </persons>
//
//            line.trim();
//        } catch (IOException ex) {
//            System.out.printf("can't read file");
//        }


    }


}
