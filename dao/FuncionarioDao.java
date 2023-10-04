package br.com.ProjetoCRUD.dao;

import br.com.ProjetoCRUD.entidades.Funcionario;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDao extends Conexao {
	public void adicionar(Funcionario funcionario) {
		String sql = "INSERT INTO `tbfuncionario`(`nomeFuncionario`) VALUES (?)";

		try {
			// prepared statement para inserção
			open();
			//System.out.println(con);
			stmt = con.prepareStatement(sql); 

			// seta os valores
			stmt.setString(1, funcionario.getNomeFuncionario());
			

			// executa
			stmt.execute();

		} catch (SQLException e) {
			System.out.println("Erro no cadastro de funcionarios" + e.getMessage());
		}finally {
			close();
		}
	}

	public List<Funcionario> listarFunconario(String nomeFuncionario) {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			open();

			stmt = this.con.prepareStatement("select nomeFuncionario from tbfuncionario");
			stmt.setString(1, nomeFuncionario + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Funcionario
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
				funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));
				
				// adicionando o objeto na lista
				funcionarios.add(funcionario);
			}

		} catch (SQLException e) {
			System.out.println("Erro em listar os funcionários " + e.getMessage());
		}finally {
			close();
		}

		return funcionarios;

	}
	
	
	public static List<Funcionario> buscarFuncionario() {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		try {
			open();
			String sql = "SELECT * FROM tbfuncionario";
			stmt = con.prepareStatement(sql);
			// Objeto que recebe a lista completa do stmt, para selecionar os dados
			rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
				funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));
				
				lista.add(funcionario);

			}

		} catch (SQLException e) {
			System.out.println("Erro em listar os funcionarios" + e.getMessage());

		}

		return lista;
	}

	public static Funcionario getElementById(String nomeFuncionario) {
		Funcionario funcionario = new Funcionario();
		try {
			String sql = "SELECT * FROM `tbfuncionario` WHERE `nomeFuncionario`=?";
			open();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nomeFuncionario);
			rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Funcionario

				funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
				funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));
				
				// adicionando o objeto na lista

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + "daoo");
		} finally {
			close();
		}
		
		return funcionario;
	}

	public  Funcionario validarFuncionario(String nomeFuncionario) {
		// TODO Auto-generated method stub
		Funcionario funcionario = new Funcionario();

		try {
			String sql = "SELECT * FROM `tbfuncionario` WHERE nomeFuncionario=? ";
			open();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nomeFuncionario);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Funcionario

				funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
				funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));
				
				// adicionando o objeto na lista

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + "daoo");
		} finally {
			close();
		}

		return funcionario;

	}
	
	public List<Funcionario> listar() {
	    List<Funcionario> funcionarios = new ArrayList<>();
	    
	    try {
	        open(); // Abre a conexão com o banco de dados
	        
	        String sql = "SELECT * FROM tbFuncionario"; // Query para selecionar os serviços
	        stmt = con.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Funcionario funcionario = new Funcionario();
	            funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
	            funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));
	            funcionarios.add(funcionario);
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao listar os serviços: " + e.getMessage());
	    } finally {
	        close(); // Fecha a conexão com o banco de dados
	    }
	    
	    return funcionarios;
	}
}
