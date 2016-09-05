package br.com.tcc.chamada.validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.tcc.chamada.modelo.Aluno;
import br.com.tcc.chamada.modelo.Aula;
import br.com.tcc.chamada.modelo.Professor;

public class AlunoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Aluno.class);
	}

	@Override
	public void validate(Object obj, Errors erros) {
		Aula aula = (Aula) obj;

		if (existeAtributoNulo(aula, erros)) {
			return;
		}

		Boolean datasCorretas = dataInicioAnteriorDataFim(aula.getDataInicio(), aula.getDataFim());
		if (!datasCorretas) {
			erros.reject("aula.cadastro.data_invalida");
		}

		Boolean horariosCorretos = horarioInicioAnteriorHorarioFim(aula.getHorarioInicio(), aula.getHorarioFim());
		if (!horariosCorretos) {
			erros.reject("aula.cadastro.horario_invalido");
		}

		Professor professor = aula.getProfessor();
		Boolean professorEstaDisponivel = professor.disponivelNaData(aula.getDataInicio(), aula.getDataFim(),
				aula.getDiasDeAula(), aula.getHorarioInicio(), aula.getHorarioFim());
		if (!professorEstaDisponivel) {
			erros.rejectValue("professor", "aula.cadastro.professor_indisponivel", new String[] { professor.getNome() },
					null);
		}

		List<Aluno> alunos = aula.getAlunos();
		for (Aluno aluno : alunos) {
			Boolean alunoEstaDisponivel = aluno.disponivelNaData(aula.getDataInicio(), aula.getDataFim(),
					aula.getDiasDeAula(), aula.getHorarioInicio(), aula.getHorarioFim());
			if (!alunoEstaDisponivel) {
				erros.rejectValue("alunos", "aula.cadastro.aluno_indisponivel", new String[] { aluno.getNome() }, null);
			}
		}

	}

	private boolean existeAtributoNulo(Aula aula, Errors erros) {
		Boolean existeAtributoNulo = false;

		if (aula.getDataInicio() == null) {
			erros.reject("aula.cadastro.data_inicio.not_null");
			existeAtributoNulo = true;
		}
		if (aula.getDataFim() == null) {
			erros.reject("aula.cadastro.data_fim.not_null");
			existeAtributoNulo = true;
		}
		if (aula.getDiasDeAula() == null) {
			erros.reject("aula.cadastro.dia_da_semana.not_null");
			existeAtributoNulo = true;
		}
		if (aula.getHorarioInicio() == null) {
			erros.reject("aula.cadastro.horario_inicio.not_null");
			existeAtributoNulo = true;
		}
		if (aula.getHorarioFim() == null) {
			erros.reject("aula.cadastro.horario_fim.not_null");
			existeAtributoNulo = true;
		}
		if (aula.getMateria() == null) {
			erros.reject("aula.cadastro.materia.not_null");
			existeAtributoNulo = true;
		}
		if (aula.getProfessor() == null) {
			erros.reject("aula.cadastro.professor.not_null");
			existeAtributoNulo = true;
		}
		if (aula.getAlunos().isEmpty()) {
			erros.reject("aula.cadastro.aluno.not_null");
			existeAtributoNulo = true;
		}
		return existeAtributoNulo;
	}

	private Boolean horarioInicioAnteriorHorarioFim(LocalTime horarioInicio, LocalTime horarioFim) {
		if (horarioInicio.isAfter(horarioFim))
			return false;
		return true;
	}

	private Boolean dataInicioAnteriorDataFim(LocalDate dataInicio, LocalDate dataFim) {
		if (dataInicio == null || dataFim == null)
			return false;
		if (dataInicio.isAfter(dataFim))
			return false;
		return true;
	}

}
