import java.util.*;
import java.io.*;

public class Bank implements HasMenu{
	
	Admin admin = new Admin();
	CustomerList customers = new CustomerList();
	
	public static void main(String[] args) {
		new Bank();
	} // end main
	
	public Bank() {
		this.loadSampleCustomers();
		this.start();

	} // end Bank constructor
	
	public String menu() {
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Bank Menu ");
		System.out.println();
		System.out.println("0) Exit system ");
		System.out.println("1) Login as admin ");
		System.out.println("2) Login as customer ");
		System.out.println();
		System.out.print("Your response: ");
		String response = input.nextLine();

		return response;
	} // end menu
	
	public void start() {
		boolean keepGoing = true;
		while (keepGoing) {
			String response = menu();
			if (response.equals("0")) {
				keepGoing = false;
			} // end if
			else if (response.equals("1")) {
				System.out.println("Admin login");
				if (this.admin.login()) {
					startAdmin();
				} // end if
			} // end else if
			else if (response.equals("2")) {
				System.out.println("Customer login");
			} // end else if
			else {
				System.out.println("Please enter 0, 1, or 2 ");
			} // end else
		} // end while 
	} // end start
	
	public void startAdmin() {
		boolean keepGoing = true;
		while (keepGoing) {
			String response = admin.menu();
			if (response.equals("0")) {
				keepGoing = false;
			} // end if
			else if (response.equals("1")) {
				System.out.println("Full customer report");
				this.reportAllCustomers();
			} // end else if
			else if (response.equals("2")) {
				System.out.println("Add a customer");
				this.addUser();
			} // end else if
			else if (response.equals("3")) {
				System.out.println("Apply interest to savings");
				this.applyInterest();
			} // end else if
		} // end while loop
	} // end startAdmin

	public void loadSampleCustomers() {
		customers.add(new Customer("Alice", "1111"));
		customers.add(new Customer("Bob", "2222"));
		customers.add(new Customer("Cindy", "3333"));
	} // end load Sample Customers


	public void reportAllCustomers() {
		for (Customer customer: customers) {
			System.out.println(customer.getReport());
		} // end for
	} // end report all customers
	
	public void addUser() {
		Scanner input = new Scanner(System.in);
		System.out.print("User name: ");
		String userName = input.nextLine();
		System.out.print("PIN: ");
		String PIN = input.nextLine();
		customers.add(new Customer(userName, PIN));
	} // end addUser
	
	public void applyInterest() {
		for (Customer customer: customers) {
			customer.savings.calcInterest();
		} // end for
	} // end apply interest
} // end Bank


class CustomerList extends ArrayList<Customer> {};

