<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <div class="text-center">
        <h1>${video.titulo}</h1>
    </div>
    <div class="d-flex justify-content-center min-vh-100">
        <div class="embed-responsive embed-responsive-16by9">
            <iframe width="640" height="480" src="${video.caminho }" title="${video.caminho }" frameborder="0" allow="accelerometer; clipboard-write; encrypted-media; gyroscope; web-share" allowfullscreen></iframe>
        </div>
    </div>
    <div class="ml-4">
        <h3>${video.descricao }</h3>
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
            
            	<input name="idPublicacao" value="${video.idVideo}" type="hidden">
            	<input name="tipoPublicacao" value="videos" type="hidden">
            
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

