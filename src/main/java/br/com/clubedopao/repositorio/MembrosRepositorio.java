package br.com.clubedopao.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clubedopao.modelo.Membro;

@Repository
public interface MembrosRepositorio extends JpaRepository<Membro, Integer> {

	public List<Membro> findByNome(final String nome);

	public Membro findByEmail(final String email);

}
