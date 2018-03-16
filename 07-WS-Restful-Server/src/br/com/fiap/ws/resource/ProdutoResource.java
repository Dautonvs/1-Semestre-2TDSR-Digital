package br.com.fiap.ws.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.ws.dao.ProdutoDAO;
import br.com.fiap.ws.dao.impl.ProdutoDAOImpl;
import br.com.fiap.ws.entity.Produto;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/produto")
public class ProdutoResource {

	private ProdutoDAO dao;
	
	public ProdutoResource() {
		//Inicializar o DAO
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		dao = new ProdutoDAOImpl(em);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto buscar(@PathParam("id") int codigo) {
		return dao.read(codigo);
	}
	
	//Listar os produtos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listar(){
		return dao.list();
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Produto produto, @Context UriInfo url) {
		try {
			dao.create(produto);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		UriBuilder b = url.getAbsolutePathBuilder();
		b.path(String.valueOf(produto.getCodigo()));
		return Response.created(b.build()).build();
	}
	
}



