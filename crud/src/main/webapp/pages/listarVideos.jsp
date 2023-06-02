<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <h1 class="text-center">Videos</h1>
    <div class="row">
      <c:forEach items="${videos}" var="video">
      <div class="col-md-4">
        <div class="card mb-4">
          <div class="embed-responsive embed-responsive-16by9">
            <iframe class="embed-responsive-item" src="${video.caminho}"></iframe>
          </div>
          <div class="card-body">
            <a href="/prova2/videos?id=${video.idVideo}"><h5 class="card-title">${video.titulo}</h5></a>   
            <p class="card-text">${video.descricao}</p>
          </div>
            <c:if test="${not empty usuario}">
                <a class="btn btn-primary" href="/prova2/videos?id=${video.idVideo}&acao=update" type="submit">Editar</a>

                <a class="btn btn-danger" href="/prova2/videos?id=${video.idVideo}&acao=delete">Excluir</a>
            </c:if>
        </div>
      </div>
      </c:forEach>
    </div>
  </div>