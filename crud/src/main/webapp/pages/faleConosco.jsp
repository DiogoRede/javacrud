<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

	<h1 class="text-center">Fale conosco</h1>
	
	<c:if test="${not empty alert}">
			<div class="alert alert-success  alert-dismissible fade show" role="alert">
		        ${alert}
		        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		            <span aria-hidden="true">&times;</span>
		        </button>
	    	</div>
	</c:if>
	
	<form method="POST" action="#">
	
		<div class="form-group">
			<label class="col-sm-2 control-label">E-mail</label>
			<input name="destinatarioFaleConosco">
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Assunto</label>
			<input name="assuntoFaleConosco">
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Mensagem</label>
			<input name="mensagemFaleConosco">
		</div>
		
		<button type="submit" class="btn btn-primary">Envio de email tirado para segurança</button>
	</form>

</div>