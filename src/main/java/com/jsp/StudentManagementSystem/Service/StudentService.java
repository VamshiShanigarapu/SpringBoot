package com.jsp.StudentManagementSystem.Service;

import java.util.List;

import com.jsp.StudentManagementSystem.Entity.Student;

public interface StudentService {

  List<Student>getAllStudents();
  
  Student saveStudent(Student studnet);
  
  Student getStudentById(Long id);
  
  Student updatestudent(Student student);
  
  void deleteStudentById(Long id);
}
