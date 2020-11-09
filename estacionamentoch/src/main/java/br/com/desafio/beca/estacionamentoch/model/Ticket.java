package br.com.desafio.beca.estacionamentoch.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="TB_TICKET")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTicket;
	
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private Double preco;
		
	@OneToOne
	@NotBlank(message="Vaga obrigatória")
	Vaga vaga;
	
	@OneToOne
	@NotBlank(message="Veículo obrigatório")
	private Veiculo veiculo;
		

	public Ticket() {}
	
	public Ticket(Veiculo veiculo, Vaga vaga, LocalDateTime horaEntrada) {
		super();
		this.horaEntrada = horaEntrada;
		this.vaga = vaga;
		this.veiculo = veiculo;
	}	
	
	public Long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
}
