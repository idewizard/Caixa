package br.com.nubank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import br.com.db.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Joao 3 pernas","156673",12324);
		Cliente c2 = new Cliente("Joao 4 pernas","115533",12324);
		Cliente c3 = new Cliente("Joao 5 pernas","123413",12324);
		
		HibernateUtil hb = new HibernateUtil();
		
//		hb.saveToDB(c1);
//		hb.saveToDB(c2);
//		hb.saveToDB(c3);
		
		Cliente ct = (Cliente) hb.recoverFromDB(Cliente.class, 1);
	
		System.out.println(ct.toString());

	}

}
