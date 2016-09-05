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

import br.com.tcc.chamada.dao.TurmaDAO;
import br.com.tcc.chamada.modelo.Turma;

@RequestMapping("/turma")
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class TurmaController {

	@Autowired
	private TurmaDAO turmaDAO;

	@RequestMapping(method = RequestMethod.GET, name = "montarFormularioTurma")
	public ModelAndView montarFormulario(Turma turma) {
		ModelAndView mav = new ModelAndView("turma/form");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, name = "cadastrarTurma")
	public ModelAndView cadastrarTurma(@Valid Turma turma, BindingResult result) {
		ModelAndView mav = new ModelAndView("turma/form");

		if (result.hasErrors()) {
			return montarFormulario(turma);
		}

		
		turmaDAO.save(turma);
		return mav;
	}
}
