package br.com.caelum.genus.dtos;

public class InfoHorasGastas {

    private String nome;
    private long numeroTreinos;
    private String totalTempo;

    public InfoHorasGastas(String nome, long numeroTreinos, long totalHoras, long totalMinutos) {
	this.nome = nome;
	this.numeroTreinos = numeroTreinos;
	this.totalTempo = tempoTotalEmString(totalHoras, totalMinutos);
    }

    public String getNome() {
	return nome;
    }

    public long getNumeroTreinos() {
	return numeroTreinos;
    }

    public String getTotalTempo() {
	return totalTempo;
    }

    private String tempoTotalEmString(long totalHoras, long totalMinutos) {
	long minutos = totalHoras * 60 + totalMinutos;
	return minutos / 60 + ":" + minutos % 60;
    }

}
