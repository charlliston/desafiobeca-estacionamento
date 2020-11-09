package br.com.desafio.beca.estacionamentoch.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_VAGA")
public class Vaga {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public void setLivre(boolean livre) {
		this.livre = livre;
	}
	
	@Override
	public int hashCode() {
		final int prime = 19;
		int result = 1;
		result = prime * result + Objects.hashCode(this.idVaga);
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Vaga other = (Vaga) obj; //casting
		if (!Objects.equals(this.idVaga, other.idVaga)) {
			return false;
		}
		return true;
	}
}

