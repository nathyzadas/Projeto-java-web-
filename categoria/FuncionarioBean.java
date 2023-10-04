package br.com.ProjetoCRUD.categoria;

import java.util.List;

import br.com.ProjetoCRUD.dao.FuncionarioDao;
import br.com.ProjetoCRUD.entidades.Funcionario;

public class FuncionarioBean {
	public  List<Funcionario> listaFuncionario;
	public FuncionarioBean() {
		try {
			this.listaFuncionario = new FuncionarioDao().listar();
		}catch(Exception e) {
			System.out.println("Erro no categoria bean");
		}
	}
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}
	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	
}
