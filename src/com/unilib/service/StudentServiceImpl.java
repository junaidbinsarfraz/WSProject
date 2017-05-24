package com.unilib.service;

import com.unilib.dao.Student;
import com.unilib.dao.StudentHome;

public class StudentServiceImpl implements StudentService {
	
	private StudentHome studentHome = new StudentHome();
	
	@Override
	public boolean validateStudent(Student student) {
		
		if(student == null || student.getId() == null || student.getPin() == null) {
			return false;
		}
		
		try {
			Student newStudent = (Student) this.studentHome.findByExample(student).get(0);
			
			if(!(newStudent.getId().equals(student.getId()) || newStudent.getPin().equals(student.getPin()))) {
				return false;
			}
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}

}
