<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-12 shadow-sm p-3 mb-5 bg-body rounded">

	<c:if test="${not empty usuario}">
	    <a class="btn btn-success btn-lg float-right" href="/prova2/cadastro/autor">Novo Autor</a><br>
	</c:if>

    <table class="table">
        <h1>Todos autores</h1>
        <thead>
            <tr>
                <th scope="col">#ID</th>
                <th scope="col">Foto</th>
                <th scope="col">Nome</th>
                <th scope="col">Descrição</th>
                
                <c:if test="${not empty usuario}">
                	<th scope="col">Ação</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
           <c:forEach items="${autores}" var="autor">
            <tr>
                <th scope="row">${autor.id }</th>
                <td> <img src="https://miro.medium.com/v2/resize:fit:720/format:webp/1*g09N-jl7JtVjVZGcd-vL2g.jpeg" class="rounded-circle align-self-center mr-3"
                        alt="${autor.nome }" width="64" height="64"></td>
                <td>${autor.nome }</td>
                <td>${autor.resumo }</td>
                <c:if test="${not empty usuario}">
	                <td>
	                    <a class="btn btn-primary" href="/prova2/autores?id=${autor.id }">Editar </a>
	                </td>
                </c:if>
            </tr>
            </c:forEach>
        </tbody>
    </table>

</div>