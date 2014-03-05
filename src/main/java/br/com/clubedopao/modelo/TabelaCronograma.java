package br.com.clubedopao.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.clubedopao.util.CalendarUtil;

@Entity
public class TabelaCronograma {

	@Id
	@Embedded
	private TabelaCronogramaId id;

	@ManyToOne
	private Membro membro;

	TabelaCronograma() {
		super();
		id = null;
		membro = null;
	}

	public TabelaCronograma(final Tabela tabela, final Calendar dataCronograma, final Membro membro) {
		id = new TabelaCronogramaId(tabela, dataCronograma);
		this.membro = membro;
	}

	public Membro getMembro() {
		return membro;
	}

	public String getDia() {
		return CalendarUtil.getDia(getDataCronograma());
	}

	public String getNome() {
		return membro != null ? membro.getNome() : "";
	}

	public Tabela getTabela() {
		return id.getTabela();
	}

	public Calendar getDataCronograma() {
		return id.getDataCronograma();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
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
		final TabelaCronograma other = (TabelaCronograma) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Data: " + SimpleDateFormat.getDateInstance().format(id.getDataCronograma().getTime()) + " membro:" + membro;
	}

	void setId(final TabelaCronogramaId id) {
		this.id = id;
	}

	void setMembro(final Membro membro) {
		this.membro = membro;
	}

}

@Embeddable
class TabelaCronogramaId implements Serializable {

	private static final long serialVersionUID = -7286259210495899726L;

	@ManyToOne
	private Tabela tabela;

	@Temporal(TemporalType.DATE)
	private Calendar dataCronograma;

	TabelaCronogramaId() {
		super();
		tabela = null;
		dataCronograma = null;
	}

	public TabelaCronogramaId(final Tabela tabela, final Calendar dataCronograma) {
		super();
		this.tabela = tabela;
		this.dataCronograma = dataCronograma;
	}

	public Tabela getTabela() {
		return tabela;
	}

	public Calendar getDataCronograma() {
		return dataCronograma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (dataCronograma == null ? 0 : dataCronograma.hashCode());
		result = prime * result + (tabela == null ? 0 : tabela.hashCode());
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
		final TabelaCronogramaId other = (TabelaCronogramaId) obj;
		if (dataCronograma == null) {
			if (other.dataCronograma != null) {
				return false;
			}
		} else if (!dataCronograma.equals(other.dataCronograma)) {
			return false;
		}
		if (tabela == null) {
			if (other.tabela != null) {
				return false;
			}
		} else if (!tabela.equals(other.tabela)) {
			return false;
		}
		return true;
	}

	void setTabela(final Tabela tabela) {
		this.tabela = tabela;
	}

	void setDataCronograma(final Calendar dataCronograma) {
		this.dataCronograma = dataCronograma;
	}

}
