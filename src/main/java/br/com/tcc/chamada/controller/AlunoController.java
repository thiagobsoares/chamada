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

import br.com.tcc.chamada.dao.AlunoDAO;
import br.com.tcc.chamada.modelo.Aluno;

@RequestMapping("/aluno")
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class AlunoController {

	@Autowired
	private AlunoDAO alunoDAO;

	@RequestMapping(method = RequestMethod.GET, name = "montarFormularioAluno")
	public ModelAndView montarFormulario(Aluno aluno) {
		ModelAndView mav = new ModelAndView("aluno/form");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, name = "cadastrarAluno")
	public ModelAndView cadastrarAluno(@Valid Aluno aluno, BindingResult result) {
		ModelAndView mav = new ModelAndView("aluno/form");

		if (result.hasErrors()) {
			return montarFormulario(aluno);
		}

		aluno.addPermission("ROLE_ALUNO");
		
		alunoDAO.save(aluno);
		return mav;
	}
}
