package br.com.fiap.ws.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.ws.dao.ProdutoDAO;
import br.com.fiap.ws.entity.Produto;

public class ProdutoDAOImpl 
				extends GenericDAOImpl<Produto, Integer>
									implements ProdutoDAO{

	public ProdutoDAOImpl(EntityManager em) {
		super(em);
	}

}
