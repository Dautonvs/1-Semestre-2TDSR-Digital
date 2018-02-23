package br.com.fiap.loja.view;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.config.ProperySingleton;
import br.com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {
	
	private static final Logger log = 
			LoggerFactory.getLogger(TerminalConsulta.class);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		log.info("Inicializando o sistema");
		EstoqueBO bo = new EstoqueBO();
		DecimalFormat df = new DecimalFormat("R$ ##,###.00");
		Calendar hoje = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String nome = ProperySingleton
				.getInstance().getProperty("nome");
		System.out.println(nome+"             " + sdf.format(hoje.getTime()));
		System.out.println("***************************");
		int codigo;
		do {
			System.out.print("Código do produto: ");
			codigo = sc.nextInt(); // ler o código
			
			if (codigo != 0) {
				ProdutoTO prod = bo.consultarProduto(codigo);
				
				if (prod != null) {
					System.out.println(prod.getNome());
					System.out.println(df.format(prod.getPreco()));
					System.out.println(prod.getQuantidade());
				}else {
					System.out.println("Produto não cadastrado");
					log.warn("Produto não cadastrado");
				}
			}
			
		} while (codigo != 0);
		System.out.println("Fim da aplicação");
		log.info("Finalizando a aplicação");
		sc.close();
	}

}
