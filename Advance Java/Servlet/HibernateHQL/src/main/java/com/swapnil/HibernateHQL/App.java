package com.swapnil.HibernateHQL;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();

//		for inserting data

//		Random r = new Random();
//		for (int i = 0; i <= 50; i++) {
//			Student s = new Student();
//			s.setRollno(i);
//			s.setName("Name" + i);
//			s.setMarks(r.nextInt(100));
//			session.save(s);
//
//		}

// 		showing student which marks>50

//		org.hibernate.query.Query q =  session.createQuery("FROM Student WHERE marks>50");
//		List<Student> student =  q.list();
//		for (Student s : student) {
//			System.out.println(s);
//		}
//		

//		fetching data using object

//		org.hibernate.query.Query q = session.createQuery("SELECT rollno , name , marks FROM Student");
//		List<Object[]> students = (List<Object[]>) q.list();
//
//		for (Object[] student : students) {
//			System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
//		}
//

//		SQLQuery query = session.creatSQLQuery(" SELECT * FROM student WHERE marks>50");
//		query.addEntity(Student.class);
//		List<Student> students = query.list();
//		for (Student s : students) {
//			System.out.println(s);
//		}
//		session.getTransaction().commit();

	}
}
