package user;
//The purpose of this class is to represent the retailer/vendor in the QwikTran system
//this persona receives transactions from the QwikTran system deposit through the Child
public class Retailer {
	
	protected String shopName;
	protected String email;
	protected String password;
	protected String location;

	
	public Retailer(String shopName, String email, String password, String location, String bankAccount) {
		this.shopName = shopName;
		this.email = email;
		this.password = password;
		this.location = location;
	}

	public String getShopName() {
		return shopName;
	}
	public String getItemName() {
		return "Apples";
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public String ReadQRandMakeTranaction(String QRpath, String amount){
		QRReader qrreader = new QRReader();
		String transactionstring = qrreader.QRread(QRpath);
		return transactionstring + " spent [" + amount + "] at " + getShopName();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public void purchaseNotif(Child child, int value) {
		String send = child.getFirstName() + " has purchased at " + getShopName() + " for $" + Integer.toString(value);
		SmsSender.txtTrans(send, "Parent");
	}
	
	public static void main(String[] args) {
//		//Retailer(String shopName, String email, String password, String location, String bankAccount)
//		Retailer r = new Retailer("Harshil&sons", "harshilp0@gmail.com", "patel","83 Queens Quay","123");
//		//Child(String username,String FirstName, String LastName, int age, int balance)
//		Child c = new Child("tirth","Tirth","Shah",21,12);
//		r.purchaseNotif(c, 5);
//		System.out.println("Ran");
	}

}
