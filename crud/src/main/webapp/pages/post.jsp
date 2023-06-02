<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:if test="${not empty usuario}">
	<div class="col-sm-offset-2 col-sm-10">
	    <a href="/prova2/post?id=${post.idPost}&acao=update">
	        <button type="submit" class="btn btn-primary">Editar</button>
	    </a>
	</div>
</c:if>

<c:if test="${not empty alert}">
	<div class="alert alert-success  alert-dismissible fade show" role="alert">
        ${alert}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
   	</div>
</c:if>

<div class="container">
    <div class="col-sm-12">
        <h2>${post.titulo}</h2>
        <h5><fmt:formatDate value="${post.dataCriacao}" pattern="dd, MMM yyyy" /></h5>
        <p>${post.conteudo}</p>
    </div>

    <div class="container">
        <div class="row justify-content-md-center">
            <div class="media col-sm-10" style="margin-top: 80px; margin-bottom: 80px;">
            <img src="https://miro.medium.com/v2/resize:fit:720/format:webp/1*g09N-jl7JtVjVZGcd-vL2g.jpeg" class="rounded-circle align-self-center mr-3"
                    alt="foto padrao" width="128" height="128">
                <div class="media-body">
                    <h5 class="mt-0">${autor.nome}</h5>
                    ${autor.resumo}
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <button class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target=".bd-example-modal-xl">Adicionar
        Comentario</button>
</div>

<div class="modal fade bd-example-modal-xl" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel"
    aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <form method="post" class="form-horizontal" action="/prova2/post/comentario">
            
            	<input name="idPublicacao" value="${post.idPost}" type="hidden">
            	<input name="tipoPublicacao" value="post" type="hidden">
            
                <div class="form-group">
					<label class="col-sm-2 control-label" required>Nome</label>
					<input name="nomeComentario">
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label" required>Mensagem</label>
					<input name="mensagemComentario">
				</div>
				

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </div>
                
            </form>
        </div>
    </div>
</div>

<div class="container">
    <div class="row justify-content-md-center">
    	
        <c:forEach items="${comentarios}" var="comentario">
	        <div class="col-sm-8">
	            <div class="card">
	                <div class="card-body">
	                    <h5 class="card-title">${comentario.nome}</h5>
	                    <p class="card-text">${comentario.mensagem }</p>
	                    <p class="text-muted"> Data: <fmt:formatDate value="${comentario.dataCriacao}" pattern="dd, MMM yyyy" /></p>
	                    <div>
	                        <c:if test="">
		                        <a href="#">
		                            <button type="submit" class="btn btn-primary">Editar</button>
		                        </a>
		
		                        <a class="btn btn-danger"
		                            href="#">Excluir</a>
	                        </c:if>
	                    </div>
	                </div>
	            </div>
	        </div>
        </c:forEach>
    </div>
</div>
