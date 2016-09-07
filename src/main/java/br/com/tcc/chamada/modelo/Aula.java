package br.com.tcc.chamada.modelo;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Aula {
	@Id
	@GeneratedValue
	private Integer id;

	private Integer ano;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private DiaSemana diaSemanaDeAula;

	@NotNull
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime horarioInicio;

	@NotNull
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime horarioFim;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Materia materia;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Professor professor;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Turma turma;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public DiaSemana getDiaSemanaDeAula() {
		return diaSemanaDeAula;
	}

	public void setDiaSemanaDeAula(DiaSemana diaSemanaDeAula) {
		this.diaSemanaDeAula = diaSemanaDeAula;
	}

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(LocalTime horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}


}
