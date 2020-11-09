package br.com.desafio.beca.estacionamentoch.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.beca.estacionamentoch.controller.dto.FuncionarioRq;
import br.com.desafio.beca.estacionamentoch.controller.dto.FuncionarioRs;
import br.com.desafio.beca.estacionamentoch.model.Funcionario;
import br.com.desafio.beca.estacionamentoch.repository.FuncionarioRepository;
import br.com.desafio.beca.estacionamentoch.service.FuncionarioService;
import javassist.NotFoundException;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> findAllFuncionarios() {
		List<Funcionario> todosFuncionarios = funcionarioRepository.findAll();

		return todosFuncionarios;
	}

	@Override
	public Funcionario findFuncionarioByNome(String nome) {
		Funcionario funcionario = funcionarioRepository.findFuncionarioByNome(nome);

		return funcionario;
	}

	@Override
	public Funcionario findFuncionarioById(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();

		return funcionario;
	}

	@Override
	public void updateFuncionario(Long id, FuncionarioRq funcionarioRq) throws NotFoundException {
		var f = funcionarioRepository.findById(id);

		if (f.isPresent()) {
			var funcionarioSave = f.get();
			funcionarioSave.setNome(funcionarioRq.getNome());
			funcionarioSave.setCargo(funcionarioRq.getCargo());

			funcionarioRepository.save(funcionarioSave);
		} else
			throw new NotFoundException("Funcionário não encontrado");
	}

	@Override
	public void saveFuncionario(FuncionarioRs funcionarioRs) {
		var f = new Funcionario();
		f.setNome(funcionarioRs.getNome());
		f.setCargo(funcionarioRs.getCargo());

		funcionarioRepository.save(f);
	}

	@Override
	public void deleteFuncionarioByNome(String nome) {
		Funcionario funcionario = funcionarioRepository.findFuncionarioByNome(nome);

		funcionarioRepository.delete(funcionario);

	}

	@Override
	public void deleteFuncionarioById(Long id) throws NotFoundException {
		var f = funcionarioRepository.findById(id);
		if (f.isPresent()) {

			funcionarioRepository.deleteById(id);
		} else {
			throw new NotFoundException("Funcionário não encontrado");
		}
	}

}
