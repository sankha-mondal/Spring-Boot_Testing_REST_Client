package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Student;

@Repository
public interface Student_Repository extends JpaRepository<Student, String> {
	
	//  Retrieve data by Email & Password Operation:-  Op: 5
	
//	@Query("select p from Passenger p where p.pEmail = :pEmail and p.pPassword = :pPassword")
//	public int findPassengerByEmail_Pass(@Param("pEmail") String pEmail,@Param("pPassword") String pPassword);

}

