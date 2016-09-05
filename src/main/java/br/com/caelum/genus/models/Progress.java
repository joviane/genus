package br.com.caelum.genus.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Embeddable
public class Progress {
    @Enumerated(EnumType.STRING)
    private Status status;
    private String lastStatusDescription;
    private LocalDate lastStatusDate;
    
    public Progress() {
    	this.status = Status.TO_START;
    }
    
    public Status getStatus() {
	return status;
    }
    
    public void setStatus(Status status) {
		this.status = status;
    }

	public String getLastStatusDescription() {
		return lastStatusDescription;
	}

	public void setLastStatusDescription(String lastStatusDescription) {
		this.lastStatusDescription = lastStatusDescription;
	}

	public LocalDate getLastStatusDate() {
		return lastStatusDate;
	}

	public void setLastStatusDate(LocalDate lastStatusDate) {
		this.lastStatusDate = lastStatusDate;
	}
}
