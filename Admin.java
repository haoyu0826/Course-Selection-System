package hw01;

import java.util.Scanner;

public class Admin extends User implements AdminPermission{
	//All Admins should not have the same username
	
	//Data field
	String firstname;
	String lastname;
	String username;
	String password;
	String id;
	
	//Default constructor
	public Admin() {
		
	}
	
	//Set Admin ID
	public void setAdminID() {
		id = "Admin";
		for(int i=0;i<2;i++) {
			id += Math.random() * 10;
		}
	}
	
	//Get student ID
	public String getAdminID() {
		return id;
	}
	
	//Constructor
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//Set the firstname
	@Override
	public void setFirstname() {
		System.out.println("Please enter Admin's firstname: ");
		Scanner input = new Scanner(System.in);
		firstname = input.next();
	}
	
	//Set the lastname
	@Override
	public void setLastname() {
		System.out.println("Please enter Admin's lastname: ");
		Scanner input = new Scanner(System.in);
		lastname = input.next();
	}
	
	//Get the firstname
	public 	String getFirstname() {
		return firstname;
	}
	
	//Get the firstname
	public 	String getLastname() {
		return lastname;
	}	
	
}
