package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomEmployeeDetails implements UserDetailsService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepo.getEmployeeByName(username);

		if (employee == null) {
			throw new UsernameNotFoundException("User not found!");
		} else {
			CustomEmployee customEmployee = new CustomEmployee(employee);
			return customEmployee;
		}
	}
}

//@Component
//public class CustomEmployeeDetails implements UserDetailsService {
//
//    @Autowired
//    private EmployeeRepo employeeRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Employee employee = employeeRepo.findByEmail(username);
//
//        if (employee == null) {
//            throw new UsernameNotFoundException("User not found!");
//        } else {
//            return new CustomEmployee(employee);
//        }
//    }
//}

//@Component
//public class CustomEmployeeDetails implements UserDetailsService {
//
//	@Autowired
//	private EmployeeRepo employeeRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Employee employee = employeeRepo.findByEmail(username);
//
//		if (employee == null) {
//			throw new UsernameNotFoundException("User not found!");
//		} else {
//			return new CustomEmployee(employee);
//		}
//	}
//}