package br.com.db;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import br.com.nubank.Cliente;

public class HibernateUtil {
	
	private StandardServiceRegistry ssr;
	private Metadata meta;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public HibernateUtil() {		
		//Ao criar a classe ela já instancia todas as ferramentas necessarias
		//para trabalhar o save, update e delete
		try {
			ssr = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml")
					.build();        
			meta = new MetadataSources(ssr).getMetadataBuilder().build();  
   
			factory = meta.getSessionFactoryBuilder().build();  
			session = factory.openSession();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
		
	public Object recoverFromDB(Class<?> crs, int numeroConta) {
		if(!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			transaction = session.beginTransaction();
		}
		Object object = session.get(crs, numeroConta);
		session.clear();
		return object;
	}

  	public void saveToDB(Object object) {
  		if(!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			transaction = session.beginTransaction();
		}
  		session.saveOrUpdate(object);
  		transaction.commit();
  		session.clear();
  	}
  	
  	public ClienteTemporario loginCheck(int numeroConta, int senha) {
  		
		try {
			
			final Cliente cliente = (Cliente) recoverFromDB(Cliente.class, numeroConta);
			final ClienteTemporario clienteTemporario;
			
			if (cliente == null) {		
				return null;					
			} else if (cliente.getNumeroConta() == numeroConta && cliente.getSenha() == senha) {
				clienteTemporario = new ClienteTemporario(cliente.getNome(),
						cliente.getNumeroConta(), cliente.getSaldo());
				return clienteTemporario;					
			}else {
				return null;					
			}		
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
  	}

	public void closeConections() {
		transaction.rollback();
		session.close();
	}

	public void closeEverthing() {
		session.flush();
		session.close();
		session.disconnect();
		factory.close();
		
	}  	
	  	
}
