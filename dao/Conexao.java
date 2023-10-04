package br.com.ProjetoCRUD.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.*;

public   class Conexao {
	protected static PreparedStatement stmt;// linguagem sql
	protected static ResultSet rs; // atingir o banco
	protected static Connection con;// conexão

	private final static String url = "jdbc:mysql://localhost:3306/fourbarber";
	private final static String user = "root";
	private final static String pass = "";

	protected static void open() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			
			if (con != null) {
				System.out.println("Conectouuuu!!!");
			} else {
				System.out.println("Não Conectouuuu!!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
}