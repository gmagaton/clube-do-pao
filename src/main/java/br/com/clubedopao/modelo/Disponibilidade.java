package br.com.clubedopao.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class Disponibilidade {
	
	private boolean segundafeira = false;
	private boolean tercafeira = false;
	private boolean quartafeira = false;
	private boolean quintafeira = false;
	private boolean sextafeira = false;

	public Disponibilidade() {
		super();
	}

	public Disponibilidade(boolean segundafeira, boolean tercafeira,
			boolean quartafeira, boolean quintafeira, boolean sextafeira) {
		super();
		this.segundafeira = segundafeira;
		this.tercafeira = tercafeira;
		this.quartafeira = quartafeira;
		this.quintafeira = quintafeira;
		this.sextafeira = sextafeira;
	}

	public boolean isSegundafeira() {
		return segundafeira;
	}

	public void setSegundafeira(boolean segundafeira) {
		this.segundafeira = segundafeira;
	}

	public boolean isTercafeira() {
		return tercafeira;
	}

	public void setTercafeira(boolean tercafeira) {
		this.tercafeira = tercafeira;
	}

	public boolean isQuartafeira() {
		return quartafeira;
	}

	public void setQuartafeira(boolean quartafeira) {
		this.quartafeira = quartafeira;
	}

	public boolean isQuintafeira() {
		return quintafeira;
	}

	public void setQuintafeira(boolean quintafeira) {
		this.quintafeira = quintafeira;
	}

	public boolean isSextafeira() {
		return sextafeira;
	}

	public void setSextafeira(boolean sextafeira) {
		this.sextafeira = sextafeira;
	}

	@Override
	public String toString() {
		StringBuilder dados = new StringBuilder();
		if (isSegundafeira()) {
			dados.append("Segunda-Feira ");
		}
		if (isTercafeira()) {
			dados.append("Terça-Feira ");
		}
		if (isQuartafeira()) {
			dados.append("Quarta-Feira ");
		}
		if (isQuintafeira()) {
			dados.append("Quinta-Feira ");
		}
		if (isSextafeira()) {
			dados.append("Sexta-Feira ");
		}
		return dados.toString();
	}

}
