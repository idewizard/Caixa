package br.com.nubank;

import br.com.db.HibernateUtil;

public class Temporaria {

	public static void main(String[] args) {
		
		
		//CLASSE ABSOLUTAMENTE TEMPORARIA PARA PREENCHER DADOS
		//PODIA TER INSERT INTO, MAS JA TESTA O SISTEMA AQ
		HibernateUtil hb = new HibernateUtil();
		
//		Cliente c1 = new Cliente("Fernando Sousa","123040",123456);
//		c1.setSaldo(6455.55);		
//		Cliente c2 = new Cliente("Jo�o batista","15540",123456);
//		c2.setSaldo(1.24);		
//		Cliente c3 = new Cliente("Maria Julia","21340",123456);
//		c3.setSaldo(12336.19);		
//		Cliente c4 = new Cliente("Fabio Milsu","167040",123456);
//		c4.setSaldo(2355.12);		
//		Cliente c5 = new Cliente("Marcos Mendes","155040",123456);
//		c5.setSaldo(985);		
//		Cliente c6 = new Cliente("Rafael Gomes","123056",123456);
//		c6.setSaldo(8425.96);		
		Cliente c7 = (Cliente) hb.recoverFromDB(Cliente.class, 2347);
		c7.setSaldo(05.05);
		
		hb.saveToDB(c7);
//		
//		hb.saveToDB(c1);
//		hb.saveToDB(c2);
//		hb.saveToDB(c3);
//		hb.saveToDB(c4);
//		hb.saveToDB(c5);
//		hb.saveToDB(c6);

		//CLASSE ABSOLUTAMENTE TEMPORARIA PARA PREENCHER DADOS
		//PODIA TER INSERT INTO, MAS JA TESTA O SISTEMA AQ
		
	}
	
}
