package br.com.fiap.loja.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	private static final Logger log = 
			LoggerFactory.getLogger(EstoqueBO.class);
	
	public ProdutoTO consultarProduto(int codigo) {
		ProdutoTO to = null;
		log.debug("Consultando um produto");
		switch (codigo) {
		case 401:
			to = new ProdutoTO(401,
					"Camiseta Masculina", 50, 10);
			break;
		case 402:
			to = new ProdutoTO(402,
					"Camiseta Feminina", 40, 20);
			break;
		}
		return to;
	}
	
}
