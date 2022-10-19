package com.dansmultipro.dansmultiprotest.service;


import com.dansmultipro.dansmultiprotest.dto.UserDTO;
import com.dansmultipro.dansmultiprotest.entity.User;

public interface UserService {
    User register(UserDTO userDTO);
}
