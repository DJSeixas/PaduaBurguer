package com.paduaburguer.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.paduaburguer.data.dto.ClientNewDTO;
import com.paduaburguer.model.Address;
import com.paduaburguer.model.Client;


public class ClientConverterTest {
	
	ModelMapper mapper;
	
	@BeforeEach
    public void setUp() {
        mapper = new ModelMapper();
    }
	
	@Test
	public void clientToNewDTOConverterTest() {
		
		Client client = new Client(1L, "Name Test", "emailtest@www.com", "12345678900");
		Address address = new Address(1L, "Address Test", 0, "Complement", "Neighborhood Test", "City Test", "State Test", "0000000", client);
		
		client.getAddresses().add(address);
		client.getTelephones().add("123456789");
		
		System.out.println(
		client.getAddresses()
			.stream()
		);
		
		for(Address ad: client.getAddresses()) {
			System.out.println(ad.getAddress());
		}
		
		ClientNewDTO dto = mapper.map(client, ClientNewDTO.class);
		
		assertEquals(dto.getId(), client.getId());
		assertEquals(dto.getName(), client.getName());
		assertEquals(dto.getEmail(), client.getEmail());
		assertEquals(dto.getCpf(), client.getCpf());
		assertEquals(dto.getAddress(), client.getAddresses());
		assertEquals(dto.getNumber(), client.getAddresses());
		assertEquals(dto.getComplement(), client.getAddresses());
		assertEquals(dto.getNeighborhood(), client.getAddresses());
		assertEquals(dto.getCity(), client.getAddresses());
		assertEquals(dto.getState(), client.getAddresses());
		assertEquals(dto.getCep(), client.getAddresses());
		
	}
	
	@Test
	public void newDTOToClientConverterTest() {
		
		ClientNewDTO client = new ClientNewDTO(1L, "Name Test", "emailtest@www.com", "12345678900", "Address Test", 0, "Complement", "Neighborhood Test", "City Test", "State Test", "0000000", "123456789");
		
		Client entity = mapper.map(client, Client.class);
		
		assertEquals(entity.getId(), client.getId());
		assertEquals(entity.getName(), client.getName());
		assertEquals(entity.getEmail(), client.getEmail());
		assertEquals(entity.getCpf(), client.getCpf());
		assertEquals(entity.getAddresses(), client.getAddress());
		assertEquals(entity.getTelephones(), client.getTelephone());
		assertEquals(entity.getAddresses(), client.getCity());
		
	}
	
}
