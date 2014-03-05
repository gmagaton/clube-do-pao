package br.com.clubedopao.repositorio;

import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clubedopao.modelo.Tabela;

@Repository
public interface TabelaRepositorio extends JpaRepository<Tabela, Integer> {

	public Tabela findByDataInicio(final Calendar dataInicio);

}
