package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Exercicio07 {

	public static void main(String[] args) {
		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();
		
		ContaCorrente c1 = new ContaCorrente(1, 2, Calendar.getInstance(), 100, TipoConta.COMUM);
		ContaCorrente c2 = new ContaCorrente(1, 3, Calendar.getInstance(), 1000, TipoConta.ESPECIAL);
		ContaCorrente c3 = new ContaCorrente(1, 4, Calendar.getInstance(), 500, TipoConta.PREMIUM);
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
		for (int i=0; i < lista.size(); i++) {
			ContaCorrente cc = lista.get(i);
			System.out.println("Agencia: " + cc.getAgencia()
			 + "\nNúmero: " + cc.getNumero() 
			 + "\nData Abertura: " + cc.getDataAbertura().getTime()
			 + "\nSaldo: " + cc.getSaldo() 
			 + "\nTipo: " + cc.getTipo());
			System.out.println("**************************");
		}
	}
	
}