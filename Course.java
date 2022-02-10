package hw01;

import java.util.ArrayList;
import java.io.Serializable;

public class Course implements Serializable{
	
	//Data field
	String course_name;
	String course_id;
	int max_stu;
	int current_stu;
	String course_instr;
	String course_section;
	String course_loc;
	ArrayList <Student> studentSelected = new ArrayList <Student>();
	
	//Default constructor
	public Course() {
		
	}
	
	//Constructor
	public Course(String name, String id, int maxnum, int currentnum, String instructor, String sectionnum, String location) {
		course_name = name;
		course_id = id;
		max_stu = maxnum;
		current_stu = currentnum;
		course_instr = instructor;
		course_section = sectionnum;
		course_loc = location;
	}
	
	//Method to change the number of maximum student
	public void EditMaximumStudent(int maxnum) {
		max_stu = maxnum;
	}
	
	// Method to change the number of current student should through register/drop
	
	//Method to change instructor
	public void EditInstructor(String instructor) {
		course_instr = instructor;
	}
	
	//Method to change section number
	public void EditSection(String sectionnum) {
		course_section = sectionnum;
	}
	
	//Method to change location
	public void EditLocation(String location) {
		course_loc = location;
	}
	
	//Method to register a student
	public void RegisterWith(Student student) {
		studentSelected.add(student);
		current_stu += 1;
		student.courseSelected.add(this);
	}
	
	public void Drop(Student student) {
		studentSelected.remove(student);
		current_stu -= 1;
	}
	
	//Print course information
	public void DisplayInfo() {
		System.out.println("Course Name: " + course_name );
		System.out.println("Course ID: " + course_id);
		System.out.println("Maximum Students: " + max_stu);
		System.out.println("Current Students: " + current_stu);
		System.out.print("List of student: ");
		for(Student i : studentSelected) {
			System.out.print(i.getFirstname() + "," + i.getLastname() + " ");
		}
		System.out.println();
		System.out.println("Course instructor: " + course_instr);
		System.out.println("Course section number: " + course_section);
		System.out.println("Course location: " + course_loc);
	}
	
	//Check if a course is full
	public boolean IsFull() {
		if(current_stu == max_stu) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void PrintStudentList() {
		for(Student i : studentSelected) {
			System.out.print(i.getFirstname() + "," + i.getLastname() + " ");
		}
	}
	
	@Override
	public String toString() {
		return "Course [Name=" + course_name + ", ID=" + course_id + ", Maximum Number of Student=" + max_stu + ", Current Number of Student=" + current_stu + ",Course Instructor=" + course_instr + ",Course Section Number=" + course_section + "Course Location=" + course_loc +"]";
	}
	

}
