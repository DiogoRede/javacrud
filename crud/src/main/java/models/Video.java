package models;

public class Video {
	private int idVideo;
	public int getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}
	private String titulo;
	private String caminho;
	private String descricao;
	
	public Video() {
		
	}
	
	public Video(String titulo, String caminho, String descricao) {
		setTitulo(titulo);
		setCaminho(caminho);
		setDescricao(descricao);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
