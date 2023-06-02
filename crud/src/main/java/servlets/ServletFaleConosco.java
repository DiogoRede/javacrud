package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFaleConoscoRepository;
import models.FaleConosco;

@WebServlet("/faleConosco")
public class ServletFaleConosco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFaleConosco() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conteudoPage = "/pages/faleConosco.jsp";
	    request.setAttribute("conteudoPage", conteudoPage);
	    
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinatario = request.getParameter("destinatarioFaleConosco");
		String assunto = request.getParameter("assuntoFaleConosco");
		String mensagem= request.getParameter("mensagemFaleConosco");
		
		if (destinatario!=null && !destinatario.isEmpty() && assunto!=null && !assunto.isEmpty() && mensagem!=null && !mensagem.isEmpty()) {
			FaleConosco faleConosco = new FaleConosco(destinatario, assunto, mensagem);
			DaoFaleConoscoRepository daoFaleConosco = new DaoFaleConoscoRepository(faleConosco);
			boolean enviou = daoFaleConosco.enviarEmail();
			if(enviou) {
				request.setAttribute("alert", "Email enviado com sucesso!");
			}else {
				request.setAttribute("alert", "Falha ao enviar email!");
			}
		}else {
			request.setAttribute("alert", "CAMPOS VAZIOS");
		}
		
		
		String conteudoPage = "/pages/faleConosco.jsp";
	    request.setAttribute("conteudoPage", conteudoPage);
	    
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

}
