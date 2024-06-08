package com.jsp.StudentManagementSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jsp.StudentManagementSystem.Entity.Student;
import com.jsp.StudentManagementSystem.Service.StudentService;



@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/Students")
	public String ListStudents(Model model) {
		model.addAttribute("Students",studentService.getAllStudents());
		return "Students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{td}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit student";
		
	}
	
	@PostMapping("/student/{id}")
	public String updateStudent(Long id,
		
		@ModelAttribute("student") Student student,Model model){
		//get student from database by id
	Student existingStudent=studentService.getStudentById(id);
	existingStudent.setFname(student.getFname());
	existingStudent.setLname(student.getLname());
	existingStudent.setEmail(student.getEmail());
	
	studentService.updatestudent(existingStudent);
		return "redirect:/students";
	}	
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
	}
	
}

