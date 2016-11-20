package user;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLFile{
  
  
  public static void CreateXMLFile(String path, String username, String pFName,  
      String pLName,String cID, String cFName, String cLName, 
      String tran, String rName, String iName, String p, String loc) throws
  TransformerException, ParserConfigurationException {
    
    try{
      
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

      Document document = documentBuilder.newDocument();

      Element element = document.createElement("Parent-");
      document.appendChild(element);

      //id
      Attr attr = document.createAttribute("Username");
      attr.setValue(username);
      element.setAttributeNode(attr);

      Element fname = document.createElement("ParentFName");
      fname.appendChild(document.createTextNode(pFName));
      element.appendChild(fname);

      Element lname = document.createElement("ParentLName");
      lname.appendChild(document.createTextNode(pLName));
      element.appendChild(lname);

      Element childID = document.createElement("ChildID");
      childID.appendChild(document.createTextNode(cID));
      element.appendChild(childID);
      
      Element childF = document.createElement("ChildFName");
      childF.appendChild(document.createTextNode(cFName));
      element.appendChild(childF);
      
      Element childL = document.createElement("ChildLName");
      childL.appendChild(document.createTextNode(cLName));
      element.appendChild(childL);
      
      Element transacNum = document.createElement("TransactionNum");
      transacNum.appendChild(document.createTextNode(tran));
      element.appendChild(transacNum);

      Element retailerName = document.createElement("RetailerName");
      retailerName.appendChild(document.createTextNode(rName));
      element.appendChild(retailerName);

      Element itemName = document.createElement("ItemName");
      itemName.appendChild(document.createTextNode(iName));
      element.appendChild(itemName);
       
      Element price = document.createElement("Price");
      price.appendChild(document.createTextNode(p));
      element.appendChild(price);
      
      Element location = document.createElement("GeoLocation");
      location.appendChild(document.createTextNode(loc));
      element.appendChild(location);
      
      TransformerFactory tranFac = TransformerFactory.newInstance();
      Transformer tranForm = tranFac.newTransformer();
      DOMSource source = new DOMSource(document);

      StreamResult streamResult = new StreamResult(new File(path));

      tranForm.transform(source, streamResult);
      
  }
  catch (TransformerException e){
    System.out.println("E1");
  }
  catch (ParserConfigurationException e){
    System.out.println(("E2"));
   }
  }

    public static void main(String args[]) throws TransformerException, ParserConfigurationException
    {
      String path = "C:\\Users\\Tirth Shah\\Desktop\\trail.xml";
      String username = "shahtirt";
      String pFName = "Tirth";
      String pLName = "Shah";
      String childID = "tirth96@hotmial.com";
      String cFName = "Tirth's";
      String cLName = "Kid";
      String tranNum = "2930";
      String rName = "Walmart";
      String iName = "Bottle of Coke";
      String price = "$2.12";
      String loc = "M1H 2Y4";
      
      
      CreateXMLFile(path, username, pFName, pLName, childID, cFName, cLName,
          tranNum, rName, iName, price, loc);   
      

    }
}   