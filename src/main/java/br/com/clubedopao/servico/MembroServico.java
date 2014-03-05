package br.com.clubedopao.servico;

import java.util.List;

import br.com.clubedopao.excecao.JaExisteMembroComEmailInformadoException;
import br.com.clubedopao.modelo.Membro;

public interface MembroServico {

	List<Membro> listarTodos();

	Membro buscarPorId(final int id);

	void removerPorId(final int id);

	void salvar(final Membro membro) throws JaExisteMembroComEmailInformadoException;

}
