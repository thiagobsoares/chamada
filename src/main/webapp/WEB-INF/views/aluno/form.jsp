<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Aluno</title>
</head>
<body>
	<h1>Cadastro de Aluno</h1>

	<form:form action="${spring:mvcUrl('cadastrarAluno').build()}"
		method="POST" commandName="aluno">
		<label for="foto"><spring:message code='views.aluno.form.foto' text='Foto'/></label>
		<form:input path="foto" type="file"/>
		<form:errors path="foto" />
		<br />
		<label for="nome"><spring:message code='views.aluno.form.name' text='Nome'/></label>
		<form:input path="nome" />
		<form:errors path="nome" />
		<br />
		<label for="dataNascimento">Data Nascimento</label>
		<form:input path="dataNascimento" type="date"/>
		<form:errors path="dataNascimento" />
		<br />
		<label for="email">Email</label>
		<form:input path="email" />
		<form:errors path="email" />
		<br />
		<label for="password">Senha</label>
		<form:input path="password" type="password"/>
		<form:errors path="password" />
		<br />
		<label for="telefone">Telefone</label>
		<form:input path="telefone" />
		<form:errors path="telefone" />
		<br />
		<label for="endereco.rua">Rua</label>
		<form:input path="endereco.rua" />
		<form:errors path="endereco.rua" />
		<br />
		<label for="endereco.numero">Número</label>
		<form:input path="endereco.numero" />
		<form:errors path="endereco.numero" />
		<br />
		<label for="endereco.bairro">Bairro</label>
		<form:input path="endereco.bairro" />
		<form:errors path="endereco.bairro" />
		<br />
		<label for="endereco.cidade">Cidade</label>
		<form:input path="endereco.cidade" />
		<form:errors path="endereco.cidade" />
		<br />
		<label for="endereco.estado">Estado</label>
		<form:input path="endereco.estado" />
		<form:errors path="endereco.estado" />
		<br />
		<label for="endereco.cep">CEP</label>
		<form:input path="endereco.cep" />
		<form:errors path="endereco.cep" />
		<br />
		<label for="responsavelAluno.cpf">CEP</label>
		<form:input path="responsavelAluno.cpf" />
		<form:errors path="responsavelAluno.cpf" />
		<br />
		<form:button>Gravar</form:button>
	</form:form>
</body>
</html>