package br.com.desafio.beca.estacionamentoch.controller.dto;

public class VagaRq {

	private int numeroVaga;
	private boolean livre = true;

	
	public int getNumeroVaga() {
		return numeroVaga;
	}
	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}
	public boolean getLivre() {
		return livre;
	}
	public void setLivre(boolean livre) {
		this.livre = true;
	}
}
