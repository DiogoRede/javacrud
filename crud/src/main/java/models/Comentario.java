package models;

import java.util.Date;

public class Comentario {
	private int idComentario;
	private int idPublicacao;
	private Date dataCriacao;
	private String nome, mensagem, tipoPublicacao;
	
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public int getIdPublicacao() {
		return idPublicacao;
	}
	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getTipoPublicacao() {
		return tipoPublicacao;
	}
	public void setTipoPublicacao(String tipoPublicacao) {
		this.tipoPublicacao = tipoPublicacao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
}
