package br.com.fiap.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.BebidaService;
import br.com.fiap.ws.to.Bebida;

@ManagedBean
public class BebidaBean {

	private Bebida bebida;
	
	private BebidaService service;

	@PostConstruct
	private void init() {
		bebida = new Bebida();
		//Inicializar a data
		bebida.setDataValidade(Calendar.getInstance());
		service = new BebidaService();
	}
	
	public List<Bebida> getBebidas(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String excluir(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter as mensagens após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-bebida?faces-redirect=true";
	}
	
	public String salvar() {
		FacesMessage msg;
		try {
			if (bebida.getCodigo() == 0) {
				service.cadastrar(bebida);
				msg = new FacesMessage("Cadastrado com sucesso!");
			}else {
				service.atualizar(bebida);
				msg = new FacesMessage("Atualizado com sucesso!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter as mensagens após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-bebida?faces-redirect=true"; //Navega para a página de listagem
	}
	
	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	
	
	
}