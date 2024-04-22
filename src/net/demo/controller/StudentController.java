package net.demo.controller;

import java.util.List;

import net.demo.dao.StudentDAO;
import net.demo.model.Student;

public class StudentController {
	
	private StudentDAO studentDAO;
	
	public StudentController() {
		this.studentDAO = new StudentDAO();
	}

	public int insert(Student student) {			
		return this.studentDAO.insert(student);
	}

	public int update(Student student) {
		return this.studentDAO.update(student);
	}
	
	public int delete(int studentId) {
		return this.studentDAO.delete(studentId);
		
	}
	
	public Student get(int studentId) {
		return this.studentDAO.get(studentId);
	}
	
	public List<Student> get() {
		return this.studentDAO.get();
	}

}
