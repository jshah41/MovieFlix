package io.egen.service;

import io.egen.entity.User;
import io.egen.exception.UserAlreadyExistsException;
import io.egen.exception.UserBadAuthentication;
import io.egen.exception.UserNotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	List<User> findAllUsers();

	User findUserById(String id) throws UserNotFoundException;

	User findUserByEmail(String email) throws UserNotFoundException;

	User createUser(User user) throws UserAlreadyExistsException;

	User updateUser(String id, User user) throws UserNotFoundException;

	User deleteUser(String id) throws UserNotFoundException;
	
	void authenticate(String password) throws UserBadAuthentication;

}
