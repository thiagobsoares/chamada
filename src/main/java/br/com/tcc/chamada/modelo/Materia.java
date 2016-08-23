package br.com.tcc.chamada.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Materia {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private String sigla;

	private String logotipo;

	private String planoDeEnsino;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getPlanoDeEnsino() {
		return planoDeEnsino;
	}

	public void setPlanoDeEnsino(String planoDeEnsino) {
		this.planoDeEnsino = planoDeEnsino;
	}

	public String getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(String logotipo) {
		this.logotipo = logotipo;
	}
}
