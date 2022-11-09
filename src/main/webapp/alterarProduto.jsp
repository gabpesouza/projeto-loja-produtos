<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar produto</title>
<%@ include file ="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

	<div class="container">
	<h1>Edicao de produto</h1>
		
		<form action="produto" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${produto.codigo }" name="codigo">
		
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Nome produto</label>
	    <input type="text" class="form-control" id="exampleInputEmail1" name="nome" value="${produto.nome }">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Valor do produto</label>
	    <input type="text" class="form-control" id="exampleInputPassword1" name="valor" value="${produto.valor }">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Data fabricacao</label>
	    <input type="text" class="form-control" id="exampleInputPassword1" name="data" value="<fmt:formatDate value="${produto.dataFabricacao }" pattern="dd/MM/yyyy"/>">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Quantidade</label>
	    <input type="text" class="form-control" id="exampleInputPassword1" name="quantidade" value="${produto.quantidade }">
	  </div>
	   <div class="mb-3">
	  	<label for="id-categoria" class="form-label">Categoria</label>
	  	<select name="categoria" id="id-categoria" class="form-control">
	  		<c:forEach items="${categorias }" var="cat">
	  			<option value="${cat.codigo }">${cat.nome }</option>
	  		</c:forEach>
	  	</select>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Salvar</button>
	  <a class="btn btn-danger" href="produto?acao=listar" role="button">Cancelar</a>
		</form>
	
	
	
	</div>





<%@ include file="footer.jsp" %>
</body>
</html>