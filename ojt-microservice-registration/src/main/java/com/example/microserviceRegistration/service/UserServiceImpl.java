package com.example.microserviceRegistration.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.microserviceRegistration.exception.InvalidUsernamePassword;
import com.example.microserviceRegistration.exception.NoUserFoundException;
import com.example.microserviceRegistration.model.UserList;
import com.example.microserviceRegistration.repository.RegisterRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	RegisterRepository repo;

	UserList userList;

	public void save(UserList userList) {
		repo.save(userList);
	}

	@Override
	public List<UserList> getAllUsers() {
		return (List<UserList>) repo.findAll();
	}

	@Override
	public UserList saveUser(UserList userList) {
		return repo.save(userList);
	}

	@Override
	public UserList getUserById(String userName) throws NoUserFoundException {
		return repo.findById(userName).orElseThrow(() -> new NoUserFoundException());

	}

	@Override
	public UserList updateUser(UserList userList, String userName) throws NoUserFoundException {

		UserList existingUser = repo.findById(userName).orElseThrow(() -> new NoUserFoundException());

		existingUser.setFirstName(userList.getFirstName());
		existingUser.setLastName(userList.getLastName());
		existingUser.setUserName(userList.getUserName());
		existingUser.setPassword(userList.getPassword());
		existingUser.setAddress(userList.getAddress());
		existingUser.setPhoneNo(userList.getPhoneNo());

		// save existing employee to DB
		repo.save(existingUser);

		return existingUser;
	}

	@Override
	public void deleteUser(String userName) throws NoUserFoundException {

		// check whether a employee exist in a DB or not
		repo.findById(userName).orElseThrow(() -> new NoUserFoundException());
		repo.deleteById(userName);
	}

	@Override
	public void loginvalidation(UserList userList) throws InvalidUsernamePassword {

		if (repo.loginValidate(userList.userName, userList.getPassword()).isEmpty()) {
			throw new InvalidUsernamePassword();
		}

	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		System.out.print(userName);
//		UserList userList = repo.findByUserName(userName);
//		if(userList == null)
//		{
//			throw new UsernameNotFoundException("incorrect username and password");
//		}
//		System.out.print("username  :::" + userList.userName);
//		System.out.print("password  :::" + userList.getPassword());
//		return new UserSecurity(userList);
//	}

}
