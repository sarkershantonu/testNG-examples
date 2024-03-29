package runner;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by shantonu on 6/5/16.
 */
public class TestNGRunner {

    private static void run(List<XmlSuite> suits){
        TestNG runner = new TestNG();
        runner.setXmlSuites(suits);
        runner.run();
    }
    private static void run(XmlSuite suits){
        List<XmlSuite> items = new ArrayList<XmlSuite>();
        items.add(suits);
        run(items);
    }

    public static void run(String xmlPath) throws IOException {
        List<XmlSuite> suits = (List<XmlSuite>) new Parser(xmlPath).parse();
        run(suits);
    }

    public static void runAllSuites(Collection<String> xmls) throws IOException {
        List<XmlSuite> suits = new ArrayList();
        for (String xml : xmls) {
            suits.addAll( new Parser(xml).parse());
        }
        new TestNG().setXmlSuites(suits);
    }

    public static void runAllSuitesFromFolder(String folderPath) throws IOException {
        File folder = new File(folderPath);
        for (File f : folder.listFiles()) {
            if (f.isFile()) {
                run(f.getName());
            }
        }
    }

    public void runAllInResources() throws IOException {
        runAllSuitesFromFolder(System.getProperty("user.dir") + "/src/test/resources");
    }
    public static void runTestNgXml() throws IOException {
        run("testng.xml");
    }
}
