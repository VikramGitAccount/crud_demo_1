package com.cruddemo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cruddemo.entity.Student;
import com.cruddemo.repository.StudentRepository;

@SpringBootTest
class CrudDemo1ApplicationTests {
	
	@Autowired
	private StudentRepository studentRepo;

	@Test
	void saveOneStudentInfo() {
		Student s = new Student();
	    s.setName("vishal");
	    s.setCourse("upsc");
	    s.setFee(90000);
	    studentRepo.save(s);
	    
	}
	@Test
    void deleteOneStudent(){
		studentRepo.deleteById(9L);
	}
	@Test
	void updateOneStudentInfo() {
		Student s = new Student();
		s.setId(6);
	    s.setName("pradeep");
	    s.setCourse("programmer");
	    s.setFee(3000);
	    studentRepo.save(s);
	}
	@Test
	void getOneStudentById() {
		Optional<Student> findById = studentRepo.findById(6L);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
	}
	
}

