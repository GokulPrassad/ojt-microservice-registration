package com.example.microserviceRegistration.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microserviceRegistration.exception.InvalidUsernamePassword;
import com.example.microserviceRegistration.exception.NoUserFoundException;
import com.example.microserviceRegistration.model.UserList;
import com.example.microserviceRegistration.service.UserService;



@RestController
public class RestFormController {
	@Autowired
	UserService userService;

	

	// to post a new user details
	@PostMapping("/userInfo/user/")
	public ResponseEntity<String> saveUser(@Valid @RequestBody UserList userList) {
		userService.saveUser(userList);
		return new ResponseEntity<String>("User data successfully added !!.", HttpStatus.OK);
	}






}