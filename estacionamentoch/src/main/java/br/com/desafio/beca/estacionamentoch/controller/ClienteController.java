package br.com.desafio.beca.estacionamentoch.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.desafio.beca.estacionamentoch.controller.dto.ClienteRq;
import br.com.desafio.beca.estacionamentoch.controller.dto.ClienteRs;
import br.com.desafio.beca.estacionamentoch.model.Cliente;
import br.com.desafio.beca.estacionamentoch.service.ClienteService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/")
	public ResponseEntity<List<Cliente>> findAllClientes() {
		List<Cliente> todosClientes = clienteService.findAllClientes();

		return new ResponseEntity<List<Cliente>>(todosClientes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findClienteById(@PathVariable("id") Long id) {

		return new ResponseEntity<>(clienteService.findClienteById(id), HttpStatus.OK);
	}

	@GetMapping("/localizar/{nome}")
	public ResponseEntity<?> findClienteByNome(@PathVariable("nome") String nome) throws Exception {
		return new ResponseEntity<>(clienteService.findClienteByNome(nome), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> saveCliente(@Valid @RequestBody ClienteRs clienteRs) {
		clienteService.saveClienteRs(clienteRs);

		return new ResponseEntity<>("Cliente cadastrado com sucesso!", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCliente(@Valid @PathVariable("id") Long id, @RequestBody ClienteRq clienteRq) throws NotFoundException {
		clienteService.updateCliente(id, clienteRq);

		return new ResponseEntity<>("Cliente atualizado com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/deletebyname/{nome}")
	public ResponseEntity<?> deleteClienteByNome(@PathVariable("nome") String nome) {
		clienteService.deleteClienteByNome(nome);

		return new ResponseEntity<>("Cliente excluído com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteClienteById(@PathVariable("id") Long id) throws NotFoundException {
		clienteService.deleteClienteById(id);

		return new ResponseEntity<>("Cliente excluído com sucesso!", HttpStatus.OK);
	}

}
