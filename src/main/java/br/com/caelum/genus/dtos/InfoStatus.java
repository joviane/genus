package br.com.caelum.genus.dtos;

import br.com.caelum.genus.models.Status;

public class InfoStatus {

	private Status status;
	
	private Long traineeId;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long id) {
		this.traineeId = id;
	}

}
