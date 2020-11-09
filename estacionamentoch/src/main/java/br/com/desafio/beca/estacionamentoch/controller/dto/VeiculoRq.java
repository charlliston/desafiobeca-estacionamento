package br.com.desafio.beca.estacionamentoch.controller.dto;

import br.com.desafio.beca.estacionamentoch.model.Cliente;

public class VeiculoRq {

	private String placa;
	private Cliente cliente;
	
	
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
