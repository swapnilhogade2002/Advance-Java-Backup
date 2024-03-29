package springmvc.dao;

import java.io.Serializable;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springmvc.model.User;

@Repository
@Transactional
public class UserDao {
	@Autowired
//	reaching database
	private HibernateTemplate hibernateTemplate;

	public int saveUser(User user) {
		int id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}

	public User loginUser(String email, String password) {
		String sql = "from User where email =:em and password=:pwd ";
		User us = (User) hibernateTemplate.execute(s -> {
			Query q = s.createQuery(sql);
			q.setString("em", email);
			q.setString("pwd", password);
			return q.uniqueResult();

		});
		return us;
	}
}
