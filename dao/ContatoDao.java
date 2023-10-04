package br.com.ProjetoCRUD.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoCRUD.entidades.Contato;
import br.com.ProjetoCRUD.entidades.Produto;

public class ContatoDao extends Conexao {
	
	// Criando o método de Exclusão
		public void excluirMensagem(int idContato) {
			try {
				open();
				String sql = "DELETE FROM tbcontato WHERE idContato = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, idContato);
				stmt.execute();

			} catch (SQLException e) {
				System.out.println("Erro em excluir a mensagem" + e.getMessage());

			}

		}

		public static List<Contato> buscarMensagem() {
			List<Contato> lista = new ArrayList<Contato>();
			try {
				open();
				String sql = "SELECT * FROM tbcontato";
				stmt = con.prepareStatement(sql);
				// Objeto que recebe a lista completa do stmt, para sele��o dos dados
				rs = stmt.executeQuery();

				while (rs.next()) {
					Contato contato = new Contato();
					contato.setIdContato(rs.getInt("idContato"));
					contato.setEmailContato(rs.getString("emailContato"));
					contato.setTextoContato(rs.getString("textoContato"));
					
					lista.add(contato);

				}

			} catch (SQLException e) {
				System.out.println("Erro em listar as mensagens" + e.getMessage());

			}

			return lista;
		}
		
		public void insert(Contato contato) {
			// TODO Auto-generated method stub

			try {
				String sql = "INSERT INTO `tbcontato`(`emailContato`, `textoContato`) VALUES (?,?)";
				open();
				stmt = con.prepareStatement(sql);
				stmt.setString(1, contato.getEmailContato());
				stmt.setString(2, contato.getTextoContato());
				stmt.execute();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage() + "daoooooo");
			}
		}
}