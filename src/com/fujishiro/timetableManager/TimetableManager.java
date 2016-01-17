package com.fujishiro.timetableManager;

public class TimetableManager {
	private LessonList LESSONS;
	private StudentList STUDENTS;
	
	public TimetableManager(){
		STUDENTS = new StudentList();
		LESSONS = new LessonList();
		
		runTest();
	}
	
	private void runTest() {
		
		
		// Test Lesson
		LESSONS.addLesson(1, "03012016", "1500");
		LESSONS.addLesson(1, "03012016", "1500");
		LESSONS.addLesson(2, "05012016", "1700");
		
		LESSONS.printList();
		
		System.out.println("Delete all lessons of studentid: 1");
		//deleteAllLessons(1);
		LESSONS.printList();
		
		System.out.println("Print lesson of:");
		LESSONS.printLessonByDate("03012016");
		
		//System.out.println("Delete all lessons of date: 03012016");
		//deleteByDate("03012016");
		//printList();
		
		
		
		
		// Test Student class
		STUDENTS.add(1, "Yu", "Thailand", "Male", "18/04/1998");
		STUDENTS.add(2, "Emma", "England", "Female", "12/05/1992");
		STUDENTS.add(3, "Ken", "Thailand", "Male", "11/07/1980");
		STUDENTS.add(4, "Gunn", "Thailand", "Male", "10/09/1985");
		STUDENTS.add(5, "Sally", "America", "Female", "20/10/2000");
		STUDENTS.printList();
		
		System.out.println("Deleting 3");
		STUDENTS.delete(1);
		STUDENTS.printList();
		
		System.out.println("Updating id:2 address to Cambodia");
		STUDENTS.updateAddress(2, "Cambodia");
		
		STUDENTS.printList();
		
		// Test remove Student, should remove Lesson belong to that student as well
		
	}
	
	public static void main(String[] args) {
		TimetableManager TMgr = new TimetableManager();
	}
}
