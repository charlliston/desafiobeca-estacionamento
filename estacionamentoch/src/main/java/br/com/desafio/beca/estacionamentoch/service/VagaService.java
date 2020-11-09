package br.com.desafio.beca.estacionamentoch.service;

import java.util.List;

import br.com.desafio.beca.estacionamentoch.controller.dto.VagaRq;
import br.com.desafio.beca.estacionamentoch.controller.dto.VagaRs;
import br.com.desafio.beca.estacionamentoch.model.Vaga;
import javassist.NotFoundException;

public interface VagaService {

	public List<Vaga> findAllVagas();

	public Vaga findVagaById(Long id);
	
	public Vaga atualizaStatusVaga(Long id);

	public void saveVaga(VagaRs vagaRs);

	public void updateVaga(Long id, VagaRq vagaRq) throws NotFoundException;

	public void deleteVagaById(Long id);	
}