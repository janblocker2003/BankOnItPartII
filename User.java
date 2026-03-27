// user abstract

import java.util.*;
import java.io.*;

public abstract class User implements Serializable, HasMenu {
	String userName = "";
	String PIN = "";

	public void setUserName(String userName) {
		this.userName = userName;
	} // end setUserName
	
	public String getUserName(){
		return this.userName;
	} // end getUserName
	
	public void setPIN(String PIN) {
		if (PIN.matches("^\\d{4}$")) {
			this.PIN = PIN;
		} // end if
		else {
			System.out.println("The PIN must be 4 numeric digits. ");
			System.out.println("Setting PIN to 0000. ");
			this.PIN = "0000";
		} // end else
	} // end setPIN
	
	public String getPIN(){
		return this.PIN;
	} // end getPIN
	
	public boolean login(String userNameIn, String pinIn) {
		boolean result = false;
		if (userNameIn.equals(this.userName)) {
			if (pinIn.equals(this.PIN)) {
				result = true;
			} // end if for PIN
		} // end if for userName
		return result;		
	} // end login with login parameters
	
	public boolean login() {
		Scanner input = new Scanner(System.in);
		boolean result = false;
		System.out.print("Username: ");
		String userNameIn = input.nextLine();
		if (userNameIn.equals(this.userName)) {
			System.out.print("PIN: ");
			String pinIn = input.nextLine();
			if (pinIn.equals(this.PIN)) {
				System.out.println("Login was successful!");
				result = true;
			} // end if for PIN
			else {
				System.out.println("That PIN is incorrect. ");
			} // end else for PIN
		} // end if for userName
		else {
			System.out.println("That Username is incorrect. ");
		} // end else for userName
		return result;
	} // end login with no parameters

	public abstract String getReport();	

} // ends User abstract  definition
