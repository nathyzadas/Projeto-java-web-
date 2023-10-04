package br.com.ProjetoCRUD.categoria;

import java.util.List;

import br.com.ProjetoCRUD.dao.ServicoDao;
import br.com.ProjetoCRUD.entidades.Servico;

public class ServicoBean {
	public  List<Servico> listaServico;
	public ServicoBean() {
		try {
			this.listaServico = new ServicoDao().listar();
		}catch(Exception e) {
			System.out.println("Erro no categoria bean");
		}
	}
	public List<Servico> getListaServico() {
		return listaServico;
	}
	public void setListaServico(List<Servico> listaServico) {
		this.listaServico = listaServico;
	}
}
