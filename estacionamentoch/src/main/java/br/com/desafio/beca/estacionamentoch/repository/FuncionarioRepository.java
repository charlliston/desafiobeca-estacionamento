package br.com.desafio.beca.estacionamentoch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.beca.estacionamentoch.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findFuncionarioByNome(String nome);
	Funcionario deleteFuncionarioByNome(String nome);
}
