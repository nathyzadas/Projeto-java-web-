package br.com.ProjetoCRUD.entidades;

public class Contato {
	private int idContato;
	public String emailContato;
	public String textoContato;
	
	
	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getTextoContato() {
		return textoContato;
	}

	public void setTextoContato(String textoContato) {
		this.textoContato = textoContato;
	}

	
	public Contato(String emailContato, String textoContato) {
		super();

		this.emailContato = emailContato;
		this.textoContato = textoContato;
	}

	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}
}
