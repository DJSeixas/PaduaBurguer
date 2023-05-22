package com.paduaburguer.data.dto;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.hateoas.RepresentationModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ClientNewDTO extends RepresentationModel<ClientNewDTO> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String address;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private int number;
	
	private String complement;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String neighborhood;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String city;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String state;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cep;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String telephone;
	

	public ClientNewDTO() {
	}


	public ClientNewDTO(long id, String name, String email, String cpf,
			String address, int number, String complement, String neighborhood, String city,
			String state, String cep, String telephone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.address = address;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.cep = cep;
		this.telephone = telephone;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public String getNeighborhood() {
		return neighborhood;
	}


	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientNewDTO other = (ClientNewDTO) obj;
		return id == other.id;
	}
	
	
	
}
