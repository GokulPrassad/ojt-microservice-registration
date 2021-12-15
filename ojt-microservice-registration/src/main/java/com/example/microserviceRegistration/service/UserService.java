package com.example.microserviceRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.microserviceRegistration.exception.InvalidUsernamePassword;
import com.example.microserviceRegistration.exception.NoUserFoundException;
import com.example.microserviceRegistration.model.UserList;


public interface UserService {

	List<UserList> getAllUsers();

	UserList saveUser(UserList employee);

	UserList getUserById(String userName) throws NoUserFoundException;

	UserList updateUser(UserList userList, String userName) throws NoUserFoundException;

	void deleteUser(String userName) throws NoUserFoundException;

	void loginvalidation(UserList userList) throws InvalidUsernamePassword;

}
