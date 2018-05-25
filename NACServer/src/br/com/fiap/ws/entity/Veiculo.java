package br.com.fiap.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="veiculo",sequenceName="SQ_T_VEICULO",allocationSize=1)
public class Veiculo {

	@Id
	@GeneratedValue(generator="veiculo",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	private String modelo;
	
	private int ano;
	
	private boolean utilitario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isUtilitario() {
		return utilitario;
	}

	public void setUtilitario(boolean utilitario) {
		this.utilitario = utilitario;
	}
	
	
}
