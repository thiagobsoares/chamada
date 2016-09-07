package br.com.tcc.chamada.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Professor implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long ra;

	@NotBlank
	private String nome;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	private String digital;

	private String foto;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "professor")
	private List<Aula> aulas;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getUsername() {
		return this.email;
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

	@Override
	public String toString() {
		return this.nome;
	}
	public Boolean disponivelNaData(LocalDate ano, DiaSemana diaDaSemana,
			LocalTime horarioInicio, LocalTime horarioFim) {

		for (Aula aula : aulas) {
			DiaSemana diasDeAula = aula.getDiaSemanaDeAula();
			Integer anoAula = aula.getAno();
			LocalTime horarioInicioAulaRegistrada = aula.getHorarioInicio();
			LocalTime horarioFimAulaRegistrada = aula.getHorarioFim();

			if (!diasDeAula.equals(diaDaSemana)) {
				continue;
			}
			
			if (!ano.equals(anoAula)) {
				continue;
			}

			if (horarioInicio.isAfter(horarioFimAulaRegistrada)) {
				continue;
			}

			if (horarioFim.isBefore(horarioInicioAulaRegistrada)) {
				continue;
			}

			return Boolean.FALSE;
		}

		return Boolean.TRUE;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
