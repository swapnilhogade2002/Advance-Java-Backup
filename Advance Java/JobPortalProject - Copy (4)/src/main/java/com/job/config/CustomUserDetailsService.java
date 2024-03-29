package com.job.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.job.entity.User;
import com.job.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

   
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Trying to load user with username: " + email);
        User user = userRepository.findByEmail(email);

        if (user == null) {
            System.out.println("User not found for email: " + email);
            throw new UsernameNotFoundException("User not found");
        } else {
            System.out.println("User found: " + user.getEmail());
            CustomUser customUserDetail = new CustomUser(user);
            return customUserDetail;
        }
    }

}
