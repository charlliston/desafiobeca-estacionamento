package br.com.desafio.beca.estacionamentoch.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.beca.estacionamentoch.controller.dto.ClienteRq;
import br.com.desafio.beca.estacionamentoch.controller.dto.ClienteRs;
import br.com.desafio.beca.estacionamentoch.model.Cliente;
import br.com.desafio.beca.estacionamentoch.repository.ClienteRepository;
import br.com.desafio.beca.estacionamentoch.service.ClienteService;
import javassist.NotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAllClientes() {
		List<Cliente> todosClientes = clienteRepository.findAll();

		return todosClientes;
	}

	@Override
	public List<Cliente> findClienteByNome(String nome) throws Exception {
		List<Cliente> clientes = new ArrayList<Cliente>();

		findAllClientes().forEach(c -> {
			if (c.getNome().equals(nome)) {
				clientes.add(c);
			}
		});

		if (clientes.isEmpty()) {
			throw new Exception("Nenhum cliente encontrado para o nome: " + nome);
		}
		return clientes;
	}

	@Override
	public Cliente findClienteById(Long id) {
		Cliente cliente = clienteRepository.findById(id).get();

		return cliente;
	}

	@Override
	public void updateCliente(Long id, ClienteRq clienteRq) throws NotFoundException {
		var c = clienteRepository.findById(id);

		if (c.isPresent()) {
			var clienteSave = c.get();
			clienteSave.setNome(clienteRq.getNome());
			clienteSave.setTelefone(clienteRq.getTelefone());
			clienteSave.setEmail(clienteRq.getEmail());

			clienteRepository.save(clienteSave);
		} else {
			throw new NotFoundException("Cliente não encontrado");
		}
	}

	@Override
	public void saveClienteRs(ClienteRs clienteRs) {
		var c = new Cliente();

		c.setNome(clienteRs.getNome());
		c.setTelefone(clienteRs.getTelefone());
		c.setEmail(clienteRs.getEmail());

		clienteRepository.save(c);
	}

	@Override
	public void deleteClienteByNome(String nome) {
		Cliente cliente = clienteRepository.findClienteByNome(nome);

		clienteRepository.delete(cliente);
	}

	@Override
	public void deleteClienteById(Long id) throws NotFoundException {
		var c = clienteRepository.findById(id);

		if (c.isPresent()) {
			clienteRepository.deleteById(id);
		} else {
			throw new NotFoundException("Cliente não encontrado");
		}
	}

	@Override
	public void saveCliente(Cliente cliente) {
		var c = new Cliente();

		c.setNome(cliente.getNome());
		c.setTelefone(cliente.getTelefone());
		c.setEmail(cliente.getEmail());

		clienteRepository.save(c);		
	}

}
