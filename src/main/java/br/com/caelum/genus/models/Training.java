package br.com.caelum.genus.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Trainee trainee;
    @ManyToOne
    private Trainer trainer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Lob
    private String comments;

    /**
     * @deprecated hibernate eyes only
     */
    public Training() {
    }
    
    public Training(Trainee trainee) {
	this.startTime = LocalDateTime.now();
	this.trainee = trainee;
    }

    public Integer getId() {
        return id;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getComments() {
        return comments;
    }
    
    public void update(String comments) {
	this.comments = comments;
	this.endTime = LocalDateTime.now();
    }
}
