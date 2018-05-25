package br.com.fiap.ws.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ws.dao.VeiculoDAO;
import br.com.fiap.ws.entity.Veiculo;

public class VeiculoDAOImpl 
				extends GenericDAOImpl<Veiculo, Integer>
										implements VeiculoDAO{

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
	}

}
