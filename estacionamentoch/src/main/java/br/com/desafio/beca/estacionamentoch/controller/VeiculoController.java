package br.com.desafio.beca.estacionamentoch.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.beca.estacionamentoch.model.Veiculo;
import br.com.desafio.beca.estacionamentoch.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping("/")
	public ResponseEntity<List<Veiculo>> findAllVeiculos() {
		List<Veiculo> todosVeiculos = veiculoService.findAllVeiculos();

		return new ResponseEntity<List<Veiculo>>(todosVeiculos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findVeiculoById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(veiculoService.findVeiculoById(id), HttpStatus.OK);
	}

	@PostMapping("/novoveiculo")
	public ResponseEntity<?> saveVeiculo(@Valid @RequestBody Veiculo veiculo) {
		return new ResponseEntity<>(veiculoService.saveVeiculo(veiculo), HttpStatus.CREATED);
	}

	@GetMapping("/placa/{placa}")
	public ResponseEntity<?> findVeiculoByPlaca(@PathVariable("placa") String placa) {
		return new ResponseEntity<>(veiculoService.findByPlaca(placa), HttpStatus.OK);
	}
}
