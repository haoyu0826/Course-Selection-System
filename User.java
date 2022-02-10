package hw01;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable{
	//All users should not have the same username
	
	//Data field
	String firstname;
	String lastname;
	String username;
	String password;
	
	//Default constructor
		public User() {
			
		}
		
		//Constructor
		public User(String username, String password) {
			this.username = username;
			this.password = password;
		}
		
		//Set the firstname
		public void setFirstname() {
			System.out.println("Please enter firstname: ");
			Scanner input = new Scanner(System.in);
			firstname = input.next();
		}
		
		//Set the lastname
		public void setLastname() {
			System.out.println("Please enter lastname: ");
			Scanner input = new Scanner(System.in);
			lastname = input.next();
		}
		
		//Get the firstname
		public 	String getFirstname() {
			if(firstname == null) {
				setFirstname();
				return firstname;
			}
			else {
				return firstname;
			}
		}
		
		//Get the firstname
		public 	String getLastname() {
			if(lastname == null) {
				setLastname();
				return lastname;
			}
			else {
				return lastname;
			}
		}
		
		//Set username
		public void setUsername(String new_username) {
			username = new_username;
		}
		
		//Set password
		public void setPassword(String new_password) {
			password = new_password;
		}
		
		//Get username
		public String getUsername() {
			return username;
		}
		
		//Get password
		public String getPassword() {
			return password;
		}
}
