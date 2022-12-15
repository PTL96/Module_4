package com.castudy.service.impl;

import com.castudy.model.security.MyUserDetail;
import com.castudy.model.security.User;
import com.castudy.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println(username);
        System.out.println("-----------------");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + "not found");
        }
        return new MyUserDetail(user);
    }
}
