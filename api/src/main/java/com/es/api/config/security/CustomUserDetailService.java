package com.es.api.config.security;

import com.es.api.dto.UserDTO;
import com.es.api.entity.User;
import com.es.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;


    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Optional<User> userRepositoryById = userRepository.findById(Long.valueOf(id));
        UserDTO userDTO = new UserDTO();
        if(userRepositoryById.isPresent()){
            User user = userRepositoryById.get();
            userDTO.setUserId(user.getUserId());
            userDTO.setId(user.getId());
            userDTO.setPassword(user.getPassword());
        }

        return new UserPrincipal(userDTO);

    }
}
