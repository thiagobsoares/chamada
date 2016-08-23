package br.com.tcc.chamada.modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Aula {
	@Id
	@GeneratedValue
	private Integer id;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataInicio;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataFim;

	@Enumerated(EnumType.STRING)
	private DayOfWeek diasDeAula;

	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime horarioDeAula;

	@ManyToOne(fetch = FetchType.EAGER)
	private Materia materia;

	@ManyToOne(fetch = FetchType.EAGER)
	private Professor professor;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Aluno> alunos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public DayOfWeek getDiasDeAula() {
		return diasDeAula;
	}

	public void setDiasDeAula(DayOfWeek diasDeAula) {
		this.diasDeAula = diasDeAula;
	}

	public LocalTime getHorarioDeAula() {
		return horarioDeAula;
	}

	public void setHorarioDeAula(LocalTime horarioDeAula) {
		this.horarioDeAula = horarioDeAula;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
