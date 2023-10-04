package br.com.ProjetoCRUD.categoria;

import java.util.List;

import br.com.ProjetoCRUD.dao.ClienteDao;
import br.com.ProjetoCRUD.entidades.Cliente;

public class ClienteBean {
	public  List<Cliente> listaCliente;
	public ClienteBean() {
		try {
			this.listaCliente = new ClienteDao().listar();
		}catch(Exception e) {
			System.out.println("Erro no categoria bean");
		}
	}
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
}
