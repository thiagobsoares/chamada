<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Aula</title>
</head>
<body>
	<h1>Cadastro de Aula</h1>

	<form:form action="${spring:mvcUrl('cadastrarAula').build()}"
		method="POST" commandName="aula">
		<label for="materia">Materia:</label>
		<form:select path="materia">
			<form:option value="-1" label="Escolha a Matéria" />
			<form:options items="${materias}" itemValue="id"
				itemLabel="nome" />
		</form:select>
		<form:errors path="materia" />
		<br />
		<label for="dataInicio">Data Inicio</label>
		<form:input path="dataInicio" type="date"/>
		<form:errors path="dataInicio" />
		<br />
		<label for="dataFim">Data Fim</label>
		<form:input path="dataFim" type="date"/>
		<form:errors path="dataFim" />
		<br />
		<label for="diasDeAula">Dia da Aula</label>
		<form:select path="diasDeAula">
			<form:option value="" label="Escolha o dia" />
			<form:options items="${diasSemana}" itemLabel="nome"/>
		</form:select>
		<form:errors path="diasDeAula" />
		<br />
		<label for="horarioInicio">Horario Inicio</label>
		<form:input path="horarioInicio" type="time"/>
		<form:errors path="horarioInicio" />
		<br />
		<label for="horarioFim">Horario Fim</label>
		<form:input path="horarioFim" type="time"/>
		<form:errors path="horarioFim" />
		<br />
		<label for="professor">Professor:</label>
		<form:select path="professor">
			<form:option value="" label="Escolha o Professor" />
			<form:options items="${professores}" itemValue="ra"
				itemLabel="nome" />
		</form:select>
		<form:errors path="professor" />
		<br />
		<label for="alunos">Alunos:</label>
		<form:select path="alunos" multiple="true">
			<form:options items="${alunos}" itemValue="ra"
				itemLabel="nome" />
		</form:select>
		<form:errors path="alunos" />
		<br />
		<form:button>Gravar</form:button>
	</form:form>
</body>
</html>