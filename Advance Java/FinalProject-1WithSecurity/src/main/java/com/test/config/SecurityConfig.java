package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public CustomAuthSuccessHandler successHandler;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService getdeDetailsService() {
		return new CustomEmployeeDetails();
	}

	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getdeDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().
		authorizeHttpRequests()
		.requestMatchers("/manager/**").hasRole("MANAGER")
		.requestMatchers("/employee/**").hasRole("USER")
		.requestMatchers("/**").permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/employeeLogin")
		.successHandler(successHandler)
         .permitAll();
		

		return http.build();

	}

}

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Autowired
//	public CustomAuthSuccessHandler successHandler;
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public UserDetailsService getdeDetailsService() {
//		return new CustomEmployeeDetails();
//	}
//
//	@Bean
//	public DaoAuthenticationProvider getAuthenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(this.getdeDetailsService());
//		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
//		return daoAuthenticationProvider;
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
////		http.csrf().disable().authorizeHttpRequests().requestMatchers("/manager/**").hasRole("MANAGER")
////				.requestMatchers("/employee/**").hasRole("USER").requestMatchers("/**").permitAll().and().formLogin()
////				.loginPage("/login").loginProcessingUrl("/employeeLogin")
////				// .defaultSuccessUrl("/user/index")
////				.successHandler(successHandler)
////
////				.permitAll();
////
////		return http.build();
//		
//		
//		http.csrf().disable()
//		.authorizeHttpRequests().requestMatchers("/employee/**").hasRole("USER")
//		.requestMatchers("/manager/**").hasRole("MANAGER")
//		.requestMatchers("/**").permitAll().and()
//		.formLogin().loginPage("/login").loginProcessingUrl("/employeeLogin")
//		
//		.successHandler(successHandler)
//		.permitAll();
//			
//		return http.build();
//
//	}
//
//}
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Autowired
//	public CustomAuthSuccessHandler successHandler;
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public UserDetailsService getdeDetailsService() {
//		return new CustomEmployeeDetails();
//	}
//
//	@Bean
//	public DaoAuthenticationProvider getAuthenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(getdeDetailsService());
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		return daoAuthenticationProvider;
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    http
//	        .csrf().disable()
//	        .authorizeRequests()
//	            .requestMatchers("/employee/**").hasRole("USER")
//	            .requestMatchers("/manager/**").hasRole("MANAGER").requestMatchers("/employee/**").authenticated()
//	            .requestMatchers("/**").permitAll()
//	        .and()
//	        .formLogin()
//	            .loginPage("/login")
//	            .loginProcessingUrl("/employeeLogin")
//	            .successHandler(successHandler)
//	            .permitAll();
//	        
//
//	    return http.build();
//	}
//  
//
//	
//}
