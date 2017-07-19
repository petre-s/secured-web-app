package com.fun.services;

import com.fun.db.User;
import com.fun.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by pstanaringa on 19.07.2017.
 */

@Service
public class DatabaseUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public DatabaseUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.getUserByUsername(username);

        if (null == user){
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
