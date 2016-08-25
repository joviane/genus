package br.com.caelum.genus.models;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Progress {

    @Enumerated(EnumType.STRING)
    private Status status;
    private String lastStatusDescription;
    private LocalDateTime lastStatusDate;
 
    public Progress() {
	this.status = Status.TO_START;
    }
    
    public Status getStatus() {
	return status;
    }
}
