package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
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
	
	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	
	
	
}