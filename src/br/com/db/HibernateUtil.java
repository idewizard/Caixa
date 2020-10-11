package br.com.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import br.com.nubank.Cliente;

public class HibernateUtil {
	
	public HibernateUtil() {
		
	}

	  StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
	    		.configure("hibernate.cfg.xml")
	    		.build();        
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	   
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		            
		Cliente c1 = new Cliente("José Maria","13124",4554);

	  
		    
		session.save(c1);  	
		t.commit();  
		System.out.println("successfully saved");    		
		factory.close();  
		session.close();   
	
}
