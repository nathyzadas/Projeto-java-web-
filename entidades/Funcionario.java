package br.com.ProjetoCRUD.entidades;

public class Funcionario {
	private int idFuncionario;
	public String nomeFuncionario;
	
	
	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}


	public Funcionario (int idFuncionario, String nomeFuncionario) {

		this.idFuncionario = idFuncionario;
		this.nomeFuncionario = nomeFuncionario;
	}

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}


}
