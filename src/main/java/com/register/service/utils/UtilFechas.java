package com.register.service.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UtilFechas {

	public UtilFechas() {
		super();

	}

	/**
	 * Convierte un java.util.Date a java.sql.Date.
	 * 
	 * @param dateIn
	 * @return
	 */
	public static java.sql.Date convertirASqlDate(java.util.Date dateIn) {
		return new java.sql.Date(dateIn.getTime());
	}

	/**
	 * Devuelve verdadero si la fecha es igual a 0001-01-01.
	 * 
	 * @param date
	 * @return
	 */

	/**
	 * Obtiene el fin de mes de una fecha dada.
	 * 
	 * @param fecha
	 * @return
	 */
	public static java.util.Date obtenerFinMes(java.util.Date fecha) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);

		int ultimoDiaMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, ultimoDiaMes);

		return calendar.getTime();

	}

	/**
	 * Obtiene el fin de mes de una fecha dada.
	 * 
	 * @param fecha
	 * @return
	 */
	public static java.sql.Date obtenerFinMes(java.sql.Date fecha) {

		java.util.Date fechaDate = new java.util.Date(fecha.getTime());

		java.util.Date finMesDate = obtenerFinMes(fechaDate);

		return new java.sql.Date(finMesDate.getTime());

	}

	/**
	 * Reseta al información horaria de una fecha, porque a veces impide hacer
	 * comparaciones por igualdad.
	 * 
	 * @param fechaEntrada
	 * @return
	 */
	public static java.util.Date resetearHora(java.util.Date fechaEntrada) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaEntrada);

		resetearHora(calendar);

		return calendar.getTime();
	}

	/**
	 * Reseta al información horaria de una fecha, porque a veces impide hacer
	 * comparaciones por igualdad.
	 * 
	 * @param fechaEntrada
	 * @return
	 */
	public static void resetearHora(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * Reseta al información horaria de una fecha, porque a veces impide hacer
	 * comparaciones por igualdad.
	 * 
	 * @param fechaEntrada
	 * @return
	 */
	public static java.sql.Date resetearHoraSqlDate(java.sql.Date fechaEntradaSql) {
		java.util.Date fechaEntrada = new java.util.Date(fechaEntradaSql.getTime());
		return new java.sql.Date(resetearHora(fechaEntrada).getTime());
	}

	/**
	 * Calcula la diferencia entre dos fechas en días naturales.
	 * 
	 * @param fechaInicio
	 * @return
	 */
	public static BigDecimal numeroDiasNaturales(final java.util.Date fechaInicio, final java.util.Date fechaFin) {
		final java.util.Date fIni = UtilFechas.resetearHora(fechaInicio);
		final java.util.Date fFin = UtilFechas.resetearHora(fechaFin);

		final Calendar calIni = Calendar.getInstance();
		final Calendar calFin = Calendar.getInstance();

// Indica si hay que ir sumando o restando días en función si la fecha de
// fin es mayor (suma) o menor (resta)
		final int incremento;

		if (fIni.compareTo(fFin) <= 0) {
			incremento = 1;
			calIni.setTime(fIni);
			calFin.setTime(fFin);
		} else {
			incremento = -1;
			calIni.setTime(fFin);
			calFin.setTime(fIni);
		}

		int diff = 0;
		int cond = calIni.compareTo(calFin);
		while (cond < 0) {
			diff += incremento;

			calIni.add(Calendar.DAY_OF_YEAR, 1);
			cond = calIni.compareTo(calFin);
		}

		return BigDecimal.valueOf(diff);
	}

	public static String formatea(final Calendar calendar, final String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String d = sdf.format(calendar.getTime());

		return d;
	}

	public static String formatea(final java.util.Date date, final String formato) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);

		String horaFormateada = UtilFechas.formatea(c, formato);

		return horaFormateada;
	}

	public static Calendar obtenCalendar(java.util.Date fecha) {
		Calendar c = Calendar.getInstance();

		c.setTimeInMillis(fecha.getTime());

		return c;
	}

	/**
	 * @param fecha
	 * @param result
	 */
	public static void copiaHora(Calendar fecha, Calendar result) {
		result.set(Calendar.HOUR_OF_DAY, fecha.get(Calendar.HOUR_OF_DAY));
		result.set(Calendar.MINUTE, fecha.get(Calendar.MINUTE));
		result.set(Calendar.SECOND, fecha.get(Calendar.SECOND));
		result.set(Calendar.MILLISECOND, fecha.get(Calendar.MILLISECOND));
	}

	/**
	 * 
	 * @param calendar
	 * @return
	 */
	public static Calendar obtenerFinMesAnterior(final Calendar calendar) {
		Calendar calendarSalida = Calendar.getInstance();
		calendarSalida.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendarSalida.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		calendarSalida.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		calendarSalida.add(Calendar.DAY_OF_MONTH, -1);

		return calendarSalida;

	}

	/**
	 * Obtiene el fin de mes anterior loborable de una fecha.
	 * 
	 * @param fecha
	 * @return
	 */
	public static Calendar obtenerFinMesLaborableAnterior(final Calendar calendar) {
		Calendar calendarSalida = Calendar.getInstance();
		calendarSalida.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		calendarSalida.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		calendarSalida.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));

		calendarSalida.setTime(obtenerFinMesAnterior(calendarSalida).getTime());

		int lastWorkingDay = 0;
		int daysWeek = 7;

		// recorro hasta encontrar lo que necesito
		for (int iterator = 0; iterator < daysWeek; iterator++) {
			calendarSalida.set(Calendar.DAY_OF_MONTH,
					calendarSalida.getActualMaximum(Calendar.DAY_OF_MONTH) - iterator);

			if (!isFinDeSemana(calendarSalida)) {
				lastWorkingDay = calendarSalida.getActualMaximum(Calendar.DAY_OF_MONTH) - iterator;
				break;
			}
		}
		calendarSalida.set(Calendar.DAY_OF_MONTH, lastWorkingDay);

		return calendarSalida;
	}

	/**
	 * Devuelve tru si es fin de semana
	 * 
	 * @param dayOfWeek
	 * @return
	 */
	private static boolean isFinDeSemana(final Calendar calendar) {
		if (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)
				|| Calendar.SATURDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
			return true;
		} else {
			return false;
		}

	}

}
