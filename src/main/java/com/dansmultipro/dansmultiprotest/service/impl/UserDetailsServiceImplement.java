package com.dansmultipro.dansmultiprotest.service.impl;


import com.dansmultipro.dansmultiprotest.entity.User;
import com.dansmultipro.dansmultiprotest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImplement implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optUser = userRepository.findByUserNameOrEmail(userName, userName);
        if (optUser.isPresent()) {
            User user = optUser.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
//                    user.getRoles()
//                    .stream().map(roles -> new SimpleGrantedAuthority(roles.getRoleName()))
//                    .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
        }
        throw new RuntimeException("user not exist");
    }
}
