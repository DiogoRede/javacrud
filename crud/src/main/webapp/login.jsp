<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="br">

<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<section class="vh-100" style="background-color: #508bfc;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            
			
            <c:if test="${not empty alert}">
				<div class="alert alert-success  alert-dismissible fade show" role="alert">
			        ${alert}
			        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			            <span aria-hidden="true">&times;</span>
			        </button>
		    	</div>
			</c:if>

			
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <form action="/prova2/login" method="post">
                    <input type="hidden" value="<%= request.getParameter("url") %>" name="url" >
                                         
                        <div class="card-body p-5 text-center">

                            <h3 class="mb-5">Login</h3>

                            <div class="form-outline mb-4">
                                <input type="text" name="nomeUsuario" class="form-control form-control-lg"
                                    placeholder="Usuario" />
                            </div>

                            <div class="form-outline mb-4">
                                <input type="password" name="senhaUsuario" class="form-control form-control-lg"
                                    placeholder="Senha" />
                            </div>

                            <button class="btn btn-primary btn-lg btn-block" type="submit">Entrar</button>

							<a href="/prova2/home" class="btn btn-primary btn-lg btn-block">Entrar como visitante</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>