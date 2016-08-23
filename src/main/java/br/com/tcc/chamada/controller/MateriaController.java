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

import br.com.tcc.chamada.dao.MateriaDAO;
import br.com.tcc.chamada.modelo.Materia;

@RequestMapping("/materia")
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class MateriaController {

	@Autowired
	private MateriaDAO materiaDAO;

	@RequestMapping(method = RequestMethod.GET, name = "montarFormularioMateria")
	public ModelAndView montarFormulario(Materia materia) {
		ModelAndView mav = new ModelAndView("materia/form");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, name = "cadastrarMateria")
	public ModelAndView cadastrarMateria(@Valid Materia materia, BindingResult result) {
		ModelAndView mav = new ModelAndView("materia/form");

		if (result.hasErrors()) {
			return montarFormulario(materia);
		}

		materiaDAO.save(materia);
		return mav;
	}
}
