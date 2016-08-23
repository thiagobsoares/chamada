package br.com.tcc.chamada.controller;

import java.time.DayOfWeek;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.tcc.chamada.dao.AlunoDAO;
import br.com.tcc.chamada.dao.AulaDAO;
import br.com.tcc.chamada.dao.MateriaDAO;
import br.com.tcc.chamada.dao.ProfessorDAO;
import br.com.tcc.chamada.modelo.Aula;

@RequestMapping("/aula")
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class AulaController {

	@Autowired
	private AulaDAO aulaDAO;

	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private ProfessorDAO professorDAO;

	@Autowired
	private MateriaDAO materiaDAO;

	@RequestMapping(method = RequestMethod.GET, name = "montarFormularioAula")
	public ModelAndView montarFormulario(Aula aula) {
		ModelAndView mav = new ModelAndView("aula/form");
		mav.addObject("professores", professorDAO.findAll());
		mav.addObject("alunos", alunoDAO.findAll());
		mav.addObject("materias", materiaDAO.findAll());
		mav.addObject("diasSemana", DayOfWeek.values());
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, name = "cadastrarAula")
	public ModelAndView cadastrarAula(@Valid Aula aula, BindingResult result) {
		ModelAndView mav = new ModelAndView("aula/form");

		if (result.hasErrors()) {
			return montarFormulario(aula);
		}

		aulaDAO.save(aula);
		return mav;
	}
}
