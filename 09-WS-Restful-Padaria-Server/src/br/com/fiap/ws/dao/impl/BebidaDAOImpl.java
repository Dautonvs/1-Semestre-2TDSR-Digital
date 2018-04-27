package br.com.fiap.ws.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.ws.dao.BebidaDAO;
import br.com.fiap.ws.entity.Bebida;

public class BebidaDAOImpl 
			extends GenericDAOImpl<Bebida, Integer>
										implements BebidaDAO{

	public BebidaDAOImpl(EntityManager em) {
		super(em);
	}

}