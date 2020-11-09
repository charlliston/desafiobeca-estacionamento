package br.com.desafio.beca.estacionamentoch.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.beca.estacionamentoch.model.Veiculo;
import br.com.desafio.beca.estacionamentoch.repository.VeiculoRepository;
import br.com.desafio.beca.estacionamentoch.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Override
	public List<Veiculo> findAllVeiculos() {
		List<Veiculo> todosVeiculos = veiculoRepository.findAll();

		return todosVeiculos;
	}

	@Override
	public Veiculo findByPlaca(String placa) {
		Veiculo veiculo = veiculoRepository.findByPlaca(placa);

		return veiculo;
	}

	@Override
	public Veiculo findVeiculoById(long id) {
		Veiculo veiculo = veiculoRepository.findById(id).get();

		return veiculo;
	}

	@Override
	public Veiculo saveVeiculo(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

}
