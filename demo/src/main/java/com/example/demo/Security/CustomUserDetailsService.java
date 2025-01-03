package com.example.demo.Security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomUserRepository customUserRepository;

    public CustomUserDetailsService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //can add aditional logic to deal with the optional
        CustomUser customUser = customUserRepository.findById(username).get();

        //this is where you can add roles and authorities
        //maybe they are in a separate table
        //relational mapping to get roles and authorities
        return User.withUsername(customUser.getUsername()).password(customUser.getPassword()).build();
    }
}
