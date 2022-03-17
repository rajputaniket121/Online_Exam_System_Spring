package com.online_exam_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_exam_system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String UserName);

	

}
