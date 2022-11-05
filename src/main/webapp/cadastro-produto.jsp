<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %>
<meta charset="UTF-8">
<title>Cadastro produto</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	
	
	<div class="container">
	<h1>Cadastro do produto</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-success" role="alert">
 			${msg }
		</div>
	</c:if>
	<c:if test="${not empty error }">
		<div class="alert alert-danger" role="alert">
 			${error }
		</div>
	</c:if>
	
	<form action="produto" method="post">
	  <div class="mb-3">
	  	<input type="hidden" name="acao" value="cadastrar">
	    <label for="exampleInputEmail1" class="form-label">Nome produto</label>
	    <input type="text" class="form-control" id="exampleInputEmail1" name="nome">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Valor do produto</label>
	    <input type="text" class="form-control" id="exampleInputPassword1" name="valor">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Data fabricacao</label>
	    <input type="text" class="form-control" id="exampleInputPassword1" name="data">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Quantidade</label>
	    <input type="text" class="form-control" id="exampleInputPassword1" name="quantidade">
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Cadastrar</button>
	</form>
	</div>

	

<%@ include file="footer.jsp" %>
</body>
</html>