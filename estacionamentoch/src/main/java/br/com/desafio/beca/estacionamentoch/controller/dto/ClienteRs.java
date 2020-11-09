package br.com.desafio.beca.estacionamentoch.controller.dto;

import java.util.List;

import br.com.desafio.beca.estacionamentoch.model.Veiculo;

public class ClienteRs {

	private Long idCliente;
	private String nome;
	private String telefone;
	private String email;
	private List<Veiculo> veiculos;


	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Veiculo> getVeiculo() {
		return veiculos;
	}

	public void setVeiculo(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
