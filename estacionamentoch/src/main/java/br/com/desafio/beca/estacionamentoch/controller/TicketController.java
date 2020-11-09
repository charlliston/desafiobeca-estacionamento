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

import br.com.desafio.beca.estacionamentoch.controller.dto.TicketRs;
import br.com.desafio.beca.estacionamentoch.model.Ticket;
import br.com.desafio.beca.estacionamentoch.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Ticket>> findAllTickets() {
		List<Ticket> todosTickets = ticketService.findAllTickets();

		return new ResponseEntity<List<Ticket>>(todosTickets, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findTicketById(@PathVariable("id") Long id) {

		return new ResponseEntity<>(ticketService.findTicketById(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> saveTicket(@RequestBody @Valid TicketRs ticketRs) throws Exception {

		return new ResponseEntity<>(ticketService.saveTicket(ticketRs.getVeiculo().getPlaca(), ticketRs.getVaga().getIdVaga()), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteTicketById(@PathVariable("id") Long id) {
		ticketService.deleteTicketById(id);

		return new ResponseEntity<>("Ticket excluído com sucesso!", HttpStatus.OK);
	}

	@PutMapping("/encerra/{id}")
	public ResponseEntity<?> encerraTicket(@PathVariable("id") Long id) {

		return new ResponseEntity<>(ticketService.encerraTicket(id), HttpStatus.OK);
	}
	
}
