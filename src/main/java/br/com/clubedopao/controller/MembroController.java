package br.com.clubedopao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.clubedopao.modelo.Membro;
import br.com.clubedopao.service.MembroService;

@Controller
@RequestMapping(value = "/membro")
public class MembroController {

	@Autowired
	private MembroService membroService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView membros() {
		final ModelAndView modelAndView = new ModelAndView("lista_membro");
		final List<Membro> membros = membroService.listarTodos();
		modelAndView.addObject("membros", membros);
		return modelAndView;
	}

	@RequestMapping(value = "/{membroId}", method = RequestMethod.GET)
	public String buscarPorId(@PathVariable final Integer membroId, final Model model) {
		final Membro membro = membroService.buscarPorId(membroId);
		model.addAttribute("membro", membro);
		return "membro";
	}

	@RequestMapping(value = "/{membroId}", method = RequestMethod.PUT)
	public ModelAndView atualizar(@PathVariable final Integer membroId, @Valid @ModelAttribute final Membro membro, final BindingResult result, final Model model) {
		if (result.hasErrors()) {
			return new ModelAndView("membro");
		}
		membroService.salvar(membro);
		return membros();
	}

	@RequestMapping(value = "/{membroId}", method = RequestMethod.DELETE)
	public ModelAndView removerPorId(@PathVariable final Integer membroId, final Model model) {
		membroService.removerPorId(membroId);
		return membros();
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo() {
		final Membro novoMembro = new Membro();
		final ModelAndView modelView = new ModelAndView("membro");
		modelView.addObject("membro", novoMembro);
		return modelView;
	}
}
