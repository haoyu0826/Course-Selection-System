# Course-Selection-System

## About the program

### Introduction
The course selection system program written in Java constructs a user system to access university courses: students and Admins will be able to view and modify their information of course registeration. The program consists of 4 classes, 2 interfaces, as well as 3 csv files as examples to test the program.

### Note
The program should be completed with individualized course, student and Admin information data. Files provided in the repository are used as examples to test the program. IT SHOULD BE MODIFIED WHEN IT IS OFFICIALLY USED. To better test the program, you can use the following Admin/student information (they are also contained in the csv file):

**User type: Admin**
	Username: Admin01
	Password: Admin001

**User type: Student**
	Username: Student01
	Password: Student001

Menus are different for Admin and student signitures as shown below:

**Menu table type: Admin**

  1 Course Management
  
		1 Create a new course
		2 Delete a course
		3 Edit a course
		4 Display information for a given course
		5 Register a student
		6 Return
    
  2 Course Reports
  
    		1 View all courses
		2 View all courses that are FULL
		3 Write to a file the list of courses that are Full
		4 View the names of the students being registered in a specific course
		5 View the list of courses that a given student is being registered on
		6 Sort courses based on the current number of student registers
		7 Return

**Menu table type: student**

		1 View all courses
		2 View all courses that are not FULL
		3 Register on a course
		4 Withdraw from a course
		5 View all courses that the current student is being registered in
		6 Exit

## Files contained in repository

### Main program
1. [Here to run](https://github.com/haoyu0826/Course-Selection-System/blob/main/CourseSelection.java#L8)

### Classes
1. [Course class](https://github.com/haoyu0826/Course-Selection-System/blob/main/Course.java)
2. [User class](https://github.com/haoyu0826/Course-Selection-System/blob/main/User.java)
3. [Student class](https://github.com/haoyu0826/Course-Selection-System/blob/main/Student.java)
4. [Admin class](https://github.com/haoyu0826/Course-Selection-System/blob/main/Admin.java)
5. [Student interface](https://github.com/haoyu0826/Course-Selection-System/blob/main/AdminPermission.java)
6. [Admin interface](https://github.com/haoyu0826/Course-Selection-System/blob/main/AdminPermission.java)

### Files
1. [File contains course to be selected (it is just a sample to be tested)](https://github.com/haoyu0826/Course-Selection-System/blob/main/MyUniversityCourses.csv)
2. [File contains all students (it is just a sample to be tested)](https://github.com/haoyu0826/Course-Selection-System/blob/main/StudentINFOList.csv)
3. [File contains all Admins (it is just a sample to be tested)](https://github.com/haoyu0826/Course-Selection-System/blob/main/AdminINFOList.csv)
