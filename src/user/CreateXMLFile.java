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

    public static void main(String args[]) throws TransformerException, ParserConfigurationException
    {
        try{
          
          DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

          Document document = documentBuilder.newDocument();

          Element element = document.createElement("Parent-");
          document.appendChild(element);

          //id
          Attr attr = document.createAttribute("Username");
          attr.setValue("shahtirt");
          element.setAttributeNode(attr);

          Element fname = document.createElement("ParentFName");
          fname.appendChild(document.createTextNode("Tirth"));
          element.appendChild(fname);

          Element lname = document.createElement("ParentLName");
          lname.appendChild(document.createTextNode("Shah"));
          element.appendChild(lname);

          Element childID = document.createElement("ChildID");
          childID.appendChild(document.createTextNode("1"));
          element.appendChild(childID);
          
          Element childF = document.createElement("ChildFName");
          childF.appendChild(document.createTextNode("Hey"));
          element.appendChild(childF);
          
          Element childL = document.createElement("ChildLName");
          childL.appendChild(document.createTextNode("There"));
          element.appendChild(childL);
          
          Element transacNum = document.createElement("TransactionNum");
          transacNum.appendChild(document.createTextNode("23382"));
          element.appendChild(transacNum);

          Element retailerName = document.createElement("RetailerName");
          retailerName.appendChild(document.createTextNode("WalMart"));
          element.appendChild(retailerName);

          Element itemName = document.createElement("ItemName");
          itemName.appendChild(document.createTextNode("Bottle of Coke"));
          element.appendChild(itemName);
           
          Element price = document.createElement("Price");
          price.appendChild(document.createTextNode("$3.45"));
          element.appendChild(price);
          
          Element location = document.createElement("GeoLocation");
          location.appendChild(document.createTextNode("M1H 2Y4"));
          element.appendChild(location);
          
          TransformerFactory tranFac = TransformerFactory.newInstance();
          Transformer tranForm = tranFac.newTransformer();
          DOMSource source = new DOMSource(document);

          StreamResult streamResult = new StreamResult(new File("C:\\Users\\Tirth Shah\\Desktop\\info.xml"));

          tranForm.transform(source, streamResult);
      }
      catch (TransformerException e){
        System.out.println("E1");
      }
      catch (ParserConfigurationException e){
        System.out.println(("E2"));
       }
   }
}   