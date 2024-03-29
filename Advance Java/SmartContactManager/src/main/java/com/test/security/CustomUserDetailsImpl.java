package com.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.test.entities.User;

import com.test.dao.UserRepository;



@Component
public class CustomUserDetailsImpl implements UserDetailsService {

 @Autowired
 private UserRepository uRepo;

 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  User user = uRepo.getUserByUsername(username);

  if (user == null) {
   throw new UsernameNotFoundException("User not found!");
  } else {
     CustomUserDetail customUserDetail = new CustomUserDetail(user);
     return customUserDetail;
  }
 }
}
