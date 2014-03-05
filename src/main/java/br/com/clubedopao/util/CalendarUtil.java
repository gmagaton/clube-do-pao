package br.com.clubedopao.util;

import java.util.Calendar;

public final class CalendarUtil {

	public static Calendar getCalendarSomenteDiaMesAno(final Calendar data) {
		final Calendar dataSomenteDiaMesAno = (Calendar) data.clone();
		dataSomenteDiaMesAno.clear();
		dataSomenteDiaMesAno.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH));
		dataSomenteDiaMesAno.set(Calendar.MONTH, data.get(Calendar.MONTH));
		dataSomenteDiaMesAno.set(Calendar.YEAR, data.get(Calendar.YEAR));
		return dataSomenteDiaMesAno;
	}

	public static Calendar getCalendarPorDiaMesAno(final int dia, final int mes, final int ano) {
		final Calendar dataTabela = Calendar.getInstance();
		dataTabela.clear();
		dataTabela.set(Calendar.DAY_OF_MONTH, dia);
		dataTabela.set(Calendar.MONTH, mes - 1);
		dataTabela.set(Calendar.YEAR, ano);
		return dataTabela;
	}

	public static Calendar getDataEntreSegundaSexta(final Calendar dataInicio) {
		final int diaSemanaDataInicio = dataInicio.get(Calendar.DAY_OF_WEEK);
		switch (diaSemanaDataInicio) {
		case Calendar.SUNDAY:
		case Calendar.SATURDAY:
			dataInicio.roll(Calendar.DAY_OF_YEAR, true);
			return getDataEntreSegundaSexta(dataInicio);
		default:
			return dataInicio;
		}
	}

	public static String getDia(final Calendar data) {
		String dia = "";
		final int diaSemana = data.get(Calendar.DAY_OF_WEEK);
		switch (diaSemana) {
		case Calendar.MONDAY:
			dia = "Segunda-Feira";
			break;
		case Calendar.TUESDAY:
			dia = "Terça-Feira";
			break;
		case Calendar.WEDNESDAY:
			dia = "Quarta-Feira";
			break;
		case Calendar.THURSDAY:
			dia = "Quinta-Feira";
			break;
		case Calendar.FRIDAY:
			dia = "Sexta-Feira";
			break;

		default:
			break;
		}

		return dia;

	}

}
