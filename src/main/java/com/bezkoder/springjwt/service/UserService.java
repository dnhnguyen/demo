package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.Category;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.CategoryRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user) {
        return userRepository.save(user);
    }

    public ResponseEntity<Object> deleteCategory(Long id) {
        userRepository.deleteById(id);
        return null;
    }
}
