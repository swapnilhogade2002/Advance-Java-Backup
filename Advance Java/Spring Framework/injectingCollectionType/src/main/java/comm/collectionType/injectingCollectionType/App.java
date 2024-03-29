package comm.collectionType.injectingCollectionType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
       Employee emp1= (Employee) context.getBean("emp1");
       System.out.println(emp1.getName());
       System.out.println(emp1.getPhones());
    }
}
