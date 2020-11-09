package br.com.desafio.beca.estacionamentoch.service;

import java.util.List;

import br.com.desafio.beca.estacionamentoch.model.Veiculo;

public interface VeiculoService {

	public List<Veiculo> findAllVeiculos();

	public Veiculo findByPlaca(String placa);
	
	public Veiculo findVeiculoById(long cod);

	public Veiculo saveVeiculo(Veiculo veiculo);

}
