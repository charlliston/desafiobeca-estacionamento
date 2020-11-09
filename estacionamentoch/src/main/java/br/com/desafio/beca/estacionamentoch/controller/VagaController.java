package br.com.desafio.beca.estacionamentoch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.beca.estacionamentoch.controller.dto.VagaRq;
import br.com.desafio.beca.estacionamentoch.controller.dto.VagaRs;
import br.com.desafio.beca.estacionamentoch.model.Vaga;
import br.com.desafio.beca.estacionamentoch.service.VagaService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/vagas")
public class VagaController {

	@Autowired
	private VagaService vagaService;

	@GetMapping("/")
	public ResponseEntity<List<Vaga>> findAllVagas() {
		List<Vaga> todasVagas = vagaService.findAllVagas();

		return new ResponseEntity<List<Vaga>>(todasVagas, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findVagaById(@PathVariable("id") Long id) {

		return new ResponseEntity<>(vagaService.findVagaById(id), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> saveVaga(@RequestBody VagaRs vagaRs) {
		vagaService.saveVaga(vagaRs);

		return new ResponseEntity<>("Vaga cadastrada com sucesso!", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateVaga(@PathVariable("id") Long id, @RequestBody VagaRq vagaRq)
			throws NotFoundException {
		vagaService.updateVaga(id, vagaRq);

		return new ResponseEntity<>("Vaga atualizada com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteVagaById(@PathVariable("id") Long id) {
		vagaService.deleteVagaById(id);

		return new ResponseEntity<>("Vaga excluída com sucesso!", HttpStatus.OK);
	}

}
