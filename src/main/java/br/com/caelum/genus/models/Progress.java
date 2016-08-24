package br.com.caelum.genus.models;

import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Progress {

    @Enumerated(EnumType.STRING)
    private Status status;
    private String description;
    private Calendar lastStatusDate;
 
    public Progress() {
	this.status = Status.TO_START;
    }
}
