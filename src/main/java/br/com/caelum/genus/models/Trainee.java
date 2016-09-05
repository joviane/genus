package br.com.caelum.genus.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    @OneToMany
    private List<Falta> faltas;
	
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
	
	public boolean firstTraining() {
		return progress.getStatus() == Status.TO_START;
	}

	public void hasBegan() {
		this.progress.setStatus(Status.BEGAN);
	}

	public void setStatus(Status status) {
		this.progress.setStatus(status);
	}

	public void changeStatus(Falta falta) {
		this.faltas.add(falta);
		this.progress.setLastStatusDescription("Faltou");
		this.progress.setLastStatusDate(falta.getData());
	}
	
	public List<Falta> getFaltas() {
		return faltas;
	}
	
	public Falta ultimaFalta(){
		return faltas.get(faltas.size()-1);
	}
	
}
