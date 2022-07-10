package com.es.api.service;

import com.es.api.entity.User;
import com.es.api.exception.AlreadyExistsException;
import com.es.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    // 로그인
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    // 가입
    public User join(String email, String password, String name) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent())
            throw new AlreadyExistsException("Duplicate email");

        return userRepository.save(new User(email, password, name));
    }

    // 로그인
    public User getEmail(String id) {
        Optional<User> user = userRepository.findByEmail(id);
        return user.get();
    }

}
