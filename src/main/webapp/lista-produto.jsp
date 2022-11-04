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
			 <table class="table table-striped">
				  <thead>
				    <tr>
				      <th scope="col">Nome</th>
				      <th scope="col">Valor</th>
				      <th scope="col">Quantidade</th>
				      <th scope="col">Data fabricacao</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${produtos }" var="p">
				    <tr>
				      <td>${p.nome }</td>	
				      <td>${p.valor }</td>
				      <td>${p.quantidade }</td>
				      <td><fmt:formatDate value="${p.dataFabricacao }" pattern="dd/MM/yyyy"/></td>
				    </tr>
				  </c:forEach> 
				  </tbody>
				</table>
					
			
			</div>
			
	
	
	
	
	





<%@ include file="footer.jsp" %>
</body>
</html>