package com.paduaburguer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column
	private Date date;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "delivery_address_id")
	private Address delivery_address;
	
	@OneToMany(mappedBy = "id.orders", cascade = CascadeType.ALL)
	private Set<OrderProducts> itens = new HashSet<>();
	
	public Orders() {}

	public Orders(Long id, Date date, Client client, Address delivery_address) {
		super();
		this.id = id;
		this.date = date;
		this.client = client;
		this.delivery_address = delivery_address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}

	public Address getDeliveryAddress() {
		return delivery_address;
	}

	public void setDeliveryAddress(Address delivery_address) {
		this.delivery_address = delivery_address;
	}
	
	public Set<OrderProducts> getItens() {
		return itens;
	}

	public void setItens(Set<OrderProducts> itens) {
		this.itens = itens;
	}
	
	public double getTotal() {
		double soma = 0.0;
		for (OrderProducts i: itens) {
			soma = soma + i.getSubTotal();
		}
		return soma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
