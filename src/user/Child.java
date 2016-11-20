package user;
//The purpose of this class is to represent the Child in the QwikTran system
//this persona makes transactions through the QwikTran system
import java.util.ArrayList;

public class Child {
	
	private String FirstName;
	private String LastName;
	private int age;
	private String username;
	private int balance;
	protected ArrayList<String> purchases = new ArrayList<String>();
	
	public Child(String username,String FirstName, String LastName, int age, int balance){
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.age = age;
		this.username = username;
		this.balance = balance;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + this.FirstName + " " + this.LastName + ", Age: " + this.age + ", Balance: " + this.balance;
	}
	
	public String Deposit(int amount){
		this.balance = amount;
		return "you have a balance of amount $" + Integer.toString(this.balance);
	}
	public String getFirstName() {
		return FirstName;
	}
	
	public String getQRcode(String userName, String childID) throws Exception {
		CodeGen QR = new CodeGen();
		return QR.QRgenerator(userName, childID);
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	public int balance(){
		return this.balance;
	}
	public void purchase(String item, int cost) {
		if(this.balance >= cost)
		{
			this.balance = this.balance - cost;
			this.purchases.add(item + " " + cost + "\n");
		}
		else
		{
			System.out.println("You do not have enough balance");
		}
		
	}
	
	
	

}
