package br.com.fiap.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean //CUIDADO COM O IMPORT!!
public class LoginBean {

	private String usuario;
	
	private String senha;
	
	public void validarLogin() {
		if (usuario.equals("FIAP") 
						&& senha.equals("FIAP2018")) {
			System.out.println("Logado!");
		}else {
			System.out.println("Usuário e senha inválidos");
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
