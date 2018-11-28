package main;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class ReadFileXML extends ReadFile {

    String xmlBodyOne = "";

    private boolean removeHeadXML;

    public void setHeaderToRemoweXML(boolean removeHeadXML) {
        this.removeHeadXML = removeHeadXML;
    }

    @Override
    public void ReadAllObject() {
        DefaultHandler handler = new ParserXml();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            bRead = new BufferedReader(new FileReader(fileName));
            readLine(bRead);
            if (this.removeHeadXML) {
                readLine(bRead);
            }
            do {
                do {

                    xmlBodyOne += readLine(bRead);
                } while (line.indexOf("/person") == -1);
                /**
                 * stop parsing after load last tag
                 */
                if(xmlBodyOne.indexOf("</persons>")!=0) {
                    parser.parse(new InputSource(new StringReader(xmlBodyOne)), handler);
                }
                    xmlBodyOne = "";

            } while (line.indexOf("/persons") == -1);
        } catch (IOException ex) {
            System.out.printf("can't read file");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
