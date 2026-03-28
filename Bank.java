import java.util.*;
import java.io.*;

public class Bank implements HasMenu{
	
	Admin admin = new Admin();
	CustomerList customers = new CustomerList();

        String BOLD = "\u001B[1m";
        String RESET = "\u001B[0m";

	public static void main(String[] args) {
		new Bank();
	} // end main
	
	public Bank() {
		//this.loadSampleCustomers();
		//this.saveCustomers();
		this.loadCustomers();
		this.start();
		this.saveCustomers();

	} // end Bank constructor
	
	public String menu() {
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println(BOLD + "Bank Menu " + RESET);
		System.out.println("______________________________");
		System.out.println();
		System.out.println("0) Exit system ");
		System.out.println("1) Login as admin ");
		System.out.println("2) Login as customer ");
		System.out.println("______________________________");
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
				System.out.println();
				System.out.println(BOLD + "Admin login" + RESET);
				System.out.println("______________________________");
				System.out.println();
				if (this.admin.login()) {
					startAdmin();
				} // end if
			} // end else if
			else if (response.equals("2")) {
				System.out.println();
				System.out.println(BOLD + "Customer login" + RESET);
				System.out.println("______________________________");
				System.out.println();
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
				System.out.println();
				System.out.println(BOLD + "Full customer report: " + RESET);
				System.out.println("______________________________");
				System.out.println();
				this.reportAllCustomers();
				System.out.println("______________________________");
			} // end else if
			else if (response.equals("2")) {
				System.out.println();
				System.out.println(BOLD + "Add a customer: " + RESET);
				System.out.println("______________________________");
				System.out.println();
				this.addUser();
				System.out.println("______________________________");
			} // end else if
			else if (response.equals("3")) {
				System.out.println();
				System.out.println(BOLD + "Apply interest to savings: " + RESET);
				System.out.println("______________________________");
				System.out.println();
				this.applyInterest();
				System.out.println("______________________________");
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
	
	public void loginAsCustomer() {
		Scanner input = new Scanner(System.in);
                System.out.print("User name: ");
                String userNameIn = input.nextLine();
                System.out.print("PIN: ");
                String PINin = input.nextLine();
		Customer currentCustomer = null;
		for (Customer customer: customers) {
			if (customer.login(userNameIn, PINin)) {
				currentCustomer = customer;
			} // end if
		} // end for loop
		if (currentCustomer == null) {
			System.out.println();
			System.out.println("Customer not found... ");
			System.out.println();
		} //end if
		else {
			currentCustomer.start();
		} // end else
	} // end log in as customer
	

	public void saveCustomers() {
		try {
			FileOutputStream fo = new FileOutputStream("Customers.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(customers);
			obOut.close();
			fo.close();
		} // end try
		catch (Exception e) {
			System.out.println(e.getMessage());
		} // end catch
	} // end save customers

	public void loadCustomers() {
		try {
			FileInputStream fi = new FileInputStream("Customers.dat");
			ObjectInputStream obIn = new ObjectInputStream(fi);
			customers = (CustomerList)obIn.readObject();
			obIn.close();
			fi.close();
		} // end try
		catch (Exception e) {
			System.out.println(e.getMessage());
		} // end catch
	} // end load customers
	
} // end Bank


class CustomerList extends ArrayList<Customer> {};

