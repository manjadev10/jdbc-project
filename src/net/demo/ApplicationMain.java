package net.demo;

import java.util.List;

import net.demo.controller.StudentController;
import net.demo.model.Student;

public class ApplicationMain {
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		insertMethod();
		//deleteMethod(1);
		//getByIdMethod(3);
		getAllMethod();
	}

	private static void insertMethod() {
		Student student = new Student(3,"Manja2","USA");
		StudentController controller = new StudentController();
		int numberOfRecordsAffected =  controller.insert(student);
		if(numberOfRecordsAffected >= 1) {
			System.out.println("Successfully Inserted the record");
		}
		else {
			System.out.println("Some error has been occurred while inserting");
		}
	}
	
	private static void updateMethod() {
		Student student = new Student(3,"Manja2","USA");
		StudentController controller = new StudentController();
		int numberOfRecordsAffected =  controller.update(student);
		if(numberOfRecordsAffected >= 1) {
			System.out.println("Successfully Inserted the record");
		}
		else {
			System.out.println("Some error has been occurred while inserting");
		}
	}
	
	private static void deleteMethod(int studentId) {
		StudentController controller = new StudentController();
		int numberOfRecordsAffected =  controller.delete(studentId);
		if(numberOfRecordsAffected >= 1) {
			System.out.println("Successfully Deleted the record");
		}
		else {
			System.out.println("No student found with matching id");
		}
	}
	
	private static void getByIdMethod(int studentId) {
		StudentController controller = new StudentController();
		Student student =  controller.get(studentId);
		if(student != null) {
			System.out.println("Successfully Fetched the record : " +student.toString());
		}
		else {
			System.out.println("No Student found with Id "+studentId);
		}
	}
	
	private static void getAllMethod() {
		StudentController controller = new StudentController();
		List<Student> students =  controller.get();
		if(students != null) {
			System.out.println("Successfully Fetched the record : "+students.toString());
		}
		else {
			System.out.println("Some error occurred while fetching");
		}
	}

}
