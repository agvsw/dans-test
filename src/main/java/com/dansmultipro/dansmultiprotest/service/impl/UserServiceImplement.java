package com.dansmultipro.dansmultiprotest.service.impl;


import com.dansmultipro.dansmultiprotest.dto.UserDTO;
import com.dansmultipro.dansmultiprotest.entity.User;
import com.dansmultipro.dansmultiprotest.repository.UserRepository;
import com.dansmultipro.dansmultiprotest.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(UserDTO userDTO) {
        User user = new ObjectMapper().convertValue(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Optional<User> optUser = userRepository.findByUserNameOrEmail(userDTO.getUserName(), userDTO.getEmail());
        if (!optUser.isPresent()) {
            return userRepository.save(user);
        }
        throw new RuntimeException("User already exist");
    }

}
