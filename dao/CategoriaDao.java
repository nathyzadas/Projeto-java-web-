package br.com.ProjetoCRUD.dao;
import java.util.*;
import br.com.ProjetoCRUD.entidades.*;

public class CategoriaDao extends Conexao {
	public List<Categoria> listar(){		
		open();
		List <Categoria> lista = new ArrayList<Categoria>();
		try {
			String sql = "select * from categoria";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Categoria cat = new Categoria();
				cat.setIdCategoria(rs.getInt("idCategoria"));
				cat.setNomeCategoria(rs.getString("nomeCategoria"));
				lista.add(cat);
			}
		}catch(Exception e) {
			System.out.println("Erro no listar categoria");
		}
		return lista;		
	}
}