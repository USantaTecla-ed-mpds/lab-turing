package main.es.labturing.plaguesStats.src.main.cat.plagues.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class MainView {

    private final static String DIRECTORY = "./tech-java-orientadoObjetos/src/main/es/labturing/plaguesStats/src/main/resources";
    private File directory = new File(MainView.DIRECTORY);
    private final String fileName = "index.html";
    private Document document;

    public MainView() {
        this.document = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            InputStream is = new FileInputStream(new File(this.directory, this.fileName));
            DocumentBuilder db = dbf.newDocumentBuilder();
            this.document = db.parse(is);
        } catch (IOException | ParserConfigurationException | SAXException e1) {
            e1.printStackTrace();
        }
        Node hello = this.document.getElementById("hello");
        hello.setTextContent("Nuevo titulo hello");
    }

}
