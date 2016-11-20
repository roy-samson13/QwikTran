package user;

import java.util.ArrayList;
import java.util.List;

//The purpose of this class is to represent the Parent/Guardian in the QwikTran system
//this persona receives notifications on transactions, spending summaries etc through the QwikTran system
public class Parent {
	
	private String username;
	private String password;
	private String bankAccountNumber;
//	private int balance;
	public ArrayList<Child> Children;
	
	public Parent(String username, String password,String bankAccountNumber)
	{
		this.username = username;
		this.password = password;
		this.bankAccountNumber = bankAccountNumber;
		this.Children  = new ArrayList<Child>();
	}
	
	

	@Override
	public String toString() {
		return "Username: " + this.username;
	}
	

	public String getUsername() {
		return username;
	}
	
	public String getFirstname() {
		return username;
	}
	
	public String getLastname() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	
//	public int getBalance() {
//		return balance;
//	}
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
	
	protected void addChild(String username,String FirstName, String LastName, int childAge) {
		Child child = new Child(username,FirstName,LastName ,childAge, 0);
		Children.add(child);
	}
	
//	protected Child addBalance(Child child, int bal) {
//		this.balance += bal;
//		return child;
//	}
//	
//	protected Child deductBalance(Child child, int bal) {
//		this.balance -= bal;
//		return child;
//	}
	
	protected String purchaseHistory(Child child) {
		String purchaseHistory = "";
		for(int i = 0; i < child.purchases.size();i++)
		{
			System.out.println(child.purchases.get(i));
		}
		return purchaseHistory;
	}
	
	
	



}
