package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connection.ConexaoBanco;
import models.Autor;

import java.util.ArrayList;

public class DaoAutorRepository {

	private ConexaoBanco conexao;
	
	public DaoAutorRepository(ConexaoBanco conexao) {
		setConexao(conexao);
	}
	
	public boolean deletar(int id) {
		boolean deletou = false;
		String sql = "DELETE FROM autor WHERE idautor = " + id;
		deletou = conexao.atualiza(sql);
		
		conexao.desconecta();
		return deletou;
	}
	
	public boolean atualizar(Autor autor) {
		boolean atualizou = false;
		String sql = "UPDATE autor SET nome = '" + autor.getNome() + "', resumo = '" + autor.getResumo() + "' WHERE idautor = " + autor.getId();
		atualizou = conexao.atualiza(sql);
		return atualizou;
	}
	
	public boolean cadastrar(Autor autor) {
	    String sql = "INSERT INTO autor (nome, resumo) VALUES ('" + autor.getNome() + "', '" + autor.getResumo() + "')";
	    
	    boolean cadastro = conexao.atualiza(sql);
	    
	    conexao.desconecta();
	    
	    return cadastro;
	}
	
	public Autor consultarId(int id) {
		String sql = "SELECT * FROM Autor WHERE idautor = " + id;
		Autor autor = new Autor();
		try {
			ResultSet stmt = conexao.consulta(sql);
			while(stmt.next()) {	
				autor.setId(stmt.getInt("idautor"));
				autor.setNome(stmt.getString("nome"));
				autor.setResumo(stmt.getString("resumo"));
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return autor;
	}
	
	public List<Autor> consultarAutores() {
		String sql = "SELECT * FROM AUTOR";
		List<Autor> autores = new ArrayList<Autor>();
		try {
			ResultSet stmt = conexao.consulta(sql);
			while(stmt.next()) {
				Autor autor = new Autor();
				autor.setId(stmt.getInt("idautor"));
				autor.setNome(stmt.getString("nome"));
				autor.setResumo(stmt.getString("resumo"));
				autores.add(autor);
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return autores;
	}
	
	public void setConexao(ConexaoBanco conexao) {
		this.conexao = conexao;
	}
	
}
