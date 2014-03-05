package br.com.clubedopao.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tabela implements Serializable {

	private static final long serialVersionUID = -473971375058362974L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;

	@OneToMany(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
	private final List<TabelaCronograma> cronograma = new ArrayList<TabelaCronograma>();

	Tabela() {
		super();
	}

	public Tabela(final Calendar dataInicio) {
		super();
		this.dataInicio = dataInicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (dataInicio == null ? 0 : dataInicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Tabela other = (Tabela) obj;
		if (dataInicio == null) {
			if (other.dataInicio != null) {
				return false;
			}
		} else if (!dataInicio.equals(other.dataInicio)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder toString = new StringBuilder();
		toString.append("Tabela Data In’cio:" + SimpleDateFormat.getDateInstance().format(getDataInicio().getTime())).append("\n");
		for (final TabelaCronograma cronograma : getCronograma()) {
			toString.append(cronograma.toString()).append("\n");
		}
		return toString.toString();
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public Date getDataInicioDate() {
		return dataInicio.getTime();
	}

	public void setDataInicio(final Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public List<TabelaCronograma> getCronograma() {
		return cronograma;
	}

	public void addMembro(final Calendar data, final Membro membro) {
		cronograma.add(new TabelaCronograma(this, data, membro));
	}

	public Date dataInicioDate() {
		return dataInicio.getTime();
	}

	void setId(final int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
