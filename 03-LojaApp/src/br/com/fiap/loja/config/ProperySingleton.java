package br.com.fiap.loja.config;

import java.io.IOException;
import java.util.Properties;

public class ProperySingleton {

	private static Properties p;
	
	private ProperySingleton() {}
	
	public static Properties getInstance() {
		if (p == null) {
			p = new Properties();
			try {
				p.load(ProperySingleton.class
						.getResourceAsStream("/loja.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
