package br.com.ProjetoCRUD.entidades;

public class Cliente {
	private int idCliente;
	public String nome;
	public String email;
	public String senha;
	public String cpf;
	public String celular;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cliente() {

	}

	public Cliente(int idCliente, String nome, String email, String senha, String cpf) {

		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
	}

}
