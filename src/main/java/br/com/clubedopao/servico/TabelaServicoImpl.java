package br.com.clubedopao.servico;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clubedopao.excecao.JaExisteTabelaComDataInformadaException;
import br.com.clubedopao.gerador.GeradorDeTabela;
import br.com.clubedopao.modelo.Membro;
import br.com.clubedopao.modelo.Tabela;
import br.com.clubedopao.repositorio.TabelaRepositorio;
import br.com.clubedopao.util.CalendarUtil;

@Service
public class TabelaServicoImpl implements TabelaServico {

	private static final int quantidadeDiasTabela = 30;

	@Autowired
	private TabelaRepositorio tabelaRepositorio;

	@Autowired
	private MembroServico membroServico;

	@Override
	public List<Tabela> listarTodos() {
		return tabelaRepositorio.findAll();
	}

	@Override
	public void removerPorId(final int id) {
		tabelaRepositorio.delete(id);
	}

	@Transactional
	@Override
	public Tabela gerar(final Calendar data) throws JaExisteTabelaComDataInformadaException {
		final Calendar dataSomenteDiaMesAno = CalendarUtil.getCalendarSomenteDiaMesAno(data);
		final Tabela tabelaComDataInicioIgual = tabelaRepositorio.findByDataInicio(dataSomenteDiaMesAno);
		if (tabelaComDataInicioIgual != null) {
			throw new JaExisteTabelaComDataInformadaException();
		}
		final List<Membro> membros = membroServico.listarTodos();
		final GeradorDeTabela gerador = new GeradorDeTabela(data, membros);
		final Tabela tabela = gerador.gerar(quantidadeDiasTabela);
		tabelaRepositorio.save(tabela);
		return tabela;
	}

	@Override
	public Tabela buscarPorId(final Integer id) {
		return tabelaRepositorio.findOne(id);
	}

}
