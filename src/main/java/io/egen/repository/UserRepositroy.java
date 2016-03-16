package io.egen.repository;

import io.egen.entity.User;
import io.egen.exception.UserBadAuthentication;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository

public interface UserRepositroy {

	public List<User> findAllUsers ();
	public User findUserById(String id);
	public User findUserByEmail(String email);
	public User createUser(User user);
	public User updateUser(User user);
	public User deleteUser(String id);
	public void authenticate(String password) throws UserBadAuthentication;
}
