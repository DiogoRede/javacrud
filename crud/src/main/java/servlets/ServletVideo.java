package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConexaoBanco;
import dao.DaoComentarioRepository;
import dao.DaoVideoRepository;
import models.Video;

@WebServlet("/videos")
public class ServletVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletVideo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConexaoBanco conexao = new ConexaoBanco();
		DaoVideoRepository daoVideoRepository = new DaoVideoRepository(conexao);  
		
		String conteudoPage = "/pages/listarVideos.jsp";
	    String acao = request.getParameter("acao");
	    String idVideo = request.getParameter("id");
	    
	    if(request.getSession().getAttribute("usuario")!=null && acao!=null && !acao.isEmpty()) {    		
	    	if(idVideo!=null && !idVideo.isEmpty()) {
	    		if(acao.equalsIgnoreCase("update")) {
		    		conteudoPage = "/update/updateVideo.jsp";
		    		request.setAttribute("video", daoVideoRepository.consultarId(Integer.parseInt(idVideo)));
		    	}else if(acao.equalsIgnoreCase("delete")) {
		    		daoVideoRepository.deletar(Integer.parseInt(idVideo));
		    	}
	    	}	    	
	    }else if(idVideo!=null && !idVideo.isEmpty()) {
	    	conteudoPage = "/pages/video.jsp";
	    	request.setAttribute("video", daoVideoRepository.consultarId(Integer.parseInt(idVideo)));
	    	DaoComentarioRepository daoComentarioRepository = new DaoComentarioRepository(conexao);
	    	request.setAttribute("comentarios", daoComentarioRepository.consultarTodos(Integer.parseInt(idVideo), "videos"));
	    }
	    
	    request.setAttribute("conteudoPage", conteudoPage);
	    
	    List<Video> videos = daoVideoRepository.consultaTodos();
	    request.setAttribute("videos", videos);
	    
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("tituloVideo");
		String caminho= request.getParameter("caminhoVideo");
		String descricao=request.getParameter("descricaoVideo");
		String idVideo = request.getParameter("idVideo");
		Video video = new Video();
		
		if(idVideo!=null && !idVideo.isEmpty() && titulo!=null && !titulo.isEmpty() && caminho!=null && !caminho.isEmpty() && descricao!=null && !descricao.isEmpty()) {
			video.setIdVideo(Integer.parseInt(idVideo));
			video.setTitulo(titulo);
			video.setCaminho(caminho);
			video.setDescricao(descricao);
			ConexaoBanco conexao = new ConexaoBanco();
			DaoVideoRepository daoVideoRepository = new DaoVideoRepository(conexao);
			boolean atualizou = daoVideoRepository.atualizar(video);
			if(atualizou) {
				request.setAttribute("alert", "Atulização feita com sucesso!");
			}else {
				request.setAttribute("alert", "Ocorreu um erro na atualização!");
			}
		}else {
			request.setAttribute("alert", "CAMPOS VAZIOS");
		}
		String conteudoPage = "/update/updateVideo.jsp";
		request.setAttribute("conteudoPage", conteudoPage);
		
		RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

}
