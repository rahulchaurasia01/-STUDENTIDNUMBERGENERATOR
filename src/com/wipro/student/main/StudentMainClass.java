package com.wipro.student.main;

import java.util.Scanner;

import com.wipro.student.basic.Student;
import com.wipro.student.service.StudentIDGenerator;

public class StudentMainClass {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Student student = new Student();
		
		System.out.println("-----Student Id Number Generator-----");
		System.out.println();
		System.out.print("Enter Your First Name:- ");
		student.setFirstName(scanner.nextLine());
		System.out.print("Enter Your Last Name:- ");
		student.setLastName(scanner.nextLine());
		System.out.print("Enter Your Standard:- ");
		student.setStandard(scanner.nextInt());
		System.out.print("Enter Your Gender:- ");
		student.setGender(scanner.next());
		System.out.print("Enter Your Year Of Birth:- ");
		student.setYearOfBirth(scanner.nextInt());
		
		
		String studentId = StudentIDGenerator.generateStudentID(student);
		
		System.out.println("Student ID Generated Is :: "+ studentId.toUpperCase());
		
		scanner.close();
	}

}
