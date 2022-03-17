package com.online_exam_system.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_exam_system.model.Role;
import com.online_exam_system.model.User;
import com.online_exam_system.model.UserRole;
import com.online_exam_system.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping(path ="/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@GetMapping
	public List<User> getUsers(){
        return userService.getAllUsers();
    }
	
	@PostMapping(path = "/")
	public User createUser(@RequestBody User user) throws Exception {
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role(1l, "User");
		UserRole userRole = new UserRole(user,role);
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
	
	
	@GetMapping("/{username}")
	public User FindByUserName(@PathVariable("username") String username)
	{
		return this.userService.getUserbyName(username);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") long id)
	{
		this.userService.deleteUserById(id);
	}
}
