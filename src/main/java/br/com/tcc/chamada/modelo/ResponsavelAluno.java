package br.com.tcc.chamada.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ResponsavelAluno {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private String CPF;

	@OneToMany(mappedBy = "responsavelAluno")
	private List<Aluno> alunosResponsaveis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public List<Aluno> getAlunosResponsaveis() {
		return alunosResponsaveis;
	}

	public void setAlunosResponsaveis(List<Aluno> alunosResponsaveis) {
		this.alunosResponsaveis = alunosResponsaveis;
	}
}
