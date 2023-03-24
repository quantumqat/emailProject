package emailapp;
import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int defaultPassLength = 10;
	private String department;
	private String altEmail;
	private int mailboxCapacity = 500;
	private String businessWebAddr = "xyz.com";
	
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDept();
		
		
		this.password = randPass(this.defaultPassLength);
		
		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + businessWebAddr;
		
	}
	
	private String setDept() {
		System.out.print("Enter the dept:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for N/A\nEnter Dept Selection: ");
		Scanner in = new Scanner(System.in);
		int deptSelection = in.nextInt();
		if (deptSelection == 1) {
			return "sales"; 
		} else if (deptSelection == 2) {
			return "dev";
		}
		 else if (deptSelection == 3) {
			return "acct";
		}
		 else {return " ";}
		
	}
	
	private String randPass (int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&";
		char[] password = new char [length];
		for (int i=0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
					password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void setMailCapacity(int capacity) {
		mailboxCapacity = capacity;
	}
	
	public void setAltEmail(String alternateEmail) {
		altEmail = alternateEmail;
	}
	
	public void changePass(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity(){ return mailboxCapacity; }
	
	public String getAltEmail() { return altEmail; }
	
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "Display Name: " + firstName + " " + lastName +
				"\nBusiness Emai: " + email + 
				"\nPassword: " + password + 
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
	}
}
