package br.com.desafio.beca.estacionamentoch.controller.dto;

public class VagaRs {

	private Long idVaga;
	private int numeroVaga;
	private boolean livre = true;

	public Long getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Long idVaga) {
		this.idVaga = idVaga;
	}

	public int getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public boolean getLivre() {
		return livre;
	}

	public void setDisponibilidade(boolean livre) {
		this.livre = livre;
	}

}
