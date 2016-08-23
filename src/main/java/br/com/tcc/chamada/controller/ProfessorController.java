package br.com.tcc.chamada.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.tcc.chamada.dao.ProfessorDAO;
import br.com.tcc.chamada.modelo.Professor;

@RequestMapping("/professor")
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ProfessorController {

	@Autowired
	private ProfessorDAO professorDAO;

	@RequestMapping(method = RequestMethod.GET, name = "montarFormularioProfessor")
	public ModelAndView montarFormulario(Professor professor) {
		ModelAndView mav = new ModelAndView("professor/form");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, name = "cadastrarProfessor")
	public ModelAndView cadastrarProfessor(@Valid Professor professor, BindingResult result) {
		ModelAndView mav = new ModelAndView("professor/form");

		if (result.hasErrors()) {
			return montarFormulario(professor);
		}

		professor.addPermission("ROLE_PROFESSOR");
		
		professorDAO.save(professor);
		return mav;
	}
}
