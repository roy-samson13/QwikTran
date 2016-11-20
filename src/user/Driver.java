/**
 * 
 */
package user;

/**
 * @author Ralph
 *
 */
public class Driver {
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//Register Parent
		Parent Vrund = new Parent("VrundIoT","vrund" ,"927548234612374523");
		//Add children to relation with parents
		Vrund.addChild("Ralph13","ralph", "royestern",13);
		Vrund.addChild("Tirth16","tirth", "shah",16);
		//Deposit 700 to Tirth
		System.out.println(Vrund.Children.get(1).Deposit(700));
		//Deposit 500 to Ralph
		System.out.println(Vrund.Children.get(0).Deposit(500));
		//send sms notification to Dad
		SmsSender SMS = new SmsSender();
		SMS.txtTrans(Vrund.Children.get(0).Deposit(500), "Child");
		
		//get the QR code for Ralph
		String Ralph_QR = (Vrund.Children.get(0)).getQRcode(Vrund.getUsername(), Vrund.Children.get(0).getUsername());
		System.out.println(Ralph_QR);
		String Tirth_QR = (Vrund.Children.get(1)).getQRcode(Vrund.getUsername(), Vrund.Children.get(1).getUsername());
		System.out.println(Tirth_QR);
		
		Retailer James = new Retailer("James&Sons", "James&Sons@lazyboy.com", "lazyboy_123", "Scarborough","936468993164993");
		//Ralph buys something from James&Sons for $100
		String transactionstring = James.ReadQRandMakeTranaction(Ralph_QR, "$100");
		System.out.println(transactionstring.replace("_", " "));
		
		//send all data to backend storage server
//		CreateXMLFile xmlobject = new CreateXMLFile("C:\\Users\\Ralph\\Desktop\\final\\Bits\\FinTech\\FinTechProject\\src\\libs", Vrund.getUsername(), Vrund.getFirstname(), Vrund.getLastname(), Vrund.Children.get(0).getFirstName(), Vrund.Children.get(0).getLastName(), "093439", James.getShopName(), James.getItemName(), James.location);
		
		
		//send sms notification to Dad
		SMS.txtTrans(transactionstring.replace("_", " ") , "Parent");
		
		//Ralph buys something from James&Sons for $100
		String transactionstring2 = James.ReadQRandMakeTranaction(Tirth_QR, "$300");
		System.out.println(transactionstring2.replace("_", " "));

		//send sms notification to Dad
		SMS.txtTrans(transactionstring2.replace("_", " ") , "Parent");

		
		
		
		

	}

}
