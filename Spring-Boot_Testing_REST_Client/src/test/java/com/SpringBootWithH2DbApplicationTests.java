package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.entity.Student;

@SpringBootTest
class SpringBootWithH2DbApplicationTests {

	@Test
	public void test_getStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student _student = restTemplate.getForObject("http://localhost:8585/student/getPassByEmail/ssm@gmail.com", Student.class);
		assertNotNull(_student);
		assertEquals("SSM", _student.getName());
	}
	
	@Test
	public void test_addStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student _student = new Student();
		_student.setEmail("rahul@gmail.com");
		_student.setName("Rahul");
		_student.setPassword("rahul@123");
		_student.setRollNo(45);
		
		Student _newStudent = restTemplate.postForObject("http://localhost:8585/student/store", _student, Student.class);
		
		assertNotNull(_newStudent);
		assertNotNull(_newStudent.getEmail());
		assertEquals("Rahul", _newStudent.getName());
	}
	
	@Test
	public void test_updateStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject("http://localhost:8585/student/getPassByEmail/ssm@gmail.com", Student.class);
		student.setRollNo(101);
		restTemplate.put("http://localhost:8585/student/update/ssm@gmail.com", student);
	}
	
	@Test
	public void test_deleteStudent() {
		RestTemplate restTemplate = new RestTemplate();
		// Student student = restTemplate.getForObject("http://localhost:8585/student/getPassByEmail/ssm@gmail.com", Student.class);
		restTemplate.delete("http://localhost:8585/student/delete/rahul1@gmail.com");
	}

}
