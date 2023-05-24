package com.paduaburguer.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paduaburguer.controllers.ClientController;
import com.paduaburguer.data.dto.ClientDTO;
import com.paduaburguer.data.dto.ClientNewDTO;
import com.paduaburguer.exceptions.RequiredObjectIsNullException;
import com.paduaburguer.exceptions.ResourceNotFoundException;
import com.paduaburguer.model.Address;
import com.paduaburguer.model.Client;
import com.paduaburguer.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<ClientDTO> findAll() {
		
		List<ClientDTO> clients = mapper.map(repository.findAll(), new TypeToken<List<ClientDTO>>() {}.getType());
		
		clients
			.stream()
			.forEach(c -> c.add(linkTo(methodOn(ClientController.class).findById(c.getId())).withSelfRel()));
		
		return clients;		
	}
	
	public ClientDTO findById(Long id) {
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
		
		var cli = mapper.map(entity, ClientDTO.class);
		
		cli.add(linkTo(methodOn(ClientController.class).findById(cli.getId())).withSelfRel());
		
		return cli;
	}
	
	@Transactional
	public ClientNewDTO create(ClientNewDTO client) {
		
		if(client == null) throw new RequiredObjectIsNullException();
		
		var entity = mapper.map(client, Client.class);
		
		Address adr = new Address(null, client.getAddress(), client.getNumber(), client.getComplement(), client.getNeighborhood(), client.getCity(), client.getState(), client.getCep(), entity);
			
		entity.getAddresses().add(adr);
		entity.getTelephones().add(client.getTelephone());
		
		entity.setId(null);
			
		var cli = mapper.map(repository.save(entity), ClientNewDTO.class);
			
		cli.add(linkTo(methodOn(ClientController.class).findById(cli.getId())).withSelfRel());
		
		return cli;
	}
	
	
	public ClientNewDTO update(ClientNewDTO client) {
		
		if(client == null) throw new RequiredObjectIsNullException();
		
		var entity = repository.findById(client.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
		
		Address adr = new Address(null, client.getAddress(), client.getNumber(), client.getComplement(), client.getNeighborhood(), client.getCity(), client.getState(), client.getCep(), entity);
		
		entity.setName(client.getName());
		entity.setCpf(client.getCpf());
		entity.setEmail(client.getEmail());
		
		entity.getAddresses().add(0, adr);
		var t = entity.getTelephones().toArray();
		t[0] = client.getTelephone(); 
		
		var cli = mapper.map(repository.save(entity), ClientNewDTO.class);
		
		cli.add(linkTo(methodOn(ClientController.class).findById(cli.getId())).withSelfRel());
		
		return cli;
	}
	
	public void delete(Long id) {
		
		var cli = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
		
		repository.delete(cli);
	}
}
