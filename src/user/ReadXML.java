package user;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {
  
  public static ArrayList<HashMap<String,String>> readInfo (String path) throws SAXException, IOException, ParserConfigurationException{
    File xmlFile = new File(path);
    
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document document = documentBuilder.parse(xmlFile);
    
    NodeList list = document.getElementsByTagName("Parent-");
    
    //create array list to store all info
    ArrayList<HashMap<String, String>> storage = new ArrayList<HashMap<String, String>>();
    
    for (int i = 0; i < list.getLength(); i++){
      org.w3c.dom.Node node = list.item(i);
      
      if(node.getNodeType() == Node.ELEMENT_NODE){
        
        Element element = (Element) node;
        HashMap<String, String> eachInfo = new HashMap<String, String>(); 
        eachInfo.put("Username", element.getAttribute("Username"));
        storage.add(eachInfo);
        
        eachInfo.put("Parent LName", element.getElementsByTagName("ParentLName").item(0).getTextContent());
        eachInfo.put("Parent FName", element.getElementsByTagName("ParentFName").item(0).getTextContent());
        eachInfo.put("ChildID", element.getElementsByTagName("ChildID").item(0).getTextContent());
        eachInfo.put("Price", element.getElementsByTagName("Price").item(0).getTextContent());
        eachInfo.put("Item Name", element.getElementsByTagName("ItemName").item(0).getTextContent());
        eachInfo.put("Retailer Name", element.getElementsByTagName("RetailerName").item(0).getTextContent());
        eachInfo.put("Location", element.getElementsByTagName("GeoLocation").item(0).getTextContent());
        //eachInfo.put("Transcation", element.getElementsByTagName("TransactionNum").item(0).getTextContent());
        //eachInfo.put("Child FName", element.getElementsByTagName("ChildFname").item(0).getTextContent());
        //eachInfo.put("Child LName", element.getElementsByTagName("ChildLname").item(0).getTextContent());

      }    
    }
    return storage;
  }
  
  public static void main (String [] args) throws SAXException, IOException, ParserConfigurationException{
    
    String path = "C:\\Users\\Tirth Shah\\Desktop\\info.xml";
    ArrayList<HashMap<String, String>> storage = readInfo(path);
    System.out.println(storage);

    

  } 
}
