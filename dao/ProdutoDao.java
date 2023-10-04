package br.com.ProjetoCRUD.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoCRUD.entidades.*;

public class ProdutoDao extends Conexao {
	/*public void cadastrarProduto(Produto produto) {
		try {
			open();
			String sql = "insert into produto(nomeProduto,estoque,preco,idCategoria) " + "values (?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setInt(2, produto.getEstoque());
			stmt.setDouble(3, produto.getPreco());
			// inserção da FK
			stmt.setInt(4, produto.getCategoria().getIdCategoria());
			stmt.execute();

		} catch (Exception e) {
			System.out.println("Erro no inserir DAO");
		}
	}

	/* códigos novos */
	// Criando o método de Atualizaçãoo Dao
	/*public void atualizarProduto(Produto produto) throws SQLException {
		try {
			open();
			String sql = "UPDATE produto set nomeProduto = ?, estoque = ?, preco = ?,"
					+ " idCategoria = ? where idProduto = ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setInt(2, produto.getEstoque());
			stmt.setDouble(3, produto.getPreco());
			stmt.setInt(4, produto.getCategoria().getIdCategoria());
			stmt.setInt(4, produto.getIdProduto());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro em atualizar os produtos" + e.getMessage());

		}
	}
*/
	// Criando o método de Exclusão
	public void excluirProduto(int idProduto) {
		try {
			open();
			String sql = "DELETE FROM tbproduto WHERE idProduto = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idProduto);
			stmt.execute();

		} catch (SQLException e) {
			System.out.println("Erro em excluir os produtos" + e.getMessage());

		}

	}

	public static List<Produto> buscarProduto() {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			open();
			String sql = "SELECT * FROM tbproduto";
			stmt = con.prepareStatement(sql);
			// Objeto que recebe a lista completa do stmt, para sele��o dos dados
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setDescricao(rs.getString("descProduto"));
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setNomeProduto(rs.getString("nomeProduto"));
				produto.setImage(rs.getString("fotoProduto"));
				lista.add(produto);

			}

		} catch (SQLException e) {
			System.out.println("Erro em listar os produtos" + e.getMessage());

		}

		return lista;
	}

	public void insert(Produto produto) {
		// TODO Auto-generated method stub

		try {
			String sql = "INSERT INTO `tbproduto`(`nomeProduto`, `descProduto`, `fotoProduto`) VALUES (?,?,?)";
			open();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getImage());
			stmt.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + "daoooooo");
		}
	}
	
	public List<Produto> listar() {
	    List<Produto> produtos = new ArrayList<>();
	    
	    try {
	        open(); // Abre a conexão com o banco de dados
	        
	        String sql = "SELECT * FROM tbProduto"; // Query para selecionar os serviços
	        stmt = con.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Produto produto = new Produto();
	            produto.setIdProduto(rs.getInt("idProduto"));
	            produto.setNomeProduto(rs.getString("nomeProduto"));
	            produto.setImage(rs.getString("fotoProduto"));
	            produto.setDescricao(rs.getString("descProduto"));
	            produtos.add(produto);
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao listar os produtos: " + e.getMessage());
	    } finally {
	        close(); // Fecha a conexão com o banco de dados
	    }
	    
	    return produtos;
	}

}