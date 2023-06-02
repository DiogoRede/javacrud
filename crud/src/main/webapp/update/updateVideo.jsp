<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

	<h1>Atualização de Video</h1>
	
	<form method="POST" action="/prova2/videos">		
		
		<c:if test="${not empty alert}">
			<div class="alert alert-success  alert-dismissible fade show" role="alert">
		        ${alert}
		        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		            <span aria-hidden="true">&times;</span>
		        </button>
	    	</div>
		</c:if>
		
		<input type="hidden" name="idVideo" value="${video.idVideo}">
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Titulo</label>
			<input name="tituloVideo" value="${video.titulo}">
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Caminho</label>
			<input name="caminhoVideo" value="${video.caminho}">
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Descricao</label>
			<input name="descricaoVideo" value="${video.descricao}">
		</div>
		
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>

</div>