package hw01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Student extends User implements StudentPermission{
	//All students should not have the same username

	//Data field
	String firstname;
	String lastname;
	String username;
	String password;
	ArrayList <Course> courseSelected = new ArrayList <Course>();
	String id;
	String gender;
	String address;
	double gpa;
	
	//Default constructor
	public Student(){
		
	}
	
	//Constructor
	public Student(String user_name, String pass_word) {
		username = user_name;
		password = pass_word;
	}
	
	//Set student ID
	public void setStudentID() {
		id = "Student";
		for(int i=0;i<2;i++) {
			id += Math.random() * 10;
		}
	}
	
	//Get student ID
	public String getStudentID() {
		return id;
	}
	
	//Set the firstname
	@Override
	public void setFirstname() {
		System.out.println("Please enter student's firstname: ");
		Scanner input = new Scanner(System.in);
		firstname = input.next();
	}
	
	//Set the lastname
	@Override
	public void setLastname() {
		System.out.println("Please enter student's lastname: ");
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
	
	
	//Set GPA
	public void setGPA(double num) {
		gpa = num;
	}
	
	//Get GPA
	public double getGPA() {
		return gpa;
	}
	
	//Register in a course
	public void RegisterIn(Course course) {
		courseSelected.add(course);
		course.current_stu += 1;
		course.studentSelected.add(this);
	}
	
	//Withdraw from a course
	public void WithdrawFrom(Course course) {
		courseSelected.remove(course);
		course.current_stu -= 1;
		course.studentSelected.remove(this);
	}
	
	//View all courses that the current student is being registered in
	public void ViewRegisteredCourses() {
		for(Course i : courseSelected) {
			System.out.print(i.course_name + " ");
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Student [Username=" + username + ", Password" + password + ", Firstname" + this.getFirstname() + ", Lastname" + this.getLastname() + "]";
	}
	
}
