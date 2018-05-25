package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.VeiculoService;
import br.com.fiap.ws.to.Veiculo;

@ManagedBean
public class VeiculoBean {

	private Veiculo veiculo;
	
	private VeiculoService service;
	
	//Método de inicialização!
	@PostConstruct
	private void init() {
		veiculo = new Veiculo();
		service = new VeiculoService();
	}
	
	//Método para o clique do botão remover
	public String remover(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-veiculo?faces-redirect=true";
	}
	
	//Método que popula a tabela HTML na página
	public List<Veiculo> listar(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Método do clique do botão
	public String cadastrar() {
		FacesMessage msg;
		try {
			if (veiculo.getCodigo() == 0) {
				service.cadastrar(veiculo);
				msg = new FacesMessage("Sucesso!");
			}else {
				service.atualizar(veiculo);
				msg = new FacesMessage("Atualizado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		//Adicionar a mensagem para ser exibida na tela
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		//Redirect para não cadastrar outros veiculos no refresh da página
		return "veiculo?faces-redirect=true";
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
}