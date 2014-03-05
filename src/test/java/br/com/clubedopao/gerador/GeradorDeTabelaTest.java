package br.com.clubedopao.gerador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.clubedopao.modelo.Membro;
import br.com.clubedopao.modelo.Tabela;
import br.com.clubedopao.util.CalendarUtil;

public class GeradorDeTabelaTest {

	@Test
	public void deveSetarDataInicioEntreSegundaESexta() {
		final Calendar sabado = CalendarUtil.getCalendarPorDiaMesAno(1, 3, 2014); // sabado
		final List<Membro> membros = gerarMembros();
		final GeradorDeTabela geradorDeTabela = new GeradorDeTabela(sabado, membros);
		final Calendar dataInicio = geradorDeTabela.getDataInicio();
		Assert.assertNotEquals(dataInicio.get(Calendar.DAY_OF_WEEK), Calendar.SATURDAY);
		Assert.assertNotEquals(dataInicio.get(Calendar.DAY_OF_WEEK), Calendar.SUNDAY);
	}

	@Test
	public void deveGerar() {
		final Calendar sabado = CalendarUtil.getCalendarPorDiaMesAno(1, 3, 2014); // sabado
		final List<Membro> membros = gerarMembros();
		final GeradorDeTabela geradorDeTabela = new GeradorDeTabela(sabado, membros);
		final Tabela tabelaGerada = geradorDeTabela.gerar(30);
		Assert.assertNotNull(tabelaGerada);
	}

	private List<Membro> gerarMembros() {
		final List<Membro> membros = new ArrayList<Membro>();
		membros.add(new Membro("nome1", "email1@email.com", false, true, false, true, false));
		membros.add(new Membro("nome2", "email2@email.com", false, true, false, false, false));
		membros.add(new Membro("nome3", "email3@email.com", false, false, true, false, false));
		membros.add(new Membro("nome4", "email4@email.com", false, false, false, true, false));
		membros.add(new Membro("nome5", "email5@email.com", false, false, false, false, true));
		return membros;
	}

}
