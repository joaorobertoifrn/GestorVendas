package br.com.helpc.gestorvendas.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.helpc.gestorvendas.domain.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L; 

	private Integer id;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=10, max=150, message="O tamanho deve ser entre 10 e 150 caracteres.")
	private String nome;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email(message="E-mail inválido.")
	private String email;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}
}


