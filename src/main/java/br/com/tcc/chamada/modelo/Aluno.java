package br.com.tcc.chamada.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Aluno implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long ra;

	private String nome;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	private String rg;
	
	private String cpf;
	
	private String email;

	private String password;

	private String telefone;

	private String digital;

	private String foto;

	@ManyToOne
	private Turma turma;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Endereco endereco;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ResponsavelAluno responsavelAluno;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public void addPermission(String permissao) {
		if (roles == null) {
			roles = new ArrayList<>();
		}
		roles.add(new Role(permissao));
	}

	public Long getRa() {
		return ra;
	}

	public void setRa(Long ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDigital() {
		return digital;
	}

	public void setDigital(String digital) {
		this.digital = digital;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public ResponsavelAluno getResponsavelAluno() {
		return responsavelAluno;
	}

	public void setResponsavelAluno(ResponsavelAluno responsavelAluno) {
		this.responsavelAluno = responsavelAluno;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * @Deprecated public Boolean disponivelNaData(LocalDate dataInicio,
	 * LocalDate dataFim, DiaSemana diaDaSemana, LocalTime horarioInicio,
	 * LocalTime horarioFim) {
	 * 
	 * for (Aula aula : aulas) { DiaSemana diasDeAula = aula.getDiasDeAula();
	 * LocalTime horarioInicioAulaRegistrada = aula.getHorarioInicio();
	 * LocalTime horarioFimAulaRegistrada = aula.getHorarioFim(); LocalDate
	 * dataInicioAulaRegistrada = aula.getDataInicio(); LocalDate
	 * dataFimAulaRegistrada = aula.getDataFim();
	 * 
	 * if (!diasDeAula.equals(diaDaSemana)) { continue; }
	 * 
	 * if (horarioInicio.isAfter(horarioFimAulaRegistrada)) { continue; }
	 * 
	 * if (horarioFim.isBefore(horarioInicioAulaRegistrada)) { continue; }
	 * 
	 * if (dataInicio.isAfter(dataFimAulaRegistrada)) { continue; }
	 * 
	 * if (dataFim.isBefore(dataInicioAulaRegistrada)) { continue; }
	 * 
	 * return Boolean.FALSE; }
	 * 
	 * return Boolean.TRUE; }
	 */
}
