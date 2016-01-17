package com.fujishiro.timetableManager;

import java.util.*;

import com.fujishiro.timetableManager.StudentList.Student;

public class LessonList {
	//Variables
	private static LinkedList LIST;
	
	//Methods
	
	public LinkedList getLessonList()
	{
		return LIST;
	}
	
	/*
	 * addLesson adds a lesson to the Lesson linked list
	 */
	public void addLesson(int studentid, String date, String time){
		LIST.add(new Lesson(studentid, date, time));
	}
	
	/*
	 * It deletes a lesson from the lesson linked list by date
	 */
	private void deleteByDate(String date) {
		int position;
		
		//find lesson by date
		position = find(date);
		
		//error check
		//If we cannot find lesson in the Linked List
		if (position < 0) {
			return;
		}
		
		// remove lesson node from Linked list
		LIST.remove(position);
	}
	
	/*
	 * It searches for a lesson by date
	 * Return: 
	 * 	- the position of the lesson in the Linked List if found
	 *  - otherwise, return -1
	 */
	private int find(String date) {
		Lesson lesson;
		
		for (int i = 0; i < LIST.size(); i++) {
			lesson = (Lesson) LIST.get(i);
			
			//compare student id
			if (date == lesson.DATE) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * It deletes a lessons from the Lessons linked list by id
	 */
	public void deleteAllLessons(int studentid) {
		int position;
		
		//while loop deletes all lessons with specific student id
		while(studentid > 0){
			//find lesson by student id
			//get returned position of 
			position = findAll(studentid);
		
			//error check
			//If we cannot find student id in the Linked List
			if (position < 0) {
				return;
			}
		
			// remove lesson node from Linked list
			LIST.remove(position);
		}
	

	}
	
	/*
	 * It searches for lessons by student id
	 * Return: 
	 * 	- the position of the lesson of the student in the Linked List if found
	 *  - otherwise, return -1
	 */
	private int findAll(int studentid) {
		Lesson lesson;
		
		for (int i = 0; i < LIST.size(); i++) {
			lesson = (Lesson) LIST.get(i);
			
			//compare student id
			//If student id entered equals to student id in node returns "i" position in lessons list
			while (studentid == lesson.STUDENTID) {
				return i;
			}
		}
		return -1;
	}	
	
	/*
	 * It prints the Lessons linked list
	 */
	public void printList() {
		System.out.println(LIST);	
	}
	
	/*
	 * It prints the Lessons linked list by student id
	 */
	public void printLessonOfStudent(int studentid) {
		int position;
		Lesson lesson;
		
		// find lessons by given date and print them
		for (int i = 0; i < LIST.size(); i++) {
			lesson = (Lesson) LIST.get(i);
			
			if (studentid == lesson.STUDENTID) {
				System.out.println(LIST.get(i) + ", ");
			}
		}
	}
	
	/*
	 * It prints the Lessons linked list by date of lesson
	 */
	public void printLessonByDate(String date) {
		int position;
		Lesson lesson;
		
		// find lessons by given date and print them
		for (int i = 0; i < LIST.size(); i++) {
			lesson = (Lesson) LIST.get(i);
			
			if (date == lesson.DATE) {
				System.out.print(LIST.get(i) + ", ");
			}
		}
	}
	
	//Constructor method 
	public LessonList(){
		LIST = new LinkedList();
		
		/*
		addLesson(1, "03012016", "1500");
		addLesson(1, "03012016", "1500");
		addLesson(2, "05012016", "1700");
		
		
		printList();
		
		System.out.println("Delete all lessons of studentid: 1");
		//deleteAllLessons(1);
		printList();
		
		System.out.println("Print lesson of:");
		printLessonByDate("03012016");
		
		//System.out.println("Delete all lessons of date: 03012016");
		//deleteByDate("03012016");
		//printList();
		*/
	}
	
	public class Lesson{
		private int STUDENTID;
		private String DATE;
		private String TIME;
		
		public Lesson(int studentid, String date, String time) {
			this.STUDENTID = studentid;
			this.DATE = date;
			this.TIME = time;
		}
		
		public String toString(){
			return "Lesson| " + "(SID: " + this.STUDENTID + ") " + 
					"(Date: " + this.DATE + ") " + "(Time: " + this.TIME + ")";
		}
	}
}
