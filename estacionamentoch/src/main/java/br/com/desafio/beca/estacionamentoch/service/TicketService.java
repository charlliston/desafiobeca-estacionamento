package br.com.desafio.beca.estacionamentoch.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.desafio.beca.estacionamentoch.model.Ticket;

public interface TicketService {

	public List<Ticket> findAllTickets();
	
	public Ticket findTicketById(Long id);
	
	public Ticket saveTicket(String placa, Long idVaga) throws Exception;
		
	public Double calculaPreco(LocalDateTime horaEntrada, LocalDateTime horaSaida);
	
	public String encerraTicket(Long id);
	
	public void deleteTicketById(Long id);
}
