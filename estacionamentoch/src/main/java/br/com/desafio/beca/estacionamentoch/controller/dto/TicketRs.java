package br.com.desafio.beca.estacionamentoch.controller.dto;

import java.time.LocalDateTime;

import br.com.desafio.beca.estacionamentoch.model.Cliente;
import br.com.desafio.beca.estacionamentoch.model.Vaga;
import br.com.desafio.beca.estacionamentoch.model.Veiculo;

public class TicketRs {

	public TicketRs( Veiculo veiculo, Vaga vaga, LocalDateTime horaEntrada) {
		super();
		this.vaga = vaga;
		this.veiculo = veiculo;
		this.horaEntrada = horaEntrada;
	}

	private Long idTicket;
	private Long numeroTicket;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private Double preco;
	private Vaga vaga;
	private Veiculo veiculo;
	private Cliente cliente;

	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(Long numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

}
