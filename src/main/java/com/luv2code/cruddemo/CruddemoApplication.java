package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			//createStudent(studentDAO);
			//createMultipelStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id " + studentId);
		Student mystudent = studentDAO.findById(studentId);

		System.out.println("Updating student...  ");
		mystudent.setFirstName("Luva");
		studentDAO.update(mystudent);

		System.out.println("Updated student with id " + mystudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findBylastName("Duck");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student student : students) {
			System.out.println(student);

		}
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object...");
		Student tempstudent5 = new Student("DAffy", "duck", " flksjdkdlfjds");

		System.out.println("Saving student object...");
		studentDAO.save(tempstudent5);

		int theid =  tempstudent5.getId();
		System.out.println("Saved student with id: " + theid);

		System.out.println("Retrieving student with id: " + theid);
		Student myStudent = studentDAO.findById(theid);

		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipelStudents(StudentDAO studentDAO) {
		System.out.println("Creating new student object... ");
		Student tempstudent3 = new Student("john", "dfoe", "luv2cofsdfadde");
		Student tempstudent1 = new Student("mark", "dode", "lufdsv2cofadde");
		Student tempstudent2= new Student("kate", "does", "luvfsd2cofadde");

		System.out.println("Saving student object... ");
		studentDAO.save(tempstudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object... ");
		Student tempstudent = new Student("PAUL", "skjdf", "luv2code");


		System.out.println("Saving the student... ");
		studentDAO.save(tempstudent);

		System.out.println("Saved student.Genereted id: " +  tempstudent.getId());

	}
}