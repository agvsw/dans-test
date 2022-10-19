package com.dansmultipro.dansmultiprotest.controller;


import com.dansmultipro.dansmultiprotest.dto.CommonResponse;
import com.dansmultipro.dansmultiprotest.dto.UserDTO;
import com.dansmultipro.dansmultiprotest.entity.User;
import com.dansmultipro.dansmultiprotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public CommonResponse<User> registerAdmin(@RequestBody UserDTO userDto) {
        CommonResponse<User> response = new CommonResponse<>();
        response.setData(userService.register(userDto));
        return response;
    }

}
