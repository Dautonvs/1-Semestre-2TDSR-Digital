package br.com.fiap.ws.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.ws.dao.BebidaDAO;
import br.com.fiap.ws.dao.impl.BebidaDAOImpl;
import br.com.fiap.ws.entity.Bebida;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/bebida")
public class BebidaResource {

	private BebidaDAO dao;
	
	public BebidaResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new BebidaDAOImpl(em);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Bebida bebida, @Context UriInfo uri) {
		try {
			dao.create(bebida);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		UriBuilder builder = uri.getAbsolutePathBuilder();
		builder.path(String.valueOf(bebida.getCodigo()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Bebida bebida, @PathParam("id") int codigo) {
		try {
			bebida.setCodigo(codigo);
			dao.update(bebida);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bebida buscar(@PathParam("id") int codigo) {
		return dao.read(codigo);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bebida> listar(){
		return dao.list();
	}
	
	@DELETE
	@Path("{id}")
	public void remover(@PathParam("id") int codigo) {
		try {
			dao.delete(codigo);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
	
}









