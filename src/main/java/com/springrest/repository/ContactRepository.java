package com.springrest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.entities.ContactModel;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Integer> {
	
	@Query(value="select * from zohocrmapp1.contacts where first_name=:first_name and "
			+ " last_name=:last_name and email=:email and mobile=:mobile", nativeQuery=true)
	Optional<ContactModel> existRecord(@Param("first_name") String first_name, 
			            @Param("last_name") String last_name,
			            @Param("email")String email, 
			            @Param("mobile")String mobile);



}
