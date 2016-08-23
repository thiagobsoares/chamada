package br.com.tcc.chamada.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Presenca {

	@Id
	@GeneratedValue
	private Long id;

	private Aluno aluno;

	private Boolean presente;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime dataPresente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Boolean getPresente() {
		return presente;
	}

	public void presente() {
		this.presente = Boolean.TRUE;
		dataPresente = LocalDateTime.now();
	}

	public LocalDateTime getDataPresente() {
		return dataPresente;
	}

}
