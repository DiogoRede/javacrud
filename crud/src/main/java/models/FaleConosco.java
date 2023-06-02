package models;

public class FaleConosco {
	private String email;
	private String assunto;
	private String mensagem;
	
	public FaleConosco(String email, String assunto, String mensagem){
		setEmail(email);
		setAssunto(assunto);
		setMensagem(mensagem);
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
