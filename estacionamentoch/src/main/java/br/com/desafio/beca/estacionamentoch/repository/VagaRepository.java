package br.com.desafio.beca.estacionamentoch.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.beca.estacionamentoch.model.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long>{
}
