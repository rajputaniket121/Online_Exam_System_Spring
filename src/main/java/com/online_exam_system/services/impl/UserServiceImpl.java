package com.online_exam_system.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_exam_system.model.User;
import com.online_exam_system.model.UserRole;
import com.online_exam_system.repo.RoleRepositoey;
import com.online_exam_system.repo.UserRepository;
import com.online_exam_system.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepositoey roleRepository;
	
	//Creating Users
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		User localUser= userRepository.findByUsername(user.getUsername());
		if(localUser!=null)
		{
			System.out.println("User Is Already Exist !!");
			throw new Exception("User Already Present !!");
		}else {
			
			for(UserRole userRole:userRoles) {
				roleRepository.save(userRole.getRole());
			}
			
			user.getUserroles().addAll(userRoles);
			this.userRepository.save(user);	
		}
		return localUser;
	}
	
	@Override
    public List < User > getAllUsers() {
        List < User > user = userRepository.findAll();
//        user.add(new User(1l,"Aniket", "Aniket@121","7898870373","Indore",
//        			"DOB","M.P.","2017", "profile"));
        return user;
    }

	@Override
	public User getUserbyName(String name) {
		return  this.userRepository.findByUsername(name);
	}

	@Override
	public void deleteUserById(long id) {
	 this.userRepository.deleteById(id);
	}


}
