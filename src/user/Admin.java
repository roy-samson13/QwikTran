package user;
//The purpose of this class is to represent the Customer care in the QwikTran system
//this persona receives notifications on errors, false transactions, etc through the QwikTran system
public class Admin {
	
	private int employeeNumber;
	private String name;
	
	public Admin(int employeeNumber, String name)
	{
		this.employeeNumber = employeeNumber;
		this.name = name;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
