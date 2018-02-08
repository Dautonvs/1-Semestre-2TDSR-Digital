package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;

public class Teste {

	public static void main(String[] args) {
		Calendar dataAbertura = Calendar.getInstance(); //HOJE
		
		Calendar dataAbertura2 = 
				new GregorianCalendar(2015,Calendar.JANUARY,2);
		
		ContaCorrente cc = 
				new ContaCorrente(1,2,dataAbertura,100,TipoConta.COMUM);
		
		ContaPoupanca cp =
				new ContaPoupanca(1, 3, dataAbertura2, 500, 5);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Exibe a data formatada
		System.out.println(sdf.format(cc.getDataAbertura().getTime()));
	}
	
}





