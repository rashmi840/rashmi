package com.User.UserCrud.Repository;

import java.util.List;

import com.User.UserCrud.model.user;


public interface userRepository {
	user saveUser(user user);
	user updateUser(user user);
	String deleteUser(int id);
	List<user> getAllUser();
}
