package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.exception.ResourceNotFoundException;
import com.payload.ApiResponse;
import com.repository.Student_Repository;
import com.service.Student_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student") 	//  http://localhost:8585/student
public class Student_Controller {
	
	@Autowired
	Student_Repository studentRepo;

	@Autowired
	Student_Service studentService;

//****************************************** : CRUD Operation : ********************************************** 
//============================================================================================================

		//  Retrieve Operation:-  Op:1
		//  http://localhost:8585/student/getAll

		@GetMapping("/getAll")
		public ResponseEntity<List<Student>> getAll() {

				List<Student> user = new ArrayList<Student>();
				studentRepo.findAll().forEach(user::add);
	
				if (user.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

			return new ResponseEntity<>(user, HttpStatus.OK);
		}

//=======================================================================================================================================

		//  Retrieve data by User-Email :-  Op:2
		//  http://localhost:8585/student/getByEmail/{email}

		@GetMapping("/getByEmail/{email}")
		public ResponseEntity<Student> getByEmail(@PathVariable("email") String email) {

			Student student = studentRepo.findById(email)
					.orElseThrow(() -> new ResourceNotFoundException("Not found Student with Email = " + email));

			return new ResponseEntity<>(student, HttpStatus.OK);
		} 

//=======================================================================================================================================

		//  Insert Operation:-    Op:3
		//  http://localhost:8585/student/store
		
		@PostMapping(value="store", consumes = MediaType.APPLICATION_JSON_VALUE)
		public String storeStudent(@RequestBody Student student) {
			System.out.println(student.getEmail());

			return studentService.storeStudent(student);
		}
		
//=======================================================================================================================================

		//  Update Operation:-   Op:4
		//  http://localhost:8585/student/update/{email}

		@PutMapping("/update/{email}")
		public ResponseEntity<Student> updateStudent(@PathVariable("email") String email,
										             @RequestBody Student stuReq) {

			Student _student = studentRepo.findById(email)
					.orElseThrow(() -> new ResourceNotFoundException("Not found Student with Email = " + email));

					_student.setName(stuReq.getName());
					_student.setPassword(stuReq.getPassword());
					_student.setRollNo(stuReq.getRollNo());
					
			return new ResponseEntity<>(studentRepo.save(_student), HttpStatus.OK);
		}

//=======================================================================================================================================

	    //  Delete Operation by Id:-   Op:5
		//  http://localhost:8585/student/delete/{email}

		@DeleteMapping("/delete/{email}")
		public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("email") String email) {

				Student student_email = studentRepo.findById(email)
						.orElseThrow(() -> new ResourceNotFoundException("Not found Student with Email = " + email));

				studentRepo.deleteById(email);

			// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			   return new ResponseEntity<ApiResponse>(new ApiResponse("Student details deleted Successfully", true), HttpStatus.OK);
		}

//=======================================================================================================================================

		//  All Delete Operation:-   Op:6
		//  http://localhost:8585/student/deleteAll

		@DeleteMapping("/deleteAll")
		public ResponseEntity<HttpStatus> deleteAll() {

				studentRepo.deleteAll();
    
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

//============================================================================================================
//**************************************** : User Define : *************************************************** 
//============================================================================================================

		//  Retrieve Message by Email & password | Login Operation :-   Op: 7
		//  http://localhost:8585/student/login

		@PostMapping(value = "login")
		public String login(@RequestBody Student student) {

				System.out.println("Controller: "+student.getEmail());
				//Thread.sleep(3000);
				return studentService.login(student);
		}


//=============================================================================================================================== 
//=============================================================================================================================== 

}