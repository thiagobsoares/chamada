package br.com.tcc.chamada.validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.tcc.chamada.dao.ProfessorDAO;
import br.com.tcc.chamada.modelo.Aluno;
import br.com.tcc.chamada.modelo.Aula;
import br.com.tcc.chamada.modelo.DiaSemana;
import br.com.tcc.chamada.modelo.Professor;

public class AulaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Aula.class);
	}

	@Override
	public void validate(Object obj, Errors erros) {
		Aula aula = (Aula) obj;

		Boolean datasCorretas = validarDataDeInicioEFim(aula.getDataInicio(), aula.getDataFim());
		if (!datasCorretas) {
			erros.reject("field.required");
		}

		Boolean horariosCorretos = validarHorarioDeInicioEFim(aula.getHorarioInicio(), aula.getHorarioFim());
		if (!horariosCorretos) {
			erros.reject("field.required");
		}

		Professor professor = aula.getProfessor();
		Boolean professorEstaDisponivel = false;
		if (professor != null) {
			professorEstaDisponivel = professor.disponivelNaData(aula.getDataInicio(), aula.getDataFim(),
					aula.getDiasDeAula(), aula.getHorarioInicio(), aula.getHorarioFim());
		}
		
		if (!professorEstaDisponivel) {
			erros.reject("field.required");
		}
		List<Aluno> alunos = aula.getAlunos();
		for (Aluno aluno : alunos) {
			Boolean alunoEstaDisponivel = aluno.disponivelNaData(aula.getDataInicio(), aula.getDataFim(),
					aula.getDiasDeAula(), aula.getHorarioInicio(), aula.getHorarioFim());
			if (!alunoEstaDisponivel) {
				erros.reject("field.required");
			}
		}

	}

	private Boolean validarHorarioDeInicioEFim(LocalTime horarioInicio, LocalTime horarioFim) {
		if (horarioInicio == null || horarioFim == null)
			return false;
		if (horarioInicio.isAfter(horarioFim))
			return false;
		return true;
	}

	private Boolean validarDataDeInicioEFim(LocalDate dataInicio, LocalDate dataFim) {
		if (dataInicio == null || dataFim == null)
			return false;
		if (dataInicio.isAfter(dataFim))
			return false;
		return true;
	}

}
