package br.com.ProjetoCRUD.dao;

import br.com.ProjetoCRUD.entidades.Cliente;
import br.com.ProjetoCRUD.entidades.Produto;
import br.com.ProjetoCRUD.entidades.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDao extends Conexao {
	public void adicionar(Cliente cliente) {
		String sql = "INSERT INTO `tbcliente`(`nomeCliente`, `cpfCliente`, `celularCliente`, `emailCliente`, `senha`) VALUES (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			open();
			//System.out.println(con);
			stmt = con.prepareStatement(sql); 

			// seta os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getCelular());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getSenha());

			// executa
			stmt.execute();

		} catch (SQLException e) {
			System.out.println("Erro no cadastro de clientes" + e.getMessage());
		}finally {
			close();
		}
	}

	public List<Cliente> listarCliente(String nome) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			open();

			stmt = this.con.prepareStatement("select * from cliente where nomeCliente like ?");
			stmt.setString(1, nome + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Cliente
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nomeCliente"));
				cliente.setCelular(rs.getString("celularCliente"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setCpf(rs.getString("cpf"));

				// adicionando o objeto na lista
				clientes.add(cliente);
			}

		} catch (SQLException e) {
			System.out.println("Erro em listar os clientes " + e.getMessage());
		}finally {
			close();
		}

		return clientes;

	}
	
	
	public static List<Cliente> buscarCliente() {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			open();
			String sql = "SELECT * FROM tbcliente";
			stmt = con.prepareStatement(sql);
			// Objeto que recebe a lista completa do stmt, para selecionar os dados
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nomeCliente"));
				cliente.setCelular(rs.getString("celularCliente"));
				cliente.setEmail(rs.getString("emailCliente"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setCpf(rs.getString("cpfCliente"));
				lista.add(cliente);

			}

		} catch (SQLException e) {
			System.out.println("Erro em listar os clientes" + e.getMessage());

		}

		return lista;
	}

	public static Cliente getElementById(String email) {
		Cliente cliente = new Cliente();
		try {
			String sql = "SELECT * FROM `tbcliente` WHERE `emailCliente`=?";
			open();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Cliente

				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nomeCliente"));
				cliente.setEmail(rs.getString("emailCliente"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setCpf(rs.getString("cpfCliente"));
				cliente.setCelular(rs.getString("celularCliente"));
				// adicionando o objeto na lista

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + "daoo");
		} finally {
			close();
		}
		
		return cliente;
	}

	public  Cliente validarCliente(String email, String senha) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();

		try {
			String sql = "SELECT * FROM `tbcliente` WHERE emailCliente=? AND senha=?";
			open();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Cliente

				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nomeCliente"));
				cliente.setEmail(rs.getString("emailCliente"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setCpf(rs.getString("cpfCliente"));
				cliente.setCelular(rs.getString("celularCliente"));
				// adicionando o objeto na lista

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage() + "daoo");
		} finally {
			close();
		}

		return cliente;

	}
	
	public List<Cliente> listar() {
	    List<Cliente> clientes = new ArrayList<>();
	    
	    try {
	        open(); // Abre a conexão com o banco de dados
	        
	        String sql = "SELECT * FROM tbCliente"; // Query para selecionar os serviços
	        stmt = con.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Cliente cliente = new Cliente();
	            cliente.setIdCliente(rs.getInt("idCliente"));
	            cliente.setNome(rs.getString("nomeCliente"));
	            clientes.add(cliente);
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao listar os serviços: " + e.getMessage());
	    } finally {
	        close(); // Fecha a conexão com o banco de dados
	    }
	    
	    return clientes;
	}
}
