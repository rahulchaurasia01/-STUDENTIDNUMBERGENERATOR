package com.wipro.student.service;

import java.util.Calendar;

import com.wipro.student.basic.Student;
import com.wipro.student.exception.*;

public class StudentIDGenerator {

	public static boolean validateStudentDetails(Student studentObject) {
		
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		
		if(studentObject.getFirstName().length() > 20) {
			try {
				throw new StudentFirstNameMaxLimitException();
			}
			catch(StudentFirstNameMaxLimitException e) {
				System.out.println(e);
			}
			return false;
		}
		else if(studentObject.getLastName().length() > 25) {
			try {
				throw new StudentLastNameMaxLimitException();				
			}
			catch(StudentLastNameMaxLimitException e) {
				System.out.println(e);
			}
			return false;
		}
		else if(studentObject.getStandard() <= 0 && studentObject.getStandard() >= 11) {
			try {
				throw new StudentInvalidStandardException();
			}
			catch(StudentInvalidStandardException e) {
				System.out.println(e);
			}
			return false;
		}
		else if(!studentObject.getGender().equalsIgnoreCase("Male") && !studentObject.getGender().equalsIgnoreCase("Female")) {
			try {
				throw new StudentInvalidGenderException();
			}
			catch(StudentInvalidGenderException e) {
				System.out.println(e);
			}
			return false;
		}
		else if(year - studentObject.getYearOfBirth() < 3) {
			try {
				throw new StudentInvalidYearOfBirthException();
			}
			catch(StudentInvalidYearOfBirthException e) {
				System.out.println(e);
			}
			return false;
		}
		else
			return true;
					
	}
	
	public static String generateStudentID(Student student) {
		
		if(validateStudentDetails(student)) {
			
			StringBuilder studentId = new StringBuilder();
			
			String year = student.getYearOfBirth()+"";
			
			int randomNo = (int)(Math.random() * 9999) + 1000;
			
			String alternateRandomNo = randomNo+"";
			
			studentId.append(student.getFirstName().charAt(0));
			studentId.append(student.getFirstName().charAt(1));
			studentId.append(student.getLastName().charAt(0));
			studentId.append(student.getGender().charAt(0));
			studentId.append(year.charAt(year.length()-2));
			studentId.append(year.charAt(year.length()-1));
			studentId.append(alternateRandomNo.charAt(1));
			studentId.append(alternateRandomNo.charAt(2));
			
			return studentId.toString();
			
		}
		else
			return "Student ID Not Generated. Please Enter Proper Details";
		
	}
	
}
