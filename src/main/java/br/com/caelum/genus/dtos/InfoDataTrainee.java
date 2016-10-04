package br.com.caelum.genus.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class InfoDataTrainee {

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate inicio;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fim;

    public LocalDate getInicio() {
	return inicio;
    }

    public void setInicio(LocalDate inicio) {
	this.inicio = inicio;
    }

    public LocalDate getFim() {
	return fim;
    }

    public void setFim(LocalDate fim) {
	this.fim = fim;
    }
}
