package hw01;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class CourseSelection{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		File file = new File("AllCourseList");
		//Create an ArrayList of course objects
		ArrayList <Course> courseList = new ArrayList <Course>();
		
		if(file.exists()) {
			try{
	            FileInputStream fis = new FileInputStream("AllCourseList");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            courseList = (ArrayList) ois.readObject();
	 
	            ois.close();
	            fis.close();
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	            return;
	        } 
		}
		
		else {
			// Read from the file
			BufferedReader my_university_courses = new BufferedReader(new FileReader("MyUniversityCourses.csv"));
			
			// Skip the first line of information
			my_university_courses.readLine();
			
			// Read from the second line
			String line = "";
			while((line = my_university_courses.readLine()) != null) {
				// Convert string to list
				String[] thisLine = line.split(",");
				// Convert string to integer
				int num_maxStu = Integer.parseInt(thisLine[2]);
				// Convert string to integer
				int num_currentStu = Integer.parseInt(thisLine[3]);
				Course course = new Course(thisLine[0],thisLine[1],num_maxStu,num_currentStu,thisLine[5],thisLine[6],thisLine[7]);
				courseList.add(course);
			}
			
			//Close the file
			my_university_courses.close();
		}
		
		//adminList
		
		//Create an ArrayList of admin object
		File file3 = new File("AllAdminList");
		//Create an ArrayList of admin objects
		ArrayList <Admin> adminList = new ArrayList <Admin>();
		if(file3.exists()) {
			try{
	            FileInputStream fis = new FileInputStream("AllAdminList");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            adminList = (ArrayList) ois.readObject();
	 
	            ois.close();
	            fis.close();
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	            return;
	        } 
		}
		else {
			// Read from the file
			BufferedReader AdminINFOList = new BufferedReader(new FileReader("AdminINFOList.csv"));
			
			// Skip the first line of information
			AdminINFOList.readLine();
			
			// Read from the second line
			String line = "";
			while((line = AdminINFOList.readLine()) != null) {
				// Convert string to list
				String[] thisLine = line.split(",");
				Admin admin = new Admin(thisLine[0], thisLine[1]);
				admin.firstname = thisLine[2];
				admin.lastname = thisLine[3];
				admin.id = thisLine[4];
				adminList.add(admin);
			}
			
			//Close the file
			AdminINFOList.close();
		}
		
		//allstudentINFO
		
		//Create an ArrayList of student object
		File file4 = new File("AllStudentINFOList");
		//Create an ArrayList of student objects
		ArrayList <Student> allstudentINFO = new ArrayList <Student>();
		if(file4.exists()) {
			try{
	            FileInputStream fis = new FileInputStream("AllStudentINFOList");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            allstudentINFO = (ArrayList) ois.readObject();
	 
	            ois.close();
	            fis.close();
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	            return;
	        } 
		}
		else {
			// Read from the file
			BufferedReader studentINFOList = new BufferedReader(new FileReader("StudentINFOList.csv"));
			
			// Skip the first line of information
			studentINFOList.readLine();
			
			// Read from the second line
			String line = "";
			while((line = studentINFOList.readLine()) != null) {
				// Convert string to list
				String[] thisLine = line.split(",");
				Student student = new Student(thisLine[0], thisLine[1]);
				student.firstname = thisLine[2];
				student.lastname = thisLine[3];
				student.id = thisLine[4];
				allstudentINFO.add(student);
			}
			
			//Close the file
			studentINFOList.close();
		}
						

		
		
		//Ask if the user is a student or Admin
		Scanner input = new Scanner(System.in);
		System.out.println("----------Welcome----------");
		System.out.println();
		System.out.println("Please select:");
		System.out.println();
		System.out.println("1 Admin LOGIN");
		System.out.println("2 Student LOGIN");
		int answer = input.nextInt();
		
		
		//Admin login
		if(answer == 1) {
			int count = 0;		
			while(count == 0) {
				System.out.println("Please enter your username");
				String username = input.next();
				System.out.println("Please enter your password");
				String password = input.next();
				for (int k=0; k<adminList.size();k++) {
					if (adminList.get(k).username.equals(username) && adminList.get(k).password.equals(password)) {
						count += 1;
						System.out.println("----------Welcome Admin " + adminList.get(k).firstname+ "----------");
						//Menu ask to manage or report course
						System.out.println();
						System.out.println("1 Course Management");
						System.out.println("2 Course Reports");
						System.out.println("3 Exit");
						
						//Test if should be back to ask manage or report
						int flag2 = 1;
						
						while(flag2 == 1) {
							int tmp = input.nextInt();
							
							//1 Course Management
							if(tmp == 1) {
								//Management menu
								manageINFO();
								
								//Test if should be back to management menu
								int flag3 = 1;
								
								while(flag3 == 1) {
									tmp = input.nextInt();
									
									//1 Create a new course
									if(tmp == 1) {
										//Ask course info
										System.out.println("Course Name: ");
										//Split the string with "," but not " "
										String courseName = input.next().replace(',', ' ');
										System.out.println("Course ID: ");
										String courseID = input.next();
										System.out.println("Maximum Student Number: ");
										int maxStu = input.nextInt();
										System.out.println("Current Student Number: ");
										int currentStu = input.nextInt();
										System.out.println("Course Instructor: ");
										//Split the string with "," but not " "
										String courseInstructor = input.next().replace(',', ' ');
										System.out.println("Course Section Number: ");
										String courseSection = input.next();
										System.out.println("Course Location: ");
										//Split the string with "," but not " "
										String courseLoc = input.next().replace(',', ' ');
										
										//Add to courseList
										Course a = new Course(courseName, courseID, maxStu, currentStu, courseInstructor, courseSection, courseLoc);
										courseList.add(a);
										
										if(a.current_stu > 0) {
											for(int n=0;n<a.current_stu;n++) {
												//Ask student information
												System.out.println("Enrolled student id: ");
												String student_id = input.next();
												
												for(int m=0;m<allstudentINFO.size();m++) {
													if(allstudentINFO.get(m).id.equals(student_id)) {
														a.studentSelected.add(allstudentINFO.get(m));
														allstudentINFO.get(m).courseSelected.add(a);
													}
												}
											}
										}
										
										System.out.println("Done");
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											manageINFO();
											continue;
										}
										else {
											break;
										}
				
									}
									
									//2 Delete a course
									if(tmp == 2) {
										System.out.println("Course ID: ");
										String courseID = input.next();
										System.out.println("Course Section Number: ");
										String courseSection = input.next();
										for(Course i : courseList) {
											if((i.course_id).equals(courseID) && (i.course_section).equals(courseSection)) {
												courseList.remove(i);
											}
										}
										System.out.println("Done");
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											manageINFO();
											continue;
										}
										else {
											break;
										}
									}
									
									//3 Edit a course
									if(tmp == 3) {
										//Display menu
										System.out.println("Choose what to edit");
										System.out.println("1 Maximum student number");
										System.out.println("2 Course instructor");
										System.out.println("3 Course section number");
										System.out.println("4 Course location");
										
										tmp = input.nextInt();
										System.out.println("Course ID: ");
										String courseID = input.next();
										System.out.println("Course Section Number: ");
										String courseSection = input.next();
										
										//Edit maximum student number
										if(tmp == 1) {
											System.out.println("New maximum student number: ");
											int maximumStu = input.nextInt();
											for(Course i :courseList) {
												if((i.course_id).equals(courseID) && (i.course_section).equals(courseSection)) {
													i.EditMaximumStudent(maximumStu);
												}
											}
											System.out.println("Done");
											
											System.out.println("1 Return");
											tmp = input.nextInt();
											if(tmp == 1) {
												manageINFO();
												continue;
											}
											else {
												break;
											}
										}
										
										//Edit course instructor
										if(tmp == 2) {
											System.out.println("New Course instructor: ");
											//Split the string with "," but not " "
											String courseInstructor = input.next().replace(',', ' ');
											for(Course i :courseList) {
												if((i.course_id).equals(courseID) && (i.course_section).equals(courseSection)) {
													i.EditInstructor(courseInstructor);
												}
											}
											System.out.println("Done");
											
											System.out.println("1 Return");
											tmp = input.nextInt();
											if(tmp == 1) {
												manageINFO();
												continue;
											}
											else {
												break;
											}
										}
										
										//Edit course section number
										if(tmp == 3) {
											System.out.println("New Course section number: ");
											String courseSectionNum = input.next();
											for(Course i :courseList) {
												if((i.course_id).equals(courseID) && (i.course_section).equals(courseSection)) {
													i.EditSection(courseSectionNum);
												}
											}
											System.out.println("Done");
											
											System.out.println("1 Return");
											tmp = input.nextInt();
											if(tmp == 1) {
												manageINFO();
												continue;
											}
											else {
												break;
											}
										}
										
										//Edit course location
										if(tmp == 4) {
											System.out.println("New Course location: ");
											//Split the string with "," but not " "
											String courseLocation = input.next().replace(',', ' ');
											for(Course i :courseList) {
												if((i.course_id).equals(courseID) && (i.course_section).equals(courseSection)) {
													i.EditLocation(courseLocation);
												}
											}
											System.out.println("Done");
											
											System.out.println("1 Return");
											tmp = input.nextInt();
											if(tmp == 1) {
												manageINFO();
												continue;
											}
											else {
												break;
											}
										}
										
									}
									
									//4 Display information for a given course
									if(tmp == 4) {
										System.out.println("Course ID: ");
										String courseID = input.next();
										for(Course i : courseList) {
											if((i.course_id).equals(courseID)) {
												i.DisplayInfo();
												System.out.println();
											}
										}
										System.out.println("Done");
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											manageINFO();
											continue;
										}
										else {
											break;
										}
									}
									
									//5 Register a student
									if(tmp == 5) {
										//Ask course information
										System.out.println("Course ID: ");
										String courseID = input.next();
										System.out.println("Course Section Number: ");
										String courseSection = input.next();
										
										//Ask student information
										System.out.println("Student ID: ");
										String student_id = input.next();
										
										
										//Check if student is in studentEnrolled
										int temp = 0;
										for(Student s : allstudentINFO) {		
											//If it is in
											if(s.id.equals(student_id)) {
												for(Course i :courseList) {
													if((i.course_id).equals(courseID) && (i.course_section).equals(courseSection)) {
														i.RegisterWith(s);
														temp = 1;
													}
												}
											}
										}
																			
										
										System.out.println("Done");
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											manageINFO();
											continue;
										}
										else {
											break;
										}
									}
									
									//6 Exit
									if(tmp == 6) {
										flag3 = 0;
										flag2 = 1;
										System.out.println("1 Course Management");
										System.out.println("2 Course Reports");
										System.out.println("3 Exit");
									}
									
									//Wrong typing
									else {
										System.out.println("Invalid Command");
										System.out.println("Please enter again!");
										continue;
									}
								}
							}
							
							//2 Course reports menu
							if(tmp == 2) {
								reportINFO();
								
								//Test if should be back to course reports menu
								int flag4 = 1;
								
								while(flag4 == 1) {
									tmp = input.nextInt();
									
									//1 View all courses
									if(tmp == 1) {
										
										for(Course i : courseList) {
											System.out.println("Course Name: " + i.course_name);
											System.out.println("Course ID " + i.course_id);
											System.out.println("Maximum number of students allowed to be registered: " + i.max_stu);
											System.out.println("Number of students registered: " + i.current_stu);
											System.out.println();
										}
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											reportINFO();
											continue;
										}
										else {
											break;
										}
									}
									
									//2 View all courses that are FULL
									if(tmp == 2) {
										for(Course i : courseList) {
											if(i.IsFull() == true) {
												System.out.println("Course Name: " + i.course_name);
												System.out.println("Course ID: " + i.course_id);
												System.out.println("Maximum number of students allowed to be registered: " + i.max_stu);
												System.out.println("Number of students registered: " + i.current_stu);
												System.out.println();
											}
										}
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											reportINFO();
											continue;
										}
										else {
											break;
										}
									}
									
									//3 Write to a file the list of courses that are Full
									if(tmp == 3) {
										//Create a new ArrayList and add full courses
										ArrayList <Course> fullList = new ArrayList <Course>();
										for(Course i : courseList) {
											if(i.IsFull() == true) {
											fullList.add(i);
											}
										}
										//Serialization
										try {	
											FileOutputStream fos = new FileOutputStream("FullCourse");
									        ObjectOutputStream oos = new ObjectOutputStream(fos);
									        oos.writeObject(fullList);
									        oos.close();
									        fos.close();
									        System.out.println("Done");
										} 
										catch (IOException ioe){
											ioe.printStackTrace();
										}
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											reportINFO();
											continue;
										}
										else {
											break;
										}
									}
									
									//4 View the names of the students being registered in a specific course
									if(tmp == 4) {
										System.out.println("Course ID: ");
										String courseID = input.next();
										System.out.println("Course Section Number: ");
										String courseSection = input.next();
										
										for(Course i : courseList) {
											if((i.course_id).equals(courseID) && (i.course_section).equals(courseSection)) {
												i.PrintStudentList();
											}
										}
										System.out.println();
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											reportINFO();
											continue;
										}
										else {
											break;
										}
									}
									
									//5 View the list of courses that a given student is being registered on
									if(tmp == 5) {
										//Ask student information
										System.out.println("Student ID: ");
										String id = input.next();
										
										//Check if student is in studentEnrolled
										int temp = 0;
										for(Student s : allstudentINFO) {		
											//If it is in
											if(s.id.equals(id)) {
												s.ViewRegisteredCourses();
												temp = 1;
											}
										}
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											reportINFO();
											continue;
										}
										else {
											break;
										}
									}
									
									//6 Sort courses based on the current number of student registers
									if(tmp == 6) {
										courseList.sort(new Comparator <Course>() {
											@Override
											public int compare(Course c1,Course c2) {
												int i = c1.current_stu > c2.current_stu ? -1 : 1;
												return i;
											}
										});
										
										for (Course c : courseList){
							            c.DisplayInfo();
							            System.out.println();
										}
										
										System.out.println("1 Return");
										tmp = input.nextInt();
										if(tmp == 1) {
											reportINFO();
											continue;
										}
										else {
											break;
										}
									}
									
									//7 Back
									if(tmp == 7) {
										flag4 = 0;
										flag2 = 1;
										System.out.println("1 Course Management");
										System.out.println("2 Course Reports");
										System.out.println("3 Exit");
									}
									
									//Wrong typing
									else {
										System.out.println("Invalid Command");
										System.out.println("Please enter again!");
										continue;
									}
								}
							}
							
							if(tmp == 3) {
								System.out.println("----------Thank you----------");
								break;
							}
						}
						
						
					}
				}
				
				//If the username and password are not found
				//It allows a second chance
				if(count == 0) {
					System.out.println();
					System.out.println("----------User is not found----------");
					System.out.println("----------Please try again----------");
					System.out.println();
					count = 0;
				}
			}
		}
		
		
		
		//Student login
		if(answer == 2) {			
			int count = 0;
			while(count == 0) {
				System.out.println("Please enter your username");
				String username = input.next();
				System.out.println("Please enter your password");
				String password = input.next();
				for(int k=0; k<allstudentINFO.size();k++) {
					//If the user is a student
					if(allstudentINFO.get(k).username.equals(username) && allstudentINFO.get(k).password.equals(password)) {
						count += 1;
						System.out.println("----------Welcome " + allstudentINFO.get(k).firstname + "!----------");
						
						//Course management menu
						studentINFO();
						
						//Test if should be back to management menu
						int flag5 = 1;
						
						while(flag5 == 1) {
							int tmp = input.nextInt();
							
							//1 View all courses
							if(tmp == 1) {
								for(Course i : courseList) {
									System.out.println("Course Name: " + i.course_name);
									System.out.println("Course ID " + i.course_id);
									System.out.println("Maximum number of students allowed to be registered: " + i.max_stu);
									System.out.println("Number of students registered: " + i.current_stu);
									System.out.println();
								}
								
								System.out.println("1 Return");
								tmp = input.nextInt();
								if(tmp == 1) {
									studentINFO();
									continue;
								}
								else {
									break;
								}
							}
							
							//2 View all courses that are not FULL
							if(tmp == 2) {
								for(Course i : courseList) {
									if(i.IsFull() == false) {
										System.out.println("Course Name: " + i.course_name);
										System.out.println("Course ID " + i.course_id);
										System.out.println("Maximum number of students allowed to be registered: " + i.max_stu);
										System.out.println("Number of students registered: " + i.current_stu);
										System.out.println();
									}
								}
								
								System.out.println("1 Return");
								tmp = input.nextInt();
								if(tmp == 1) {
									studentINFO();
									continue;
								}
								else {
									break;
								}
							}
							
							//3 Register on a course
							if(tmp == 3) {
								System.out.println("Course ID: ");
								String courseID = input.next();
								System.out.println("Course Section Number: ");
								String courseSection = input.next();
								
								for(Course i : courseList) {
									if((i.course_id).equals(courseID) && (i.course_section).equals(courseSection)) {
										i.RegisterWith(allstudentINFO.get(k));
									}
								}
								System.out.println("Done");
								
								System.out.println("1 Return");
								tmp = input.nextInt();
								if(tmp == 1) {
									studentINFO();
									continue;
								}
								else {
									break;
								}
							}
							
							//4 Withdraw from a course
							if(tmp == 4) {
								System.out.println("Course ID: ");
								String courseID = input.next();
								System.out.println("Course Section Number: ");
								String courseSection = input.next();
								
								for(Course i : courseList) {
									if((i.course_id).equals(courseID) && (i.course_section).equals(courseSection)) {
										i.Drop(allstudentINFO.get(k));
									}
								}
								System.out.println("Done");
								
								System.out.println("1 Return");
								tmp = input.nextInt();
								if(tmp == 1) {
									studentINFO();
									continue;
								}
								else {
									break;
								}
							}
							
							//5 View all courses that the current student is being registered in
							if(tmp == 5) {
								allstudentINFO.get(k).ViewRegisteredCourses();
								
								System.out.println("1 Return");
								tmp = input.nextInt();
								if(tmp == 1) {
									studentINFO();
									continue;
								}
								else {
									break;
								}
							}
							
							//6 Exit
							if(tmp == 6) {
								System.out.println("----------Thank you----------");
								break;
							}
							
							//Wrong typing
							else {
								System.out.println("Invalid Command");
								System.out.println("Please enter again!");
								continue;
							}
						}					
					}
				}
				
				//If the username and password are not found
				//It allows a second chance
				if(count == 0) {
					System.out.println();
					System.out.println("----------User is not found----------");
					System.out.println("----------Please try again----------");
					System.out.println();
					count = 0;
				}								
			}
		}		
				
		

		/*Course ArrayList*/
		//Serialization
		try	{	
			FileOutputStream fos = new FileOutputStream("AllCourseList");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(courseList);
            oos.close();
            fos.close();
        }
		
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
		
		/*Admin ArrayList*/
		//Serialization
		try	{	
			FileOutputStream fos = new FileOutputStream("AllAdminList");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(adminList);
            oos.close();
            fos.close();
        }
		
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
		
		/*Student ArrayList*/
		//Serialization
		try	{	
			FileOutputStream fos = new FileOutputStream("AllStudentINFOList");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(allstudentINFO);
            oos.close();
            fos.close();
        }
		
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
	}
	
	public static void manageINFO() {
		System.out.println("Management");
		System.out.println("1 Create a new course");
		System.out.println("2 Delete a course");
		System.out.println("3 Edit a course");
		System.out.println("4 Display information for a given course");
		System.out.println("5 Register a student");
		System.out.println("6 Return");
	}
	
	public static void reportINFO() {
		System.out.println("Reports");
		System.out.println("1 View all courses");
		System.out.println("2 View all courses that are FULL");
		System.out.println("3 Write to a file the list of courses that are Full");
		System.out.println("4 View the names of the students being registered in a specific course");
		System.out.println("5 View the list of courses that a given student is being registered on");
		System.out.println("6 Sort courses based on the current number of student registers");
		System.out.println("7 Return");
	}
	
	public static void studentINFO() {
		System.out.println("Course Management");
		System.out.println("1 View all courses");
		System.out.println("2 View all courses that are not FULL");
		System.out.println("3 Register on a course");
		System.out.println("4 Withdraw from a course");
		System.out.println("5 View all courses that the current student is being registered in");
		System.out.println("6 Exit");
	}
}

