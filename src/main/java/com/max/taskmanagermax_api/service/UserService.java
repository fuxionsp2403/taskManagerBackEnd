package com.max.taskmanagermax_api.service;

import com.max.taskmanagermax_api.entity.User;
import com.max.taskmanagermax_api.repository.UserRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    
    private final UserRepository userRepository;
    
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User getByUserName(String username) {
        return userRepository.findByUsername(username);
    }
    
    public Optional<User> getByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email);
    }
    
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    
    public void save(User user) {
        userRepository.save(user);
    }
}
