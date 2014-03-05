package br.com.clubedopao.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clubedopao.excecao.JaExisteMembroComEmailInformadoException;
import br.com.clubedopao.modelo.Membro;
import br.com.clubedopao.repositorio.MembrosRepositorio;

@Service
public class MembroServicoImpl implements MembroServico {

	@Autowired
	private MembrosRepositorio membroRepository;

	@Override
	public List<Membro> listarTodos() {
		return membroRepository.findAll();
	}

	@Transactional
	@Override
	public void salvar(Membro membro) throws JaExisteMembroComEmailInformadoException {
		Membro membroComMesmoEmail = membroRepository.findByEmail(membro.getEmail());
		if (membroComMesmoEmail != null && !membro.equals(membroComMesmoEmail)) {
			throw new JaExisteMembroComEmailInformadoException();
		}
		membroRepository.save(membro);
	}

	@Override
	public Membro buscarPorId(int id) {
		return membroRepository.findOne(id);
	}

	@Override
	public void removerPorId(int id) {
		membroRepository.delete(id);
	}

}
