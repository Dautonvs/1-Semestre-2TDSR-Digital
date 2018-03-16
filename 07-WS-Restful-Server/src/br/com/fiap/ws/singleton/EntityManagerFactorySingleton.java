package br.com.fiap.ws.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//1-Construtor privado
	private EntityManagerFactorySingleton() { }
	
	//3-Atributo privado estático
	private static EntityManagerFactory fabrica;
	
	//2-Método publico estático
	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
			fabrica = Persistence
					.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
}
