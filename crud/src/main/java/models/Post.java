package models;

import java.util.Date;

public class Post {
	
	private int idPost;
	private int idAutor;
	private String titulo;
	private String resumo;
	private String conteudo;
	private Date dataCriacao;
	
	public Post() {
		
	}
	
	public Post(int idAutor,String titulo, String resumo, String conteudo){
		setIdAutor(idAutor);
		setTitulo(titulo);
		setResumo(resumo);
		setConteudo(conteudo);
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getResumo() {
		return resumo;
	}
	
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public int getIdAutor() {
		return idAutor;
	}
	
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date date) {
		this.dataCriacao = date;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}
	
	
	
	
}
