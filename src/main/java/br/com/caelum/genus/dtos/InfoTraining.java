package br.com.caelum.genus.dtos;

import org.hibernate.validator.constraints.NotBlank;

import br.com.caelum.genus.models.Training;

public class InfoTraining {

    @NotBlank
    private String comments;
    private Integer trainingId;
    
    
    public void updateTrainingDataFromForm(Training training) {
	training.update(comments);
    }

    public Integer getTrainingId() {
	return this.trainingId;
    }

    public void setTrainingId(Integer trainingId) {
	this.trainingId = trainingId;
    }

    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }
    
}
