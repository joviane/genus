package br.com.caelum.genus.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String contact;
    private String subject;
    private LocalDateTime beginDate;
    private LocalDateTime firstClassDate;
    private Progress progress;
    
    public Trainee() {
	this.progress = new Progress();
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public LocalDateTime getBeginDate() {
        return beginDate;
    }
    public LocalDateTime getFirstClassDate() {
        return firstClassDate;
    }
    public Progress getProgress() {
        return progress;
    }
}
