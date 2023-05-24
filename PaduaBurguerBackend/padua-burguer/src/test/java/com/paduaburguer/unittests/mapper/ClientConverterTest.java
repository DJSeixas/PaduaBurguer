package com.paduaburguer.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import com.paduaburguer.data.dto.ClientNewDTO;
import com.paduaburguer.model.Address;
import com.paduaburguer.model.Client;

public class ClientConverterTest {

	private ModelMapper mapper = new ModelMapper();
	
	  public class ClientToNewDTOConverter implements Converter<Client, ClientNewDTO> {
		  
		  @Override
		  public ClientNewDTO convert(MappingContext<Client, ClientNewDTO> context) {
			  Client s = context.getSource();
			  ClientNewDTO d = context.getDestination();
			  if(d == null) {
				  d = new ClientNewDTO();
			  }
			  d.setId(s.getId());
			  d.setName(s.getName());
			  d.setEmail(s.getEmail());
			  d.setCpf(s.getCpf());
			  Address ad = s.getAddresses().stream().findFirst().orElse(null);
			  if(ad != null) {
				  d.setAddress(ad.getAddress());
				  d.setNumber(ad.getNumber());
				  d.setComplement(ad.getComplement());
				  d.setNeighborhood(ad.getNeighborhood());
				  d.setCity(ad.getCity());
				  d.setState(ad.getState());
				  d.setCep(ad.getCep());
			  }
			  d.setTelephone(s.getTelephones().stream().findFirst().orElse(null));
			  return d;
		  }
		  
	  }
		  
		  public class NewDTOToClientConverter implements Converter<ClientNewDTO, Client> {
			  
			  @Override
			  public Client convert(MappingContext<ClientNewDTO, Client> context) {
				  ClientNewDTO s = context.getSource();
				  Client d = context.getDestination();
				  if(d == null) {
					  d = new Client();
				  }
				  d.setId(s.getId());
				  d.setName(s.getName());
				  d.setEmail(s.getEmail());
				  d.setCpf(s.getCpf());
				  Address ad = new Address(null, s.getAddress(), s.getNumber(), s.getComplement(), s.getNeighborhood(), s.getCep(), s.getCity(), s.getState(), null);
				  d.getAddresses().add(ad);
				  d.getTelephones().add(s.getTelephone());
				  return d;
			  }
		  
	  }

	@Test
	public void clientToNewDTOConverterTest() {
		
		Client client = new Client(1L, "Name Test", "emailtest@www.com", "12345678900");
		Address address = new Address(1L, "Address Test", 1, "Complement", "Neighborhood Test", "City Test",
				"State Test", "0000000", client);

		client.getAddresses().add(address);
		client.getTelephones().add("123456789");
		
		this.mapper.addConverter(new ClientToNewDTOConverter());

		ClientNewDTO dto = this.mapper.map(client, ClientNewDTO.class);

		assertEquals(dto.getId(), client.getId());
		assertEquals(dto.getName(), client.getName());
		assertEquals(dto.getEmail(), client.getEmail());
		assertEquals(dto.getCpf(), client.getCpf());
		assertEquals(dto.getTelephone(), client.getTelephones().stream().findFirst().orElse(null));
		Address a = client.getAddresses().stream().findFirst().orElse(null);
		assertEquals(dto.getAddress(), a.getAddress());
		assertEquals(dto.getNumber(), a.getNumber());
		assertEquals(dto.getComplement(), a.getComplement());
		assertEquals(dto.getNeighborhood(), a.getNeighborhood());
		assertEquals(dto.getCity(), a.getCity());
		assertEquals(dto.getState(), a.getState());
		assertEquals(dto.getCep(), a.getCep());
		

	}

	@Test
	public void newDTOToClientConverterTest() {

		ClientNewDTO client = new ClientNewDTO(1L, "Name Test", "emailtest@www.com", "12345678900", "Address Test", 1,
				"Complement", "Neighborhood Test", "City Test", "State Test", "0000000", "123456789");	
		
		this.mapper.addConverter(new NewDTOToClientConverter());
		
		Client entity = mapper.map(client, Client.class);

		assertEquals(entity.getId(), client.getId());
		assertEquals(entity.getName(), client.getName());
		assertEquals(entity.getEmail(), client.getEmail());
		assertEquals(entity.getCpf(), client.getCpf());
		assertEquals(entity.getTelephones().stream().findFirst().orElse(null), client.getTelephone());
		Address a = entity.getAddresses().stream().findFirst().orElse(null);
		assertEquals(a.getAddress(), client.getAddress());
		assertEquals(a.getNumber(), client.getNumber());
		assertEquals(a.getComplement(), client.getComplement());
		assertEquals(a.getNeighborhood(), client.getNeighborhood());
		assertEquals(a.getCity(), client.getCity());
		assertEquals(a.getState(), client.getState());
		assertEquals(a.getCep(), client.getCep());

	}

}
