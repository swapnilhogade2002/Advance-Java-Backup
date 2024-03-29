package com.swapnil.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args)

	{
		System.out.println("project started!!!!");

//		1. value are stored in the database 

//		Alien telusko = new Alien();
//		telusko.setAid(101);
//		telusko.setAname("shree");
//		telusko.setColor("blue");
//
//		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
//		SessionFactory sf = con.buildSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(telusko);
//		tx.commit();

//		2. fetching value from database

//		To print value on console toStringmethod() should be generated

//		Alien telusko = new Alien();

//		no need to create object because we are creating it in get() method

//		Alien telusko = null;
//		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);		
//	    ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
//		SessionFactory sf = con.buildSessionFactory(reg);
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		telusko = (Alien) session.get(Alien.class, 101);
//		tx.commit();
//		System.out.println(telusko);

//      # embeddable proble(code issue)

//		AlienName an = new AlienName();
//		an.setFname("swapnil");
//		an.setMname("sunil");
//
//		Alien telusko = new Alien();
//		telusko.setAid(108);
//		telusko.setColor("blue");
//		telusko.setAname(an);
//
//		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
//		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
//		SessionFactory sf = con.buildSessionFactory(reg);
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(telusko);
//		tx.commit();
//		System.out.println(telusko);

//		3. Mapping relation practical

//		Laptop laptop = new Laptop();
//		laptop.setLid(104);
//		laptop.setLname("Jio");
//
//		Student s = new Student();
//		s.setRollno(4);
//		s.setName("Kailash");
//		s.setMarks(77);

//		s.getLaptop("hp");

//		s.getLaptop().add(laptop);
//
//		laptop.getStudent().add(s);
//
//		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
//				.addAnnotatedClass(Laptop.class);
//		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//		SessionFactory sf = config.buildSessionFactory(registry);
//		Session session = sf.openSession();
//		session.beginTransaction();
//		session.save(laptop);
//		session.save(s);
//
//		session.getTransaction().commit();
		
		Alien a = null;
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);

//		session 1
		Session session1=  sf.openSession();
		session1.beginTransaction();
		
		a =(Alien)session1.get(Alien.class, 101);
		System.out.println(a);
		
		session1.getTransaction().commit();
		session1.close();
		
		
//        session 2
		Session session2=  sf.openSession();
		session2.beginTransaction();
		
		
		a =(Alien)session2.get(Alien.class, 101);
		System.out.println(a);
		
		session2.getTransaction().commit();
		session2.close();
		
		

	}
}
