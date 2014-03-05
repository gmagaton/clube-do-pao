package br.com.clubedopao.gerador;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;

import br.com.clubedopao.modelo.Membro;
import br.com.clubedopao.modelo.Tabela;
import br.com.clubedopao.util.CalendarUtil;

public class GeradorDeTabela {

	private final Calendar dataInicio;
	private final LinkedHashSet<Membro> membros = new LinkedHashSet<Membro>();

	public GeradorDeTabela(final Calendar dataInicio, final List<Membro> membros) {
		super();
		this.dataInicio = CalendarUtil.getDataEntreSegundaSexta(dataInicio);
		if (membros != null)
			this.membros.addAll(membros);
	}

	public Tabela gerar(final int quantidadeDias) {
		// inicio j‡ Ž de segunda a sexta
		final Tabela tabela = new Tabela(dataInicio);
		// int semanaDoAno = dataInicio.get(Calendar.WEEK_OF_YEAR);

		Calendar dataCronograma = (Calendar) dataInicio.clone();

		final LinkedHashSet<Membro> membrosCronograma = new LinkedHashSet<Membro>(membros);
		// final List<Membro> membrosJaUtilizados = new ArrayList<Membro>();

		int quantidadeIteracoes = 1;
		while (quantidadeIteracoes <= quantidadeDias) {

			final int diaDaSemana = dataCronograma.get(Calendar.DAY_OF_WEEK);
			final Membro membroCronograma = Membro.encontrarMembroParaODia(membrosCronograma, diaDaSemana);

			// se encontrou coloca membro no final da fila
			if (membroCronograma != null) {
				membrosCronograma.remove(membroCronograma);
				membrosCronograma.add(membroCronograma);
				// membrosJaUtilizados.add(membroCronograma);
			}
			tabela.addMembro((Calendar) dataCronograma.clone(), membroCronograma);

			// avancar data
			dataCronograma.add(Calendar.DAY_OF_YEAR, 1);
			dataCronograma = CalendarUtil.getDataEntreSegundaSexta(dataCronograma);

			quantidadeIteracoes++;

		}

		return tabela;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public LinkedHashSet<Membro> getMembros() {
		return membros;
	}

}
