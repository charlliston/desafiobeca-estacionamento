package br.com.desafio.beca.estacionamentoch.service;

import java.util.List;


import br.com.desafio.beca.estacionamentoch.controller.dto.FuncionarioRq;
import br.com.desafio.beca.estacionamentoch.controller.dto.FuncionarioRs;
import br.com.desafio.beca.estacionamentoch.model.Funcionario;
import javassist.NotFoundException;

public interface FuncionarioService {

	public List<Funcionario> findAllFuncionarios();

	public Funcionario findFuncionarioByNome(String nome);

	public Funcionario findFuncionarioById(Long id);
	
	public void updateFuncionario(Long id, FuncionarioRq FuncionarioRq) throws NotFoundException;

	public void saveFuncionario(FuncionarioRs FuncionarioRs);

	public void deleteFuncionarioByNome(String nome);

	public void deleteFuncionarioById(Long id) throws NotFoundException;


}
