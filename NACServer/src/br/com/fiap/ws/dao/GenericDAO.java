package br.com.fiap.ws.dao;

import java.util.List;

import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.exception.IdNotFoundException;

public interface GenericDAO <T,K> {

	void cadastrar(T entidade);
	void atualizar(T entidade);
	void remover(K chave) throws IdNotFoundException;
	T buscar(K chave);
	
	List<T> listar();
	
	void commit() throws CommitException;
	
}



