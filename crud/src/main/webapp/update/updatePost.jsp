<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

    <h1>Atualização de postagem</h1>
    <form method="post" action="/prova2/post">
		
		<c:if test="${not empty alert}">
			<div class="alert alert-success  alert-dismissible fade show" role="alert">
		        ${alert}
		        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		            <span aria-hidden="true">&times;</span>
		        </button>
	    	</div>
		</c:if>
		
		<div class="form-group">
			<select name="autorPost">
				<c:forEach items="${autores}" var="autor">
			        <option value="${autor.id}" <c:if test="${autor.id eq post.idAutor}">selected</c:if>>${autor.nome}</option>
			    </c:forEach>
			</select>
		</div>
		
		<input type="hidden" value="${post.idPost}" name="idPost">
	
		<div class="form-group">
			<label class="col-sm-2 control-label">Titulo</label>
			<input name="tituloPost" value="${post.titulo}">
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Resumo</label>
			<input name="resumoPost" value="${post.resumo}">
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Conteudo</label>
			<input name="conteudoPost" value="${post.conteudo}">
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
		<a href="/prova2/post?id=${post.idPost}&acao=delete" class="btn btn-danger">Deletar</a>
	</form>
	
		

</div>
