package br.com.fiap.ws.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.ws.dao.GenericDAO;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.exception.KeyNotFoundException;

public class GenericDAOImpl<T,K> 
						implements GenericDAO<T, K>{

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) 
			getClass().getGenericSuperclass())
						.getActualTypeArguments()[0];
	}
	
	@Override
	public void create(T entity) {
		em.persist(entity);
	}

	@Override
	public T read(K id) {
		return em.find(clazz, id);
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
	}

	@Override
	public void delete(K id) throws KeyNotFoundException {
		T entity = read(id);
		if (entity == null) {
			throw new KeyNotFoundException();
		}
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException();
		}
	}

	@Override
	public List<T> list() {
		return em.createQuery("from " + clazz.getName(),clazz).getResultList();
	}

}
