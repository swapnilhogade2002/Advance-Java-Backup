package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entity.User;

@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaExampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
//		saving single user
//		User user = new User();
//		user.setId(1);
//		user.setName("swapnil");
//		user.setCity("Nashik");
//		user.setStatus("Java");
//		
//		
//		User user1 = userRepository.save(user);
//		System.out.println(user1);
		
	
//		saving multiple user
//		User user1 = new User();
//		user1.setId(1);
//		user1.setName("swapnil");
//		user1.setCity("Nashik");
//		user1.setStatus("Java");
//		
//		User user2 = new User();
//		user2.setId(2);
//		user2.setName("Shree");
//		user2.setCity("Kailash");
//		user2.setStatus("world");
//		
//		List<User> users = List.of(user1, user2);
//		Iterable<User> res = userRepository.saveAll(users);
//		res.forEach(user->{
//					System.out.println(user);
//				});
//		
		
//		updating data
//		Optional<User> optional = userRepository.findById(1);
//		User user =  optional.get();			
//		user.setCity("pune");
//		User save = userRepository.save(user);
//		System.out.println(user);
		
//		getting multiple data
		Iterable<User> itr = userRepository.findAll();
		
//		way 1- getting data
//		Iterator<User> iterator = itr.iterator();
//		
//		while(iterator.hasNext()) {
//			User user = iterator.next();
//			System.out.println(user);
//		}
		
//		way 2- getting data
//		itr.forEach(user->{
//			System.out.println(user);
//		});
		
		
//		deleting user
		
//		deleting single element
//		userRepository.deleteById(52);
//		System.out.println("Record deleted !");
		
//		deleting multiple element element
//		Iterable<User> iterable = userRepository.findAll();
//		iterable.forEach(user->{
//			System.out.println(iterable);
//		});
//		
//		userRepository.deleteAll();
//		System.out.println("All record deleted!");
		
		
//		*******custom finder method****
		Optional<User> findById = userRepository.findByName("swapnil");
		findById.ifPresent(user -> System.out.println(user));

		
//	 custom query
		List<User> Alluser=userRepository.getAllUser();
		
		Alluser.forEach(e->{
			System.out.println(e);
		});
		
		
		
		
		
	}

}
