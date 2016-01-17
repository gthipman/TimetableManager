package com.fujishiro.timetableManager;

import java.util.*;


import com.fujishiro.timetableManager.LessonList.Lesson;

public class StudentList {
	//Variables
	private LinkedList LIST;

	
	//Methods
	
	/*
	 * It adds a student to the Student linked list
	 */
	public void add(int id, String name, String address, String gender, String dob){
		LIST.add(new Student(id, name, address, gender, dob));
	}
	
	/*
	 * It deletes a student from the Student linked list by id
	 */
	public void delete(int id) {
		int position;
		
		//find student by id
		position = find(id);
		
		//error check
		//If we cannot find student id in the Linked List
		if (position < 0) {
			return;
		}
		
		// remove student node from Linked list
		LIST.remove(position);
		
		//TODO: clean up lesson belong to this student
	}
	
	/*
	 * It edits a student address information 
	 * parameter: student id, address
	 * return: none
	 */
	public void updateAddress(int id, String address) {
		Student student;
		
		for (int i = 0; i < LIST.size(); i++) {
			student = (Student) LIST.get(i);
			
			//update address
			if (id == student.ID) {
				student.ADDRESS = address;
				break;
			}
		}
		return;
	}
	
	
	/*
	 * It searches for a student by student id
	 * Return: 
	 * 	- the position of the student in the Linked List if found
	 *  - otherwise, return -1
	 */
	private int find(int id) {
		Student student;
		
		for (int i = 0; i < LIST.size(); i++) {
			student = (Student) LIST.get(i);
			
			//compare student id
			if (id == student.ID) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * It prints the Student linked list
	 */
	public void printList() {
		System.out.println(LIST);	
	}
	
	//Constructor method 
	public StudentList(){
		LIST = new LinkedList();
		
		/*
		add(1, "Yu", "Thailand", "Male", "18/04/1998");
		add(2, "Emma", "England", "Female", "12/05/1992");
		add(3, "Ken", "Thailand", "Male", "11/07/1980");
		add(4, "Gunn", "Thailand", "Male", "10/09/1985");
		add(5, "Sally", "America", "Female", "20/10/2000");
		printList();
		
		System.out.println("Deleting 3");
		delete(1);
		printList();
		
		System.out.println("Updating id:2 address to Cambodia");
		updateAddress(2, "Cambodia");
		
		printList();
		*/
	}
	
	/*
	 * Student class to store student information
	 */
	public class Student{
		private int ID;
		private String NAME;
		private String ADDRESS;
		private String GENDER;
		private String DOB;
		
		// Constructor
		public Student(int id, String name, String address, String gender, String dob) {
			this.ID = id;
			this.NAME = name;
			this.ADDRESS = address;
			this.GENDER = gender;
			this.DOB = dob;
		}
		
		public String toString(){
			return "Student| " + "(SID: " + this.ID + ") " + "(Name: " + this.NAME + ") " + 
					"(Address: " + this.ADDRESS + ") " + "(Gender: " + this.GENDER + ") " + 
					"(DOB: " + this.DOB + ")";
		}
	}
}
