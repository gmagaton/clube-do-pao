package br.com.clubedopao.repositorio;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.clubedopao.modelo.Tabela;
import br.com.clubedopao.util.CalendarUtil;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class TabelaRepositorioTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private TabelaRepositorio tabelaRepositorio;

	@BeforeMethod
	public void inicializar() {
		tabelaRepositorio.save(gerarTabela(1, 1, 2014));
		tabelaRepositorio.save(gerarTabela(1, 2, 2014));
		tabelaRepositorio.save(gerarTabela(1, 3, 2014));
	}

	@Test
	public void deveBuscarTabelaPorDataDeInicio() {
		Calendar dataInicio = CalendarUtil.getCalendarPorDiaMesAno(1, 2, 2014);
		Tabela tabelaPorDataDeInicio = tabelaRepositorio.findByDataInicio(dataInicio);
		Assert.assertNotNull(tabelaPorDataDeInicio);
		Assert.assertEquals(dataInicio, tabelaPorDataDeInicio.getDataInicio());
	}

	private Tabela gerarTabela(int dia, int mes, int ano) {
		Calendar dataTabela = CalendarUtil.getCalendarPorDiaMesAno(dia, mes, ano);
		Tabela tabela1 = new Tabela(dataTabela);
		return tabela1;
	}

}
