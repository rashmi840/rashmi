package com.User.UserCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.User.UserCrud.Repository.userRepository;
import com.User.UserCrud.model.user;

@CrossOrigin(origins = {"http://localhost:3005/"})
@RestController

public class UserController {

	@Autowired
	userRepository userRepository;
 
	@GetMapping("/home")
	public String hello() {
		return "this is home !!";
	}
	
	@PutMapping("/change")
	public user updateUser(@RequestBody user user) {
		System.out.println("data changed");
		return userRepository.updateUser(user);
	}
	
	@PostMapping("/users")
	public user addUser(@RequestBody user user) {
		return userRepository.saveUser(user);
	}
	
	@GetMapping("/users")
	public List<user> getAllUser(){
		return userRepository.getAllUser();
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		return userRepository.deleteUser(id);
	}
	
}