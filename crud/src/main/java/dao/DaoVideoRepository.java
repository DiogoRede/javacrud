package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoBanco;
import models.Video;

public class DaoVideoRepository {
	private ConexaoBanco conexao;
	
	public DaoVideoRepository(ConexaoBanco conexao) {
		setConexao(conexao);
	}
	
	public boolean atualizar(Video video) {
		boolean atualizou = false;
		String sql = "UPDATE video SET titulo = '" + video.getTitulo() + "', caminho = '" + video.getCaminho() + "', descricao = '" + video.getDescricao() + "' WHERE idvideo = " + video.getIdVideo();
		atualizou = conexao.atualiza(sql);
		System.out.println(sql);
		return atualizou;
	}
	
	public boolean deletar(int id) {
		boolean apagou = false;
		
		String sql = "DELETE FROM video WHERE idvideo = " + id;
		
		apagou = conexao.atualiza(sql);
		
		return apagou;
	}
	
	public boolean cadastrar(Video video) {
		boolean cadastrou = false;
		String sql = "INSERT INTO video (titulo, caminho, descricao) VALUES ('" + video.getTitulo() + "', '" + video.getCaminho() + "', '" + video.getDescricao() + "')";
		cadastrou = conexao.atualiza(sql);
		
		return cadastrou;
	}

	public ConexaoBanco getConexao() {
		return conexao;
	}

	public void setConexao(ConexaoBanco conexao) {
		this.conexao = conexao;
	}
	
	public Video consultarId(int id) {
		String sql = "SELECT * FROM video WHERE idvideo = " + id;
		Video video = new Video();
		try {
			ResultSet stmt = conexao.consulta(sql);
			while(stmt.next()) {	
				video.setIdVideo(stmt.getInt("idvideo"));
				video.setTitulo(stmt.getString("titulo"));
				video.setCaminho(stmt.getString("caminho"));
				video.setDescricao(stmt.getString("descricao"));
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return video;
	}
	
	public List<Video> consultaHome(){
		String sql = "SELECT * FROM video ORDER BY idvideo DESC LIMIT 3";
		List<Video> videos = new ArrayList<Video>();
		try {
			ResultSet stmt = conexao.consulta(sql);
			if (stmt!=null) {
				while(stmt.next()) {	
					Video video = new Video();
					video.setTitulo(stmt.getString("titulo"));
					video.setCaminho(stmt.getString("caminho"));
					video.setDescricao(stmt.getString("descricao"));
					videos.add(video);
				}
			}	
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return videos;
	}
	
	public List<Video> consultaTodos(){
		String sql = "SELECT * FROM video";
		List<Video> videos = new ArrayList<Video>();
		try {
			ResultSet stmt = conexao.consulta(sql);
			if (stmt!=null) {
				while(stmt.next()) {	
					Video video = new Video();
					video.setIdVideo(stmt.getInt("idvideo"));
					video.setTitulo(stmt.getString("titulo"));
					video.setCaminho(stmt.getString("caminho"));
					video.setDescricao(stmt.getString("descricao"));
					videos.add(video);
				}
			}	
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return videos;
	}
	
	
}
