// Customer class

import java.util.*;
import java.io.*;

public class Customer extends User implements Serializable {
	static final long serialVersionUID = 1L;
	CheckingAccount checking = new CheckingAccount();
	SavingsAccount savings = new SavingsAccount();

	public static void main(String[] args) {
		//for testing
		Customer c = new Customer();
		if (c.login()) {
			c.start();
		} // end if
	} // end main
	
	public Customer() {
		this.userName = "Alice";
		this.PIN = "1111";
	} // end Customer constructor with no parameters
	
	public Customer(String userName, String PIN) {
		this.userName = userName;
		this.PIN = PIN;
	} // end Customer constructor with parameters
	
	public String getReport() {
		String report = "User: " + this.getUserName();
		report += ", Checking: " + this.checking.getBalanceString();
		report += ", Savings: " + this.savings.getBalanceString();
		return report;
	} // end getReport
	
	public void start() {
		boolean keepGoing = true;
		String result;
		while (keepGoing) {
			result = menu();
			if (result.equals("0")) {
				keepGoing = false;
			} // end if
		       	else if (result.equals("1")) {
				System.out.println("Checking account: ");
				this.checking.start();
			} // end else if
			else if (result.equals("2")) {
                                System.out.println("Savings account: ");
                                this.savings.start();
                        } // end else if
			else if (result.equals("3")) {
                                System.out.println("Change PIN: ");
				System.out.println("What would you like to change it to? ");
				Scanner input = new Scanner(System.in);
				String newPIN = input.nextLine();
                                this.setPIN(newPIN);
                        } // end else if
			else {
				System.out.println("You should enter 0, 1 , 2, or 3");
			} // end else
		} //end while

		
		//this is the main loop!!
		//ask for a menu input
		//go to correct place
		//run the Customer menu
		//when customer chooses account-> go to that account's menu
		// fill out later
	} // end start
	
	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Customer menu: ");
		System.out.println();
		System.out.println("0) Exit ");
		System.out.println("1) Manage Checking Account ");
		System.out.println("2) Manage Savings Account ");
		System.out.println("3) Change PIN ");
		System.out.println();
		System.out.print("Your action: (0-3) ");
		String result = input.nextLine();
		return result;
	} // end menu
	
} // ends Customer class definition
