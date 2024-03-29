package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepo;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {

		String password = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(password);
		employee.setRole("ROLE_USER");

		return employeeRepo.save(employee);
	}

	@Override
	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}

//	retriving data pdf
	public List<Employee> getAllEntities() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeByname(String email) {
		this.employeeRepo.getEmployeeByName(email);
		return null;
	}

	@Override
	public boolean existsByEmail(String email) {
		return employeeRepo.existsByEmail(email);
	}
}
