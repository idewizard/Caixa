package br.com.nubank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {


		Cliente cliente = new Cliente("Jose maria","231312344",323);
	    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	   
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		            
		Cliente c1 = new Cliente("José Maria","123131",12345); 
	  
		    
		session.save(c1);  
		t.commit();  
		System.out.println("successfully saved");    
		factory.close();  
		session.close();   
	

	}

}
