package br.com.ProjetoCRUD.entidades;

public class Agendamento {
	private int idAgenda;
	public String dataAgenda;
	public String horaAgenda;
	public String nomeServico;		
	public String nomeFuncionario;
	public String nomeCliente;
	private int idServico;
	private int idCliente;
	private int idFuncionario;
	
		
	public int getIdAgenda() {
		return idAgenda;
	}
	
	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}
	
	public String getDataAgenda() {
		return dataAgenda;
	}
	
	public void setDataAgenda(String dataAgenda) {
		this.dataAgenda = dataAgenda;
	}
	
	
	public String getHoraAgenda() {
		return horaAgenda;
	}
	
	public void setHoraAgenda(String horaAgenda) {
		this.horaAgenda = horaAgenda;
	}
	
	public String getNomeServico() {
		return nomeServico;
	}
	
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
	public int getIdServico() {
		return idServico;
	}
	
	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
				
	
	public Agendamento (int idAgenda, String dataAgenda, String horaAgenda, String nomeServico, String nomeFuncionario, String nomeCliente, int idServico, int idCliente, int idFuncionario) {
		super();
		this.idAgenda = idAgenda;
		this.dataAgenda = dataAgenda;
		this.horaAgenda = horaAgenda;
		this.nomeServico = nomeServico;
		this.nomeFuncionario = nomeFuncionario;
		this.nomeCliente = nomeCliente;
		this.idServico = idServico;
		this.idCliente = idCliente;
		this.idCliente = idFuncionario;
		
		
	}
	public Agendamento() {
		
		// TODO Auto-generated constructor stub
	}
	
	

	
}
