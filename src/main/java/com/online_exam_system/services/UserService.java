package com.online_exam_system.services;

import java.util.List;
import java.util.Set;

import com.online_exam_system.model.User;
import com.online_exam_system.model.UserRole;

public interface UserService {
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	public List<User> getAllUsers();
	public User getUserbyName(String name);
	public void deleteUserById(long id);
}
