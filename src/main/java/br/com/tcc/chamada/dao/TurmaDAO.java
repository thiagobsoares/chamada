package br.com.tcc.chamada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcc.chamada.modelo.Turma;

public interface TurmaDAO extends JpaRepository<Turma, Long> {

}
