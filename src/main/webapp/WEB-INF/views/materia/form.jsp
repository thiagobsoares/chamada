<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Professor</title>
</head>
<body>
	<h1>Cadastro de Professor</h1>

	<form:form action="${spring:mvcUrl('cadastrarMateria').build()}"
		method="POST" commandName="materia">
		<label for="logotipo">Logotipo:</label>
		<form:input path="logotipo" type="file" />
		<form:errors path="logotipo" />
		<br />
		<label for="nome"><spring:message code='views.aluno.form.name'
				text='Nome Padrão' /></label>
		<form:input path="nome" />
		<form:errors path="nome" />
		<br />
		<label for="sigla">Sigla</label>
		<form:input path="sigla" />
		<form:errors path="sigla" />
		<br />
		<label for="planoDeEnsino">Plano de Ensino</label>
		<form:textarea path="planoDeEnsino" rows="5" cols="30" />
		<form:errors path="planoDeEnsino" />
		<br />
		<form:button>Gravar</form:button>
	</form:form>
</body>
</html>