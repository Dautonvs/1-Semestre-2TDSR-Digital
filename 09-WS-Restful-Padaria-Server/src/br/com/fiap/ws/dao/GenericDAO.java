package br.com.fiap.ws.dao;

import java.util.List;

import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {

	void create(T entity);
	T read(K id);
	void update(T entity);
	void delete(K id) throws KeyNotFoundException;
	List<T> list();
	
	void commit() throws CommitException;
}