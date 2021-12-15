package com.example.microserviceRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.microserviceRegistration.model.UserList;


@Repository
public interface RegisterRepository extends CrudRepository<UserList, String> {

	@Query("From UserList where USER_NAME =?1 and PASSWORD=?2")
	List<UserList> loginValidate(String user_Name, String password);
	
	UserList findByUserName(String userName);

}
