package br.com.desafio.beca.estacionamentoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.beca.estacionamentoch.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository <Veiculo, Long> {

	Veiculo findByPlaca(String placa);

}
