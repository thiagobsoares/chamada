package br.com.tcc.chamada.validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.tcc.chamada.dao.ProfessorDAO;
import br.com.tcc.chamada.modelo.Aula;

public class AulaValidator implements Validator {

	@Autowired
	private ProfessorDAO professorDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Aula.class);
	}

	@Override
	public void validate(Object obj, Errors erros) {
		Aula aula = (Aula) obj;

		Boolean datasCorretas = validarDataDeInicioEFim(aula.getDataInicio(), aula.getDataFim());
		if (!datasCorretas) {
			erros.reject("Data incorreta, data inicio não pode ser maior que data final");
		}

		Boolean horariosCorretos = validarHorarioDeInicioEFim(aula.getHorarioInicio(), aula.getHorarioFim());
		if (!horariosCorretos) {
			erros.reject("Data incorreta, data inicio não pode ser maior que data final");
		}

		
		List<Aula> aulasDoProfessor = aula.getProfessor().getAulas();
		
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
