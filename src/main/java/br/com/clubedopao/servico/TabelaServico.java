package br.com.clubedopao.servico;

import java.util.Calendar;
import java.util.List;

import br.com.clubedopao.excecao.JaExisteTabelaComDataInformadaException;
import br.com.clubedopao.modelo.Tabela;

public interface TabelaServico {

	List<Tabela> listarTodos();

	void removerPorId(final int id);

	Tabela gerar(final Calendar data) throws JaExisteTabelaComDataInformadaException;

	Tabela buscarPorId(Integer id);

}
