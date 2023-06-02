package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoBanco;
import models.Comentario;

public class DaoComentarioRepository {
	private ConexaoBanco conexaoBanco;
	
	public DaoComentarioRepository(ConexaoBanco conexaoBanco) {
		setConexaoBanco(conexaoBanco);
	}
	
	public List<Comentario> consultarTodos(int id, String tipoPublicacao) {
		String sql = "SELECT * FROM comentario WHERE idpublicacao = " + id + " and tipoPublicacao = '" + tipoPublicacao+"'";
		List<Comentario> comentarios = new ArrayList<Comentario>();
		try {
			ResultSet stmt = conexaoBanco.consulta(sql);
			if (stmt!=null) {
				while(stmt.next()) {	
					Comentario comentario = new Comentario();
					comentario.setIdPublicacao(stmt.getInt("idpublicacao"));
					comentario.setIdComentario(stmt.getInt("idcomentario"));
					comentario.setNome(stmt.getString("nome"));
					comentario.setMensagem(stmt.getString("mensagem"));
					comentario.setTipoPublicacao(stmt.getString("tipopublicacao"));
					java.sql.Timestamp timestamp = stmt.getTimestamp("dataCriacao");
					java.util.Date date = new java.util.Date(timestamp.getTime());
					comentario.setDataCriacao(date);
					comentarios.add(comentario);
				}
			}	
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return comentarios;
	}

	public boolean cadastrar(Comentario comentario) {
		boolean cadastrou = false;
		String sql = "INSERT INTO comentario (nome, mensagem, tipopublicacao, idpublicacao) values ('" + comentario.getNome() + "', '" + comentario.getMensagem() + "', '" + comentario.getTipoPublicacao() +  "', " + comentario.getIdPublicacao() + ")";
		cadastrou = conexaoBanco.atualiza(sql);
		
		return cadastrou;
	}
	
	public ConexaoBanco getConexaoBanco() {
		return conexaoBanco;
	}

	public void setConexaoBanco(ConexaoBanco conexaoBanco) {
		this.conexaoBanco = conexaoBanco;
	}
}
