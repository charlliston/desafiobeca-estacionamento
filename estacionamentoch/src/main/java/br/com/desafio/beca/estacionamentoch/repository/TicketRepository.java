package br.com.desafio.beca.estacionamentoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.beca.estacionamentoch.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	
}