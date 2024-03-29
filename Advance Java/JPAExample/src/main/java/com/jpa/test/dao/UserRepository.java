package com.jpa.test.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entity.User;


public interface UserRepository extends CrudRepository<User, Integer> {
	
//	*******custom finder method****
	 Optional<User> findByName(String name);
	 
//	 custom query
	 @Query("select u from User u") 
	 public List<User> getAllUser();
}
