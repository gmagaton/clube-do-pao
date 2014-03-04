package br.com.clubedopao.service;

import java.util.List;

import br.com.clubedopao.excecao.JaExisteMembroComEmailInformadoException;
import br.com.clubedopao.modelo.Membro;

public interface MembroService {
	
	List<Membro> listarTodos();
	
	Membro buscarPorId(final int id);
	
	void removerPorId(final int id);
	
	void salvar(final Membro membro) throws JaExisteMembroComEmailInformadoException;

}
