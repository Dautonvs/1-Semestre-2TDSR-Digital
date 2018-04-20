package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.ProdutoService;
import br.com.fiap.ws.to.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto;
	
	private ProdutoService service;
	
	//Método que é acionado quando a tela é criada
	@PostConstruct
	private void init() {
		produto = new Produto();
		service = new ProdutoService();
	}
	
	//Método para o clique do botão excluir
	public void excluir(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao remover");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	//Método para enviar a lista de produto para a tela
	public List<Produto> getProdutos(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Método para o clique do botão Salvar
	public String salvar() {
		FacesMessage msg; //Mensagem para a tela
		try {
			//Verificar se deve cadastrar ou atualizar
			if (produto.getCodigo() == 0) {
				service.cadastrar(produto);
				msg = new FacesMessage("Cadastrado com sucesso!");
			}else {
				service.atualizar(produto);
				msg = new FacesMessage("Atualizado com sucesso!");
				return "lista-produtos"; //Retorna para a listagem
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar, tente mais tarde");
		}
		//Adicionar a mensagem para a tela exibi-la
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "produto";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
