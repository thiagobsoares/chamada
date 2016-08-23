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

	<form:form action="${spring:mvcUrl('cadastrarProfessor').build()}"
		method="POST" commandName="professor">
		<label for="foto">Foto:</label>
		<form:input path="foto" type="file" />
		<form:errors path="foto" />
		<br />
		<label for="nome"><spring:message code='views.aluno.form.name'
				text='Nome Padrão' /></label>
		<form:input path="nome" />
		<form:errors path="nome" />
		<br />
		<label for="email">Email</label>
		<form:input path="email" />
		<form:errors path="email" />
		<br />
		<label for="password">Senha</label>
		<form:input path="password" type="password" />
		<form:errors path="password" />
		<br />
		<form:button>Gravar</form:button>
	</form:form>
</body>
</html>