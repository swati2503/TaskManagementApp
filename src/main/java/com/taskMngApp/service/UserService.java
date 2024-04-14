package com.taskMngApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskMngApp.model.User;
import com.taskMngApp.dao.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	public User insert(User user) {
        return userRepository.save(user);
    }
	
	public List<User> findAll() {
        return userRepository.findAll();
    }
	public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }
	
	public User updateUser(int id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setEmail(updatedUser.getEmail());
            // Set other fields if needed
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	

}
