<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <title>Aqui Tem</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
</head>

<body>

    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>Os melhores conteúdos estão aqui</h1>
        <p></p>
    </div>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="/prova2/home">Inicio</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/prova2/faleConosco">Fale Conosco</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/prova2/videos">Videos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/prova2/autores">Autores</a>
                </li>
                
                <c:if test="${not empty usuario}">
	                <li class="nav-item dropdown">
	                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
	                        aria-haspopup="true" aria-expanded="false">
	                        Cadastros
	                    </a>
	                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	                        <a class="dropdown-item" href="/prova2/cadastro/autor">Autores</a>
	                        <a class="dropdown-item" href="/prova2/cadastro/post">Post</a>
	                        <a class="dropdown-item" href="/prova2/cadastro/video">Video</a>
	                    </div>
	                </li>
	                
	                <li class="nav-item ">
			            <a class="nav-link" href="/prova2/login?acao=logout">Logout</a>
			        </li>
		        </c:if>
		        
		        <c:if test="${empty usuario}">
			        <li class="nav-item">
			            <a class="nav-link" href="/prova2/login">Login</a>
			        </li>
		        </c:if>
                 
            </ul>
        </div>
    </nav>

    <br>

    <div class="container" style="margin-top:30px">
        <div class="row">
        
            <jsp:include page="${conteudoPage}" />

            <br><br>
        </div>
    </div>

    <div class="jumbotron text-center" style="margin-bottom:0">
        <p>Footer</p>
    </div>

</body>

</html>
