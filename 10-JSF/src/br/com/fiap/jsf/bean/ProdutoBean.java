package br.com.fiap.jsf.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import br.com.fiap.ws.to.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto;
	
	//Método que é acionado quando a tela é criada
	@PostConstruct
	private void init() {
		produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
