package br.com.ProjetoCRUD.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoCRUD.entidades.Agendamento;

public class AgendamentoDao extends Conexao {

	public void insert(Agendamento agendamento) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `tbagenda`(`idAgenda`,`dataAgenda`, `horaAgenda`, `nomeServico`, `nomeFuncionario`,`nomeCliente` `idCliente`, `idServico`, `idFuncionario`) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			open();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, agendamento.getIdAgenda());
			stmt.setString(2, agendamento.getDataAgenda());
			stmt.setString(3, agendamento.getHoraAgenda());
			stmt.setString(4, agendamento.getNomeServico());
			stmt.setString(5, agendamento.getNomeFuncionario());
			stmt.setString(6, agendamento.getNomeCliente());
			stmt.setInt(7, agendamento.getIdCliente());
			stmt.setInt(8, agendamento.getIdServico());
			stmt.setInt(9, agendamento.getIdFuncionario());

			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error dao " + e.getMessage());
		}

	}

	public static List<Agendamento> selectAgendamento() {
		List<Agendamento> lista = new ArrayList<Agendamento>();
		try {
			open();
			String sql = "SELECT * FROM tbagenda";

			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Agendamento agendamento = new Agendamento();
				agendamento.setIdAgenda(rs.getInt("idAgenda"));
				agendamento.setDataAgenda(rs.getString("dataAgenda"));
				agendamento.setHoraAgenda(rs.getString("horaAgenda"));
				agendamento.setNomeServico(rs.getString("nomeServico"));				
				agendamento.setNomeFuncionario(rs.getString("nomeFuncionario"));
				agendamento.setNomeCliente(rs.getString("nomeCliente"));
				agendamento.setIdServico(rs.getInt("idServico"));
				agendamento.setIdCliente(rs.getInt("idCliente"));
				agendamento.setIdFuncionario(rs.getInt("idFuncionario"));
				
				

				lista.add(agendamento);
				System.out.println(agendamento.getDataAgenda());
			}

		} catch (Exception e) {

			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return lista;

	}
	
	public List<Agendamento> getAgendamentos() {
        List<Agendamento> agendamentos = new ArrayList<>();

        try {
            String query = "SELECT c.nome AS nome_cliente, s.nome AS nome_servico, f.nome AS nome_funcionario" +
                           " FROM agendamento a" +
                           " INNER JOIN cliente c ON a.id_cliente = c.id" +
                           " INNER JOIN servico s ON a.id_servico = s.id" +
                           " INNER JOIN funcionario f ON a.id_funcionario = f.id";

            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nomeCliente = resultSet.getString("nome_cliente");
                String nomeServico = resultSet.getString("nome_servico");
                String nomeFuncionario = resultSet.getString("nome_funcionario");

                Agendamento agendamento = new Agendamento(0, nomeCliente, nomeServico, nomeFuncionario, nomeFuncionario, nomeFuncionario, 0, 0, 0);
                agendamentos.add(agendamento);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            // Tratar exceções
            e.printStackTrace();
        }

        return agendamentos;
    }

}
