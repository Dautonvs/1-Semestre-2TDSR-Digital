package br.com.fiap.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUTO")
@SequenceGenerator(name="produto",sequenceName="SQ_T_PRODUTO",allocationSize=1)
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator="produto",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_produto",nullable=false)
	private String nome;
	
	@Column(name="vl_produto")
	private double preco;
	
	@Column(name="st_disponivel")
	private boolean disponivel;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
}