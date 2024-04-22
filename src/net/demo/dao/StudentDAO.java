package net.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.demo.helper.Helper;
import net.demo.model.Student;

public class StudentDAO {
	
	public int insert(Student student) {
		
		int numberOfRecordsAffected = 0;
		String sql = "INSERT INTO students VALUES(?,?,?)";
		try {
			PreparedStatement ps = Helper.getPreparedStatement(sql);
			ps.setInt(1, student.getId());
			ps.setString(2,student.getName());
			ps.setString(3,student.getCity());
			
			numberOfRecordsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			Helper.closePreparedStatement();
		}
		
		return numberOfRecordsAffected;
	}
	
	public int update(Student student) {
		
		int numberOfRecordsAffected = 0;
		String sql = "UPDATE students SET city = ? WHERE id = ?";
		try {
			PreparedStatement ps = Helper.getPreparedStatement(sql);
			ps.setString(1,student.getCity());
			ps.setInt(2, student.getId());
			
			numberOfRecordsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			Helper.closePreparedStatement();
		}
		
		return numberOfRecordsAffected;
	}
	
	public int delete(int studentId) {
		
		int numberOfRecordsAffected = 0;
		String sql = "DELETE FROM students WHERE id = ?";
		try {
			PreparedStatement ps = Helper.getPreparedStatement(sql);
			ps.setInt(1,studentId);
			
			numberOfRecordsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			Helper.closePreparedStatement();
		}
		
		return numberOfRecordsAffected;
	}
	
	public Student get(int studentId) {
		
		String sql = "SELECT * FROM students WHERE id = ?";
		Student student = new Student();
		try {
			PreparedStatement ps = Helper.getPreparedStatement(sql);
			ps.setInt(1,studentId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return student.getName() != null ? student:null;
	}
	
	public List<Student> get() {
		
		String sql = "SELECT * FROM students";
		List<Student> students = new ArrayList<>();
		Student student = new Student();
		try {
			PreparedStatement ps = Helper.getPreparedStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				students.add(student);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

}
