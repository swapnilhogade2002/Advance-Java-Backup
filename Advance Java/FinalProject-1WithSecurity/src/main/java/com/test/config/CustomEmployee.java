package com.test.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.entity.Employee;
import java.util.Collection;
import java.util.List;

public class CustomEmployee implements UserDetails {

	private Employee employee;

	public CustomEmployee(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(employee.getRole());
		return List.of(authority);
	}

	@Override
	public String getPassword() {
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		return employee.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

//public class CustomEmployee implements UserDetails {
//
//    private Employee employee;
//
//   
//    public CustomEmployee(Employee employee) {
//		super();
//		this.employee = employee;
//	}
//
//	@Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(employee.getRole());
//        return Arrays.asList(authority);
//    }
//
//    @Override
//    public String getPassword() {
//        return employee.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return employee.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
