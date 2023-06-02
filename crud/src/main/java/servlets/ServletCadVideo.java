package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConexaoBanco;
import dao.DaoVideoRepository;
import models.Video;

@WebServlet("/cadastro/video")
public class ServletCadVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadVideo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conteudoPage = "/cadastro/cadVideo.jsp";
	    request.setAttribute("conteudoPage", conteudoPage);
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("tituloVideo").trim();
		String caminho= request.getParameter("caminhoVideo").trim();
		String descricao = request.getParameter("descricaoVideo").trim();
		
		if(titulo!=null && !titulo.isEmpty() && caminho!=null && !caminho.isEmpty() && descricao!=null && !descricao.isEmpty()) {
			Video video = new Video(titulo, caminho, descricao);
			ConexaoBanco conexao = new ConexaoBanco();
			DaoVideoRepository daoVideoRepository = new DaoVideoRepository(conexao);
			boolean cadastrou = daoVideoRepository.cadastrar(video);
			if(cadastrou) {
				request.setAttribute("alert", "Video Cadastrado com sucesso!");
			}else {
				request.setAttribute("alert", "Falha ao cadastrar o video!");
			}
		}else {
			request.setAttribute("alert", "CAMPOS VAZIOS!");
		}
		doGet(request, response);
		
	}

}
