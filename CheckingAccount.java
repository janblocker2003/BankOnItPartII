//Checking ACcount code

import java.util.*;
import java.io.*; //using second week

public class CheckingAccount implements HasMenu, Serializable {
	double balance;

	public static void main(String[] args) {
		CheckingAccount ca = new CheckingAccount();
		ca.start();
	} // end main (tester function)
	
	public CheckingAccount(){
		this.balance = 0d; //d means this is a double
	} // end no parameter constructor
	
	public CheckingAccount(double balance) {
		this.balance = balance;
	} // end constructor with parameter
	
	public String menu(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("0) Quit");
		System.out.println("1) Check Balance");
		System.out.println("2) Make a Deposit");
		System.out.println("3) Make a Withdrawal");
		System.out.println();
		System.out.print("Enter 0-3: ");
		String response = input.nextLine();
		return response;
	} // end menu
	
	public void start(){
		boolean keepGoing = true;
		String response;
		while (keepGoing) {
			response = menu();
			if (response.equals("0")){
				keepGoing = false;
			} // end if
			else if (response.equals("1")){
				System.out.println(" Checking balance now... ");
				this.checkBalance();
			} // end else if 1
			else if (response.equals("2")){
				System.out.println(" Making a desposit now...");
				this.makeDeposit();
			} // end else if 2
			else if (response.equals("3")){
				System.out.println(" Making a withdrawal now... ");
				this.makeWithdrawal();
			} // end else if 3
			else {
				System.out.println( " Please enter 0, 1, 2, or 3 ");
			} // end else
		} // end while loop
	} // end start


	public double getBalance(){
		return this.balance;
	} // end getBalance
	
	public String getBalanceString(){
		String result = String.format("$%.02f", this.balance);
		return result;
	} // end getBalanceString

	public void setBalance(double balance){
		this.balance = balance;
	} // end setBalance
	
	private double getDouble(){
		Scanner input = new Scanner(System.in);
		String resultString = input.nextLine();
		double result = 0d;
		try {
			result = Double.parseDouble(resultString);
		} // end try
		catch (Exception e) {
			System.out.println("Cannot use this value. Changing to 0. ");
			result = 0d;
		} //end catch
		return result;
	} // end getDouble

	public void checkBalance(){
		System.out.print("Current Balance: ");
		System.out.println(this.getBalanceString());
	} // end checkBalance

	public void makeDeposit(){
		System.out.print(" How much do you want to deposit? ");
		double deposit = this.getDouble();
		this.balance += deposit;
		System.out.println("New balance: " + this.getBalanceString());
	} // end makeDeposit
	
	public void makeWithdrawal(){
		System.out.print("How much would you like to withdrawal? ");
		double withdrawal = this.getDouble();
		if (withdrawal > this.balance){
			System.out.println("Insufficient Funds. ");
		} // end if
		else if (withdrawal < 0) {
			System.out.println("Make a deposit elsewhere. ");
		} // end else if
		else {
			this.balance -= withdrawal;
		} // end else
		System.out.println("New balance: " + this.getBalanceString());
	} // end makeWithdrawal
	
	

} // end Checking Account Class definition
