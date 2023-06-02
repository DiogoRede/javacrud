package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import connection.ConexaoBanco;
import models.Login;

public class DaoLoginRepository {
	private ConexaoBanco conexao;
	private Connection connection;
	
	public DaoLoginRepository() {
		conexao = new ConexaoBanco();
		connection = ConexaoBanco.getConnection();
	}
	
	public boolean verificarLogin(Login login){
		String sql = "SELECT * FROM LOGIN WHERE nome = ? and senha = ?";

		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, login.getLogin());
			stmt.setString(2, login.getSenha());
			ResultSet resultSet = stmt.executeQuery();
			
			if(resultSet.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		conexao.desconecta();
		return false;
	}

}
