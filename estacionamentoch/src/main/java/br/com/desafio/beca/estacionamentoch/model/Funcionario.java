package br.com.desafio.beca.estacionamentoch.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="TB_FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFuncionario;
	
	@NotBlank(message="Por favor, insira um nome.")
	private String nome;
	
	@NotBlank(message="Por favor, insira um cargo")
	private String cargo;

	public Funcionario() {}

	public Funcionario (Long idFuncionario, String nome, String cargo) {
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cargo = cargo;
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	@Override
	public String toString() {
		return "Funcionario {"+ "Código do funcionário: " +idFuncionario + ", Nome: " +nome + ", Cargo: " +cargo + '}';
	}
	
	@Override
	public int hashCode() {
		final int prime = 11;
		int result = 1;
		result = prime * result + Objects.hashCode(this.idFuncionario);
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Funcionario other = (Funcionario) obj; //casting
		if (!Objects.equals(this.idFuncionario, other.idFuncionario)) {
			return false;
		}
		return true;
	}
}

