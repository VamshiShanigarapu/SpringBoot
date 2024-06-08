package com.jsp.StudentManagementSystem;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jsp.StudentManagementSystem.Entity.Student;
import com.jsp.StudentManagementSystem.Repository.StudentRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.solution.controller,"
		+ "com.solution.Students.Service")
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		//openHomePage();
	}

//	private static void openHomePage() throws IOException{
//		Runtime rt=Runtime.getRuntime();
//		rt.exec("rund1132 url.d11,FileProtocolHandler"+"http://localhost:8080/students");
//	}

	@Autowired
	private StudentRepository studentRepo;
	@Override
	public void run(String... args) throws Exception {
		Student student1=new Student("vamshi","shanigarapu","v@gmail.com");
		studentRepo.save(student1);
		Student student2=new Student("pavan","shanigarapu","p@gmail.com");
		studentRepo.save(student2);
	}

}
