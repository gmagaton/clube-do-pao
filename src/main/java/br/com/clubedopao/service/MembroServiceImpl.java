package br.com.clubedopao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clubedopao.modelo.Membro;
import br.com.clubedopao.repository.MembrosRepository;

@Service
public class MembroServiceImpl implements MembroService {
	
	@Autowired
	private MembrosRepository membroRepository;

	@Override
	public List<Membro> listarTodos() {
		return membroRepository.findAll();
	}

	@Transactional
	@Override
	public void salvar(Membro membro) {
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
