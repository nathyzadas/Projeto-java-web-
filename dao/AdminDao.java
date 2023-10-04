package br.com.ProjetoCRUD.dao;

import java.sql.SQLException;

import br.com.ProjetoCRUD.entidades.*;

public class AdminDao extends Conexao {

	public Admin consultarLoginSenha(String login, String senha){
		Admin admin = null;
		try {
			open();
		String sql = "select * from admin where login = ? and senha = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);
		
		rs = stmt.executeQuery();
		
		
		
		if(rs.next()){
			admin = new Admin(rs.getString("login"), 
							  rs.getString("senha"));			
		}
		
		
		}catch(SQLException e) {
			System.out.println("Erro no Admin"+e.getMessage());
		}
		return admin;
		
	}
	
	public Admin validarCliente(String login, String senha) {
		
	    Admin admin = new Admin();

	    try {
	        String sql = "SELECT * FROM `admin` WHERE login=? AND senha=?";
	        open();
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, login);
	        stmt.setString(2, senha);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            admin = new Admin();
	            admin.setIdAdmin(rs.getInt("idAdmin"));
	            admin.setNome(rs.getString("nome"));
	            admin.setLogin(rs.getString("login"));
	            admin.setSenha(rs.getString("senha"));
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage() + "daoo");
	    } finally {
	        close();
	    }

	    return admin;
	}

}
