import java.util.*;
import java.io.*;

public class Admin extends User implements HasMenu, Serializable {
	
	public static void main(String[] args) {
		Admin a = new Admin();
		a.login();
	} // end main
	
	public Admin(){
		this.userName = "admin";
		this.PIN = "0000";
	} // end constructor

	public String menu(){
		Scanner input = new Scanner(System.in);

		System.out.println();
		System.out.println("Admin Menu ");
		System.out.println();
		System.out.println("0) Exit the menu ");
		System.out.println("1) Full customer report ");
		System.out.println("2) Add user ");
		System.out.println("3) Apply interest to savings accounts ");
		System.out.println();
		System.out.println(" Your answer: ");

		String response = input.nextLine();
		return response;
		
	} // end menu
	

	public void start(){

	} // end start
	
	public String getReport(){
		String report = "Admin userName: " + this.getUserName();
		report += ", Admin PIN: " + this.getPIN();

		return report;
	} // end getReport

} // end Admin
