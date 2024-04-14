package com.taskMngApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taskMngApp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("UPDATE User u SET u.username = :username, u.password = :password WHERE u.id = :id")
	void updateUserById(@Param("id") int id, @Param("username") String username, @Param("password") String password);

	User findByUsername(String username);
	User findByEmail(String email);
	
	
	

}