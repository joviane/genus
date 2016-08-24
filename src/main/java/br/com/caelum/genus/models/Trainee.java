package br.com.caelum.genus.models;

import java.util.Calendar;

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
    private Calendar beginDate;
    private Calendar firstClassDate;
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
    public Calendar getBeginDate() {
        return beginDate;
    }
    public Calendar getFirstClassDate() {
        return firstClassDate;
    }
    public Progress getProgress() {
        return progress;
    }
}
