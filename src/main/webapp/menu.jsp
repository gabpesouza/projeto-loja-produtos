<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="#">ProjetoLoja</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="menu.jsp">Início</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="produto?acao=abrir-form-cadastro">Cadastro</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="produto?acao=listar">Produtos</a>
        </li>
       </ul>
       		
       	   <c:if test="${not empty user }">
	       		<span class="navbar-text">
	       		${user }
	       		<a href="login" class="btn btn-outline-primary my-2 my-sm-0">Sair</a>
	       		</span>
       	  </c:if>
       
     
    </div>
  </div>
</nav>

	
	
	<c:if test="${empty user }">
		<span class="navbar-text text-danger" style="margin-right:10px">
			${erro }
		</span>
	
		<div class="container">
			 <form class="form-signin" action="login" method="post">
			   
			      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
			      <label for="inputEmail" class="sr-only">Email address</label>
			      <input type="email" id="inputEmail" class="form-control mb-3" name="email" placeholder="Email address" required autofocus>
			      <label for="inputPassword" class="sr-only">Password</label>
			      <input type="password" id="inputPassword" class="form-control" name="senha" placeholder="Password" required>
			     
			      <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Sign in</button>
			      
	    </form>
		
		
		</div>
	</c:if>


<%@ include file="footer.jsp" %>
</body>
</html>