package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.Student_Repository;

@Service
public class Student_Service {

	@Autowired
	Student_Repository studentRepo;

// ======================================================================================================================

		//  Insert Operation by Id-Unique Email:-    Op:3

		public String storeStudent(Student student) {
			boolean res = studentRepo.existsById(student.getEmail());
			System.out.println(res);

			if(res) {
				return "Student details didn't store...\nYou have already Registered...";
			}
			else {
				studentRepo.save(student);
				return "Student("+ student.getName() +") Registered successfully...";
			}
		}

// =====================================================================================================================

		//  Retrieve Message by Email & password | Login Operation :-   Op: 7

		public String login(Student student) {

			String email = student.getEmail();
			String password = student.getPassword();

			Optional<Student> op = studentRepo.findById(email);
			System.out.println("**************************"+op);

			if(op.isPresent()) {
				Student p = op.get();
				if(p.getPassword().equals(password)) {
					return "WELCOME";
				} else {
					return "Password may be worng";
				}
			} else {
				return "Email or Password may be worng";
			}

		}

 
// ====================================================================================================================
// ====================================================================================================================

 
}
