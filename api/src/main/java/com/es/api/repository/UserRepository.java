package com.es.api.repository;

import com.es.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserId(String userId);

    Optional<User> findById(Long id);

    User findByUserIdAndPassword(String userId, String password) throws Exception;
}