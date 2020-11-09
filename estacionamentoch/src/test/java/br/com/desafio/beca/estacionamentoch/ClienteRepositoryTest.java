package br.com.desafio.beca.estacionamentoch;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.desafio.beca.estacionamentoch.model.Cliente;
import br.com.desafio.beca.estacionamentoch.repository.ClienteRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	public void whenCreateThenPersistData () {
		Cliente cliente = new Cliente("Maria", "48988081111", "maria@gmail.com");
		this.clienteRepository.save(cliente);
		
		Assertions.assertThat(cliente.getIdCliente()).isNotNull();
		Assertions.assertThat(cliente.getNome()).isEqualTo("Maria");
		Assertions.assertThat(cliente.getTelefone()).isEqualTo("48988081111");
		Assertions.assertThat(cliente.getEmail()).isEqualTo("maria@gmail.com");	

	}
}
