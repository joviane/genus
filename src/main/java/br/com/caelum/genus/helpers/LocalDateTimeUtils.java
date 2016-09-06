package br.com.caelum.genus.helpers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeUtils {

	public static String diferencaEmHorasEMinutosEntre(LocalDateTime startTime, LocalDateTime endTime) {
		long minutes = ChronoUnit.MINUTES.between(startTime, endTime)%60;
		long hours = ChronoUnit.HOURS.between(startTime, endTime);
		return hours + ":" + minutes;
	}
	
}
