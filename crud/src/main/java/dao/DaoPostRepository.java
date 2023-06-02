package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.protobuf.Timestamp;

import connection.ConexaoBanco;
import models.Post;

public class DaoPostRepository {

	private ConexaoBanco conexao;
	
	public DaoPostRepository(ConexaoBanco conexao) {
		setConexao(conexao);
	}

	public boolean deletar(int id) {
        String sql = "DELETE FROM post WHERE idpost = " + id;
        boolean excluido = conexao.atualiza(sql);
        return excluido;
    }
	
	public boolean atualizar(Post post) {
		String sql = "UPDATE post SET idautor = " + post.getIdAutor() + ", titulo = '" + post.getTitulo() + "', resumo = '" + post.getResumo() + "', conteudo = '" + post.getConteudo() + "' WHERE idpost = " + post.getIdPost();
		boolean atualizado = conexao.atualiza(sql);
		
		return atualizado;
	}
	
	
	public boolean cadastrar(Post post) {
		String sql = "INSERT INTO post (idautor, titulo, resumo, conteudo) VALUES (" + post.getIdAutor() + ", '" + post.getTitulo() + "', '" + post.getResumo() + "', '" + post.getConteudo() + "')";
		boolean cadastro = conexao.atualiza(sql);
		
		return cadastro;
	}
	
	public Post consultarId(int id) {
		String sql = "SELECT * FROM post WHERE idpost = " + id;
		Post post = new Post();
		try {
			ResultSet stmt = conexao.consulta(sql);
			while(stmt.next()) {	
				post.setIdPost(stmt.getInt("idpost"));
				post.setIdAutor(stmt.getInt("idautor"));
				post.setTitulo(stmt.getString("titulo"));
				post.setConteudo(stmt.getString("conteudo"));
				post.setResumo(stmt.getString("resumo"));
				java.sql.Timestamp timestamp = stmt.getTimestamp("dataCriacao");
				java.util.Date date = new java.util.Date(timestamp.getTime());
				post.setDataCriacao(date);
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return post;
	}
	
	public List<Post> consultarTodos(){
		String sql = "SELECT * FROM post";
		List<Post> posts = new ArrayList<Post>();
		try {
			ResultSet stmt = conexao.consulta(sql);
			while(stmt.next()) {
				Post post = new Post();
				post.setIdPost(stmt.getInt("idpost"));
				post.setTitulo(stmt.getString("titulo"));
				post.setResumo(stmt.getString("resumo"));
				java.sql.Timestamp timestamp = stmt.getTimestamp("dataCriacao");
				java.util.Date date = new java.util.Date(timestamp.getTime());
				post.setDataCriacao(date);
				posts.add(post);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return posts;
	}
	
	public ConexaoBanco getConexao() {
		return conexao;
	}

	public void setConexao(ConexaoBanco conexao) {
		this.conexao = conexao;
	}
	
}
