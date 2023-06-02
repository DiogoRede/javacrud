package models;

import java.io.Serializable;

import javax.servlet.http.Part;

public class Autor implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	
	private String nome;
	private String resumo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Autor() {
		
	}
	
	public Autor(String nome, String resumo) {
		setNome(nome);
		setResumo(resumo);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
}
