package br.com.clubedopao.modelo;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Membro implements Serializable {

	private static final long serialVersionUID = 7535463978781658485L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String nome;

	@Email
	@NotNull
	@NotEmpty
	private String email;

	@Embedded
	private final Disponibilidade disponibilidade = new Disponibilidade();

	public Membro() {
		super();
	}

	public Membro(final String nome, final String email, final boolean segundafeira, final boolean tercafeira, final boolean quartafeira, final boolean quintafeira, final boolean sextafeira) {
		this(nome, email);
		disponibilidade.setSegundafeira(segundafeira);
		disponibilidade.setTercafeira(tercafeira);
		disponibilidade.setQuartafeira(quartafeira);
		disponibilidade.setQuintafeira(quintafeira);
		disponibilidade.setSextafeira(sextafeira);
	}

	public Membro(final String nome, final String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Membro other = (Membro) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	public static Membro encontrarMembroParaODia(final LinkedHashSet<Membro> membrosCronograma, final int diaDaSemana) {
		for (final Membro membro : membrosCronograma) {
			final Disponibilidade membroDiponibilidade = membro.getDisponibilidade();
			final List<Integer> diasDisponibilidade = membroDiponibilidade.getDiasSemana();
			final boolean membroTemDisponibilidadeNoDia = diasDisponibilidade.contains(diaDaSemana);
			if (membroTemDisponibilidadeNoDia)
				return membro;
		}
		return null;
	}

	@Override
	public String toString() {
		return "nome: " + nome;
	}

}
