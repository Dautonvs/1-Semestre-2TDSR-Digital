package br.com.fiap.dao;

public interface ClienteDAO {

	void insert(String nome, int idade);
	void delete(int codigo);
	
}