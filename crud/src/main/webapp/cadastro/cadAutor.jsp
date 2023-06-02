<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

	<h1>Cadastrar novo autor</h1>
	
	<c:if test="${not empty alert}">
			<div class="alert alert-success  alert-dismissible fade show" role="alert">
		        ${alert}
		        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		            <span aria-hidden="true">&times;</span>
		        </button>
	    	</div>
	</c:if>
	
	<form method="POST" action="/prova2/cadastro/autor">
	
		<div class="form-group">
			<label class="col-sm-2 control-label">Nome</label>
			<input name="nomeAutor">
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Resumo</label>
			<input name="resumoAutor">
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</div>