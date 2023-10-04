package br.com.ProjetoCRUD.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoCRUD.entidades.Servico;

public class ServicoDao extends Conexao {
	
	// Criando o método de Exclusão
		public void excluirServico(int idServico) {
			try {
				open();
				String sql = "DELETE FROM tbservico WHERE idServico = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, idServico);
				stmt.execute();

			} catch (SQLException e) {
				System.out.println("Erro em excluir os serviços" + e.getMessage());

			}

		}

		public static List<Servico> buscarServico() {
			List<Servico> lista = new ArrayList<Servico>();
			try {
				open();
				String sql = "SELECT * FROM tbservico";
				stmt = con.prepareStatement(sql);
				// Objeto que recebe a lista completa do stmt, para sele��o dos dados
				rs = stmt.executeQuery();

				while (rs.next()) {
					Servico servico = new Servico();
					servico.setIdServico(rs.getInt("idServico"));
					servico.setNomeServico(rs.getString("nomeServico"));
					servico.setFotoServico(rs.getString("fotoServico"));
					servico.setDescServico(rs.getString("descServico"));
					
					lista.add(servico);

				}

			} catch (SQLException e) {
				System.out.println("Erro em listar os serviços" + e.getMessage());

			}

			return lista;
		}

		public void insert(Servico servico) {
			// TODO Auto-generated method stub

			try {
				String sql = "INSERT INTO `tbservico`(`nomeServico`, `fotoServico`, `descServico`) VALUES (?,?,?)";
				open();
				stmt = con.prepareStatement(sql);
				stmt.setString(1, servico.getNomeServico());
				stmt.setString(2, servico.getFotoServico());
				stmt.setString(3, servico.getDescServico());
				stmt.execute();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage() + "daoooooo");
			}
		}

		public List<Servico> listar() {
		    List<Servico> servicos = new ArrayList<>();
		    
		    try {
		        open(); // Abre a conexão com o banco de dados
		        
		        String sql = "SELECT * FROM tbServico"; // Query para selecionar os serviços
		        stmt = con.prepareStatement(sql);
		        rs = stmt.executeQuery();
		        
		        while (rs.next()) {
		            Servico servico = new Servico();
		            servico.setIdServico(rs.getInt("idServico"));
		            servico.setNomeServico(rs.getString("nomeServico"));
		            servico.setFotoServico(rs.getString("fotoServico"));
		            servico.setDescServico(rs.getString("descServico"));
		            servicos.add(servico);
		        }
		    } catch (SQLException e) {
		        System.out.println("Erro ao listar os serviços: " + e.getMessage());
		    } finally {
		        close(); // Fecha a conexão com o banco de dados
		    }
		    
		    return servicos;
		}


}
