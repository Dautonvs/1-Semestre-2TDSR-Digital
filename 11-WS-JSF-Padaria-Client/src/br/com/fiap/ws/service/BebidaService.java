package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Bebida;

public class BebidaService {
	
	private final static String URL = "http://localhost:8080/09-WS-Restful-Padaria-Server/rest/bebida";

	private Client client = Client.create();
	
	public void cadastrar(Bebida bebida) throws Exception {
		WebResource resource = client.resource(URL);
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,bebida);
	
		if (resp.getStatus() != 201) {
			throw new Exception("Erro " + resp.getStatus());
		}
	}
	
	public void atualizar(Bebida bebida) throws Exception {
		WebResource resource = client.resource(URL)
				.path(String.valueOf(bebida.getCodigo()));
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class,bebida);
		
		if (resp.getStatus() != 200) {
			throw new Exception("Erro " + resp.getStatus());
		}
	}
	
	public Bebida pesquisar(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				.path(String.valueOf(codigo));
		
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		if (resp.getStatus() != 200) {
			throw new Exception("Erro " + resp.getStatus());
		}
		
		return resp.getEntity(Bebida.class);
	}
	
	public List<Bebida> listar() throws Exception{
		WebResource resource = client.resource(URL);
		
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		if (resp.getStatus() != 200) {
			throw new Exception("Erro " + resp.getStatus());
		}
		
		return Arrays.asList(resp.getEntity(Bebida[].class));
	}
	
	public void remover(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				.path(String.valueOf(codigo));
		
		ClientResponse resp = resource.delete(ClientResponse.class);
		
		if (resp.getStatus() != 204) {
			throw new Exception("Erro " + resp.getStatus());
		}
	}
	
}