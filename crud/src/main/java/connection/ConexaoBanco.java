package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {
	
	private static Connection con;
	private Statement stmt;
	private boolean erro;
	private String msg;
	private String banco = "jdbc:mysql://localhost:3306/prova2?autoReconnect=true&characterEncoding=UTF-8", usuario = "root", senha = "root";
	
	public ConexaoBanco() {
		conectarDB();
	}
	
	public static Connection getConnection() {
		return con;
	}

	public boolean conectarDB() {
		this.erro = false;
		// define o driver jdbc de conexao.

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(this.banco, this.usuario, this.senha);
			// con.setAutoCommit(true);
			stmt = con.createStatement();
		} catch ( SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			this.erro = true;
			this.msg = "Falha na conexao com o banco de dados.\n" + e.getMessage();
		}
		return erro;
	}
	
	public ResultSet consulta(String sql) {
		ResultSet objRes = null;
		
		this.erro = false;
		this.msg = "Sucesso na execucao da consulta";
		
		try {
			objRes = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			this.erro = true;
			this.msg = "Erro na execucao da consulta.\n" + e.getMessage();
		}
		
		return objRes;	
	}

	public boolean atualiza(String sql) {	
		int i = -1;

		this.erro = false;

		try {
			i = stmt.executeUpdate(sql);
			System.out.println(i);
		} catch (SQLException e) {
			this.erro = true;
			this.msg = "Falha na operacao.\n" + e.getMessage();
		}
		return !erro;
	}

	public boolean desconecta() {
		boolean sucesso = true;
		try {
			stmt.close();
		} catch (SQLException e) {
			sucesso = false;
		}
		return sucesso;
	}

	public boolean ocorreuErro() {
		return this.erro;
	}
	
	public String mensagem() {
		return this.msg;
	}
	
}