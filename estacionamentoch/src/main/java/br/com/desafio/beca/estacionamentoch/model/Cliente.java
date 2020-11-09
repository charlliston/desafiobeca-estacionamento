package br.com.desafio.beca.estacionamentoch.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_CLIENTE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;

	@NotBlank(message="Por favor, insira um nome.")
	private String nome;

	@NotBlank(message="Por favor, insira um número de telefone.")
	private String telefone;

	@NotBlank(message="Por favor, insira um email.")
	@Email(message="Por favor, insira um email válido.")
	private String email;

	public Cliente() {}

	public Cliente(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long codCliente) {
		this.idCliente = codCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 23;
		int result = 1;
		result = prime * result + Objects.hashCode(this.idCliente);

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
		final Cliente other = (Cliente) obj; // casting
		if (!Objects.equals(this.idCliente, other.idCliente)) {
			return false;
		}
		return true;
	}

}
