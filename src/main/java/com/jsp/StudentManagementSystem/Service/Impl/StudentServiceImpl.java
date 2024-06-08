package com.jsp.StudentManagementSystem.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.StudentManagementSystem.Entity.Student;
import com.jsp.StudentManagementSystem.Repository.StudentRepository;
import com.jsp.StudentManagementSystem.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepo;
	
	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}
	

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		
		return studentRepo.findById(id).get();
	}


	@Override
	public Student updatestudent(Student student) {
		
		return studentRepo.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		
	    studentRepo.deleteById(id);
	}

}
