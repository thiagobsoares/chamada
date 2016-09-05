<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aulas Cadastradas</title>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	
<div class="container">
  <h2>Aulas Cadastradas</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Codigo</th>
        <th>Matéria</th>
        <th>Data Inicio</th>
        <th>Data Fim</th>
        <th>Dia da Semana</th>
        <th>Professor</th>
        <th>Aluno</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${aulas}" var="aula">
	      <tr>
	        <td>${aula.id }</td>
	        <td>${aula.materia.nome }</td>
	        <td>${aula.dataInicio }</td>
	        <td>${aula.dataFim }</td>
	        <td>${aula.diasDeAula.nome }</td>
	        <td>${aula.professor.nome }</td>
	      </tr>
    	</c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>