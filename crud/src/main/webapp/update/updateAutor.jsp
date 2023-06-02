<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

	<h1>Atualizar novo autor</h1>
	
	<c:if test="${not empty alert}">
			<div class="alert alert-success  alert-dismissible fade show" role="alert">
		        ${alert}
		        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		            <span aria-hidden="true">&times;</span>
		        </button>
	    	</div>
	</c:if>
	
	<form method="POST" action="/prova2/autores">
	
	
		<input type="hidden" value="${autor.id}" name="idAutor">
		<div class="form-group">
			<label class="col-sm-2 control-label">Nome</label>
			<input name="nomeAutor" value="${autor.nome }">
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Resumo</label>
			<input name="resumoAutor" value="${autor.resumo }">
		</div>
		
		<button type="submit" class="btn btn-primary">Salvar</button>
		<a href="/prova2/autores?acao=delete&id=${autor.id}" class="btn btn-danger">Deletar</a>
		<a href="/prova2/autores" class="btn btn-primary">Voltar</a>
	</form>

</div>