package br.com.desafio.beca.estacionamentoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.beca.estacionamentoch.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findClienteByNome(String nome);
	Cliente deleteClienteByNome(String nome);
}
