package br.com.desafio.beca.estacionamentoch.controller.dto;

import br.com.desafio.beca.estacionamentoch.model.Cliente;

public class VeiculoRs {

	private Long idVeiculo;
	private String placa;
	private Cliente cliente;

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
