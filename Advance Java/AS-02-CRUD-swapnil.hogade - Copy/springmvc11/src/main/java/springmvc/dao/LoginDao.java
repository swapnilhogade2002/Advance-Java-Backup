package springmvc.dao;

import springmvc.model.User;

public interface LoginDao {
	public int  saveUser (User user);
	public User loginUser(String email, String password);
}
