package com.swapnil.HibernateObjectStates;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

//		data inserted in a table randomely
		
//		Random r = new Random();
//		for (int i = 0; i <= 50; i++) {
//			Laptop s = new Laptop();
//			s.setLid(i);
//			s.setBrand(null);
//			s.setPrice(r.nextInt(10000));
//			session.save(s);
//
//		}

//        Laptop l = new Laptop();
//        l.setLid(104);
//        l.setBrand("sony");
//        l.setPrice(88025);
//        
//        session.save(l);

//      after save also this value will stored in databasee
//        l.setPrice(11000);

//       object is going in remove state / Remove not stored in database
//       session.remove(l);

//		using get() method we can fetch data in dataabase		
//		Laptop l = session.get(Laptop.class, 2);
//		System.out.println(l);

//		using Load() method also we can fetch data in dataabase
		Laptop l = session.get(Laptop.class, 2);
		System.out.println(l);

		session.getTransaction().commit();

//      after detachment value will not stored
//        session.detach(l);
//        l.setPrice(99000);
//        

	}
}
