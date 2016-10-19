package br.com.caelum.genus.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.caelum.genus.helpers.LocalDateTimeUtils;
import br.com.caelum.genus.models.Training;

public class InfoHorasDetalhado {

    private String traineeNome;
    private LocalDate dia;
    private String tempoGasto;
    private String comments;

    public InfoHorasDetalhado(Training t) {
	this.traineeNome = t.getTrainee().getName();
	this.dia = t.getStartTime().toLocalDate();
	this.tempoGasto = LocalDateTimeUtils.diferencaEmHorasEMinutosEntre(t.getStartTime(), t.getEndTime());
	this.comments = t.getComments();
    }

    public String getTraineeNome() {
	return traineeNome;
    }

    public String getDia() {
	return dia.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getTempoGasto() {
	return tempoGasto;
    }

    public String getComments() {
	return this.comments;
    }

}
