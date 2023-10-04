package br.com.ProjetoCRUD.entidades;

public class Admin {
	private int idAdmin;
	private String nome;
	private String login;
	private String senha;
	
	public Admin() {
		
	}

	public Admin(String login, String senha) {
		super();		
		this.login = login;
		this.senha = senha;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
