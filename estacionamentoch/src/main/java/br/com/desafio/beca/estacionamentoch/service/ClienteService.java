package br.com.desafio.beca.estacionamentoch.service;

import java.util.List;

import br.com.desafio.beca.estacionamentoch.controller.dto.ClienteRq;
import br.com.desafio.beca.estacionamentoch.controller.dto.ClienteRs;
import br.com.desafio.beca.estacionamentoch.model.Cliente;
import javassist.NotFoundException;

public interface ClienteService {

	public List<Cliente> findAllClientes();

	public List<Cliente> findClienteByNome(String nome) throws Exception;

	public Cliente findClienteById(Long id);
	
	public void updateCliente(Long id, ClienteRq clienteRq) throws NotFoundException;

	public void saveClienteRs(ClienteRs clienteRs);
	
	public void saveCliente(Cliente cliente);

	public void deleteClienteByNome(String nome);

	public void deleteClienteById(Long id) throws NotFoundException;
	


}
