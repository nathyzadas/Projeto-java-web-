package br.com.ProjetoCRUD.categoria;
import br.com.ProjetoCRUD.entidades.*;

import java.util.List;

import br.com.ProjetoCRUD.dao.*;

public class CategoriaBean {
	public  List<Categoria> listaCategoria;
	public CategoriaBean() {
		try {
			this.listaCategoria = new CategoriaDao().listar();
		}catch(Exception e) {
			System.out.println("Erro no categoria bean");
		}
	}
	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}
	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
	
}
