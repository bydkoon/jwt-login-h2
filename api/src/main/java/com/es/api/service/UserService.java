package com.es.api.service;

import com.es.api.config.security.ErrorCode;
import com.es.api.entity.User;
import com.es.api.exception.AlreadyExistsException;
import com.es.api.exception.AuthException;
import com.es.api.parameters.UserParameter;
import com.es.api.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 로그인
    @ApiOperation(value="로그인")
    public User login(@RequestBody UserParameter userParameter) throws Exception{
        User user = userRepository.findByUserIdAndPassword(userParameter.getUserId(), userParameter.getPassword());
        if (user == null){
            throw new AuthException(ErrorCode.NO_USER);
        }
        return user;

    }

    // 가입
    public User join(UserParameter userParameter) {
        Optional<User> user = userRepository.findByUserId(userParameter.getUserId());
        if (user.isPresent())
            throw new AlreadyExistsException("Duplicate id");

        return userRepository.save(new User(userParameter.getUserId(), userParameter.getRegNo(), userParameter.getPassword(), userParameter.getName()));
    }

    // 로그인
    public User getId(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

}
