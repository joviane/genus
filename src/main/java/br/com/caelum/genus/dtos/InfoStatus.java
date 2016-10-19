package br.com.caelum.genus.dtos;

import br.com.caelum.genus.models.Status;

public class InfoStatus {

    private Status status;

    private Integer traineeId;

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    public Integer getTraineeId() {
	return traineeId;
    }

    public void setTraineeId(Integer id) {
	this.traineeId = id;
    }

}
