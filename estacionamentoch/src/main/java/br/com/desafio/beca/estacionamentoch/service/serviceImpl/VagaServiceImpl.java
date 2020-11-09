package br.com.desafio.beca.estacionamentoch.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.beca.estacionamentoch.controller.dto.VagaRq;
import br.com.desafio.beca.estacionamentoch.controller.dto.VagaRs;
import br.com.desafio.beca.estacionamentoch.model.Vaga;
import br.com.desafio.beca.estacionamentoch.repository.VagaRepository;
import br.com.desafio.beca.estacionamentoch.service.VagaService;
import javassist.NotFoundException;

@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	VagaRepository vagaRepository;

	@Override
	public List<Vaga> findAllVagas() {
		List<Vaga> todasVagas = vagaRepository.findAll();

		return todasVagas;
	}

	@Override
	public Vaga findVagaById(Long id) {
		Vaga vaga = vagaRepository.findById(id).get();

		return vaga;
	}

	@Override
	public Vaga atualizaStatusVaga(Long id) {
		Vaga vaga = vagaRepository.findById(id).get();

		if (vaga.getLivre()) {
			vaga.setLivre(false);
		} else {
			vaga.setLivre(true);
		}

		return vagaRepository.save(vaga);
	}

	@Override
	public void saveVaga(VagaRs vagaRs) {
		var v = new Vaga();

		v.setNumeroVaga(v.getNumeroVaga());
		v.setLivre(v.getLivre());

		vagaRepository.save(v);
	}

	@Override
	public void updateVaga(Long id, VagaRq vagaRq) throws NotFoundException {
		var v = vagaRepository.findById(id);

		if (v.isPresent()) {
			var vagaSave = v.get();
			vagaSave.setNumeroVaga(vagaRq.getNumeroVaga());
			vagaSave.setLivre(vagaRq.getLivre());

			vagaRepository.save(vagaSave);
		} else
			throw new NotFoundException("Vaga não encontrada!");
	}

	@Override
	public void deleteVagaById(Long id) {
		vagaRepository.deleteById(id);
	}

}
