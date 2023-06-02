<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid px-0">
    <div id="videos" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner bg-info" role="listbox">

            <c:forEach items="${videos}" var="video" varStatus="loop">
	            <div class="carousel-item ${loop.first ? 'active' : ''}">
	                <div class="d-flex justify-content-center min-vh-100">
	                    <div class="embed-responsive embed-responsive-16by9">
	                        <iframe width="640" height="480" src="${video.caminho}" title="${video.titulo}" frameborder="0" allow="accelerometer; clipboard-write; encrypted-media; gyroscope; web-share" allowfullscreen></iframe>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
        </div>
        <a class="carousel-control-prev" href="#videos" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon bg-dark rounded-circle p-2 shadow d-block" aria-hidden="true"></span>
            <span class="sr-only">Anterior</span>
        </a>
        <a class="carousel-control-next" href="#videos" role="button" data-slide="next">
            <span class="carousel-control-next-icon bg-dark rounded-circle p-2 shadow d-block" aria-hidden="true"></span>
            <span class="sr-only">Proximo</span>
        </a>
    </div>
</div>

<c:forEach items="${posts}" var="post">
    <div class="col-sm-6 shadow-sm p-3 mb-5 bg-body rounded">
        <h2>
            <a href="/prova2/post?id=${post.idPost}">${post.titulo}</a>
        </h2>
        <h5><fmt:formatDate value="${post.dataCriacao}" pattern="dd/MM/yyyy" /></h5>
        <p>${post.resumo}</p>
    </div>
</c:forEach>