package br.com.desafio.beca.estacionamentoch.service.serviceImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.beca.estacionamentoch.model.Ticket;
import br.com.desafio.beca.estacionamentoch.model.Vaga;
import br.com.desafio.beca.estacionamentoch.model.Veiculo;
import br.com.desafio.beca.estacionamentoch.repository.TicketRepository;
import br.com.desafio.beca.estacionamentoch.service.TicketService;
import br.com.desafio.beca.estacionamentoch.service.VagaService;
import br.com.desafio.beca.estacionamentoch.service.VeiculoService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	VagaService vagaService;

	@Autowired
	VeiculoService veiculoService;

	@Override
	public List<Ticket> findAllTickets() {
		List<Ticket> todosTickets = ticketRepository.findAll();

		return todosTickets;
	}

	@Override
	public Ticket findTicketById(Long id) {
		Ticket ticket = ticketRepository.findById(id).get();

		return ticket;
	}

	@Override
	public Ticket saveTicket(String placa, Long idVaga) throws Exception {
		Veiculo veiculo = veiculoService.findByPlaca(placa);
		Vaga vaga = vagaService.findVagaById(idVaga);

		if (vaga.getLivre()) {
			vaga = vagaService.atualizaStatusVaga(vaga.getIdVaga());
			Ticket tckt = new Ticket(veiculo, vaga, LocalDateTime.now());
			Ticket response = ticketRepository.save(tckt);

			return response;
		} else {
			throw new Exception("Vaga ocupada");
		}

	}

	@Override
	public Double calculaPreco(LocalDateTime horaEntrada, LocalDateTime horaSaida) {
		long tempo = horaEntrada.until(horaSaida, ChronoUnit.MINUTES);

		Double valorAPagar = tempo * 5.0;

		return valorAPagar;
	}

	@Override
	public String encerraTicket(Long id) {
		Optional<Ticket> tckt = ticketRepository.findById(id);

		Ticket novoTicket = tckt.get();

		if (novoTicket.getHoraSaida() != null) {
			return "Ticket já encerrado";
		} else {
			novoTicket.setHoraSaida(LocalDateTime.now());
			novoTicket.setPreco(calculaPreco(novoTicket.getHoraEntrada(), novoTicket.getHoraSaida()));
			vagaService.atualizaStatusVaga(((Vaga) novoTicket.getVaga()).getIdVaga());

			return "Ticket encerrado. O valor para pagamento é: " + novoTicket.getPreco();
		}
	}

	@Override
	public void deleteTicketById(Long id) {
		ticketRepository.deleteById(id);
	}

}
