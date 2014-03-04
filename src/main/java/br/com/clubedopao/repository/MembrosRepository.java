package br.com.clubedopao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clubedopao.modelo.Membro;

@Repository
public interface MembrosRepository extends JpaRepository<Membro, Integer>{
	
	public List<Membro> findByNome(final String nome);

}
