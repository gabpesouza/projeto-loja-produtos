<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
</head>
<body>
<%@ include file="menu.jsp" %>

	
			
			
			<div class="container">
			<c:if test="${not empty msgRemocao }">
					<div class="alert alert-success" role="alert">
 						${msgRemocao }
					</div>
			</c:if>
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
			
			 <table class="table table-striped">
				  <thead>
				    <tr>
				      <th scope="col">Nome</th>
				      <th scope="col">Valor</th>
				      <th scope="col">Quantidade</th>
				      <th scope="col">Data fabricacao</th>
				      <th></th>
				      <th></th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${produtos }" var="p">
				    <tr>
				      <td>${p.nome } </td>	
				      <td>${p.valor }</td>
				      <td>${p.quantidade }</td>
				      <td><fmt:formatDate value="${p.dataFabricacao }" pattern="dd/MM/yyyy"/></td>
				      <td>
				      <c:url value="produto" var="link">
				      	<c:param name="acao" value="editar"/>
				      	<c:param name="codigo" value="${p.codigo }"/>
				      </c:url>
				      <a class="btn btn-primary" href="${link }" role="button">Editar</a>
				      </td>
				      <td>
				      	<form action="produto" method="post">
				      		<input type="hidden" name="acao" value="remover">
				      		<input type="hidden" name="codigo" value="${p.codigo }">
				      		<button type="submit" class="btn btn-danger">Remover</button>
				      	</form>
				      
				      </td>
				    </tr>
				  </c:forEach> 
				  </tbody>
				</table>
					
			
			</div>
			
	
	
	
	
	





<%@ include file="footer.jsp" %>
</body>
</html>