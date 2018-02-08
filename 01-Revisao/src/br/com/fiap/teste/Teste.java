package br.com.fiap.teste;

import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.Sexo;

public class Teste {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setSexo(Sexo.OUTROS);
		
		if (cliente.getSexo() == Sexo.OUTROS) {
			System.out.println(cliente.getSexo());
		}
	}
	
}