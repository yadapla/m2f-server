package com.basis.cadastro.service;

import com.basis.cadastro.model.User;
import com.basis.cadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent()
                ? user.get()
                : null;
    }

    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    public User findByEmailAndPassword(String email, String password) {
        User u = userRepository.findByEmailAndPassword(email, password);
        return u;
    }
}
