package com.login.servise;

import com.login.model.MyUserDetail;
import com.login.model.User;
import com.login.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = iUserRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User name: " + userName + "not found");
        }
        return new MyUserDetail(user);
    }
}
