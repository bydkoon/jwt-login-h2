package com.es.api.service;

import com.es.api.entity.User;
import com.es.api.exception.AlreadyExistsException;
import com.es.api.parameters.UserParameter;
import com.es.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 로그인
    public User login(UserParameter userParameter) {
        return userRepository.findByUserIdAndPassword(userParameter.getUserId(), userParameter.getPassword());
    }

    // 가입
    public User join(UserParameter userParameter) {
        Optional<User> user = userRepository.findByUserId(userParameter.getUserId());
        if (user.isPresent())
            throw new AlreadyExistsException("Duplicate id");

        return userRepository.save(new User(userParameter.getUserId(), userParameter.getRegNo(), userParameter.getPassword(), userParameter.getName()));
    }

    // 로그인
    public User getId(String id) {
        Optional<User> user = userRepository.findByUserId(id);
        return user.get();
    }

}
