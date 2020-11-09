package br.com.desafio.beca.estacionamentoch.service.serviceImpl;

//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.Assertions;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.desafio.beca.estacionamentoch.model.Cliente;
import br.com.desafio.beca.estacionamentoch.repository.ClienteRepository;
import br.com.desafio.beca.estacionamentoch.service.ClienteService;

@RunWith(SpringRunner.class)
public class ClienteServiceTest {

	@InjectMocks
	ClienteService clienteService;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	private Cliente cliente;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(1L);
		cliente.setEmail("charliston@gmail.com");
		cliente.setNome("Charlliston");
		cliente.setTelefone("48988089999");
	}
	
	@Test
	public void clienteServiceSave() {
		Mockito.when(clienteRepository.existsById(cliente.getIdCliente())).thenReturn(false);
		Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);
		
		//assertEquals(cliente, clienteService.saveCliente(cliente));
	}
}
