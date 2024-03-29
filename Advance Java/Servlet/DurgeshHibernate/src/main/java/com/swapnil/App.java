package com.swapnil;

/*import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;*/

public class App {
    public static void main(String[] args) {
        System.out.println("Project started!");
        
        // Create a Configuration object, configure it and build a SessionFactory
		/*
		 * Configuration configuration = new Configuration().configure(); SessionFactory
		 * factory = configuration.buildSessionFactory();
		 */

        // Use the factory for Hibernate operations
        
        // Remember to close the factory when you're done
        factory.close();
    }
}
