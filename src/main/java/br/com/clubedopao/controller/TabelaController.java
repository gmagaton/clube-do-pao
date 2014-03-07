package br.com.clubedopao.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import br.com.clubedopao.excecao.JaExisteTabelaComDataInformadaException;
import br.com.clubedopao.modelo.Tabela;
import br.com.clubedopao.servico.TabelaServico;

@Controller
@RequestMapping("/tabela")
public class TabelaController {

	@Autowired
	private TabelaServico tabelaServico;

	@Autowired
	private ReloadableResourceBundleMessageSource properties;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView tabelas() {
		final ModelAndView modelAndView = new ModelAndView("lista_tabela");
		final List<Tabela> tabelas = tabelaServico.listarTodos();
		modelAndView.addObject("tabelas", tabelas);
		return modelAndView;
	}

	@RequestMapping(value = "/{tabelaId}", method = RequestMethod.GET)
	public String buscarPorId(@PathVariable final Integer tabelaId, final Model model) {
		final Tabela tabela = tabelaServico.buscarPorId(tabelaId);
		model.addAttribute("tabela", tabela);
		return "tabela";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gerarTabela(@RequestParam(value = "data", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") final Calendar data, final HttpServletRequest request) {
		final ModelAndView modelAndView = new ModelAndView("tabela");
		try {
			tabelaServico.gerar(data);
			final String mensagemSucesso = properties.getMessage("tabela.sucesso", null, RequestContextUtils.getLocale(request));
			modelAndView.addObject("sucesso", mensagemSucesso);
		} catch (final JaExisteTabelaComDataInformadaException e) {
			final String mensagemErro = properties.getMessage("tabela.erro", null, RequestContextUtils.getLocale(request));
			modelAndView.addObject("erro", mensagemErro + " " + e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/nova", method = RequestMethod.GET)
	public String nova() {
		return "gerar_tabela";
	}

	@RequestMapping(value = "/{tabelaId}", method = RequestMethod.DELETE)
	public ModelAndView removerPorId(@PathVariable final Integer tabelaId, final Model model) {
		tabelaServico.removerPorId(tabelaId);
		return tabelas();
	}
}
