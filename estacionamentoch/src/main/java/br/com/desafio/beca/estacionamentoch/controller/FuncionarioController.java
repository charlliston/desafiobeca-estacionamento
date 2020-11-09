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

import br.com.desafio.beca.estacionamentoch.controller.dto.FuncionarioRq;
import br.com.desafio.beca.estacionamentoch.controller.dto.FuncionarioRs;
import br.com.desafio.beca.estacionamentoch.model.Funcionario;
import br.com.desafio.beca.estacionamentoch.service.FuncionarioService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> findAllFuncionarios() {
		List<Funcionario> todosFuncionarios = funcionarioService.findAllFuncionarios();

		return new ResponseEntity<List<Funcionario>>(todosFuncionarios, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findFuncionarioById(@PathVariable("id") Long id) {

		return new ResponseEntity<>(funcionarioService.findFuncionarioById(id), HttpStatus.OK);
	}

	@GetMapping("/localizar/{nome}")
	public ResponseEntity<?> findFuncionarioByNome(@PathVariable("nome") String nome) {
		return new ResponseEntity<>(funcionarioService.findFuncionarioByNome(nome), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> saveFuncionario(@RequestBody FuncionarioRs funcionarioRs) {
		funcionarioService.saveFuncionario(funcionarioRs);

		return new ResponseEntity<>("Funcionário cadastrado com sucesso!", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateFuncionario(@PathVariable("id") Long id, @RequestBody FuncionarioRq funcionarioRq) throws NotFoundException {
		funcionarioService.updateFuncionario(id, funcionarioRq);

		return new ResponseEntity<>("Funcionário atualizado com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/deletebyname/{nome}")
	public ResponseEntity<?> deleteFuncionarioByNome(@PathVariable("nome") String nome) {
		funcionarioService.deleteFuncionarioByNome(nome);

		return new ResponseEntity<>("Funcionário excluído com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteFuncionarioById(@PathVariable("id") Long id) throws NotFoundException {
		funcionarioService.deleteFuncionarioById(id);

		return new ResponseEntity<>("Funcionário excluído com sucesso!", HttpStatus.OK);
	}

}
