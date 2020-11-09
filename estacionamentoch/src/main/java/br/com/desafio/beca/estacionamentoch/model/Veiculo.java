package br.com.desafio.beca.estacionamentoch.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="TB_VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVeiculo;
	
	private String placa;
	
	@ManyToOne
	private Cliente cliente;
	
	public Veiculo() {}
	
	public Veiculo (Long idVeiculo, String placa, Cliente cliente) {
		this.idVeiculo = idVeiculo;
		this.placa = placa;
		this.cliente = cliente;
	}

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
