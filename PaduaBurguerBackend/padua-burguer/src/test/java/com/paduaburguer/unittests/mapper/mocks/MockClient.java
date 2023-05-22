package com.paduaburguer.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.paduaburguer.data.dto.ClientDTO;
import com.paduaburguer.data.dto.ClientNewDTO;
import com.paduaburguer.model.Address;
import com.paduaburguer.model.Client;

public class MockClient {
	
	 	public Client mockEntity() {
	        return mockEntity(0);
	    }
	    
	    public ClientDTO mockDTO() {
	        return mockDTO(0);
	    }
	    
	    public ClientNewDTO mockNewDTO() {
	        return mockNewDTO(0);
	    }
	    
	    public Address mockEntityAddress() {
	        return mockEntityAddress(0);
	    }
	    
	    public List<Client> mockEntityList() {
	        List<Client> clients = new ArrayList<Client>();
	        for (int i = 0; i < 10; i++) {
	           clients.add(mockEntity(i));
	        }
	        return clients;
	    }

	    public List<ClientDTO> mockDTOList() {
	        List<ClientDTO> clients = new ArrayList<>();
	        for (int i = 0; i < 10; i++) {
	            clients.add(mockDTO(i));
	        }
	        return clients;
	    }
	    
	    public List<ClientNewDTO> mockNewDTOList() {
	        List<ClientNewDTO> clients = new ArrayList<>();
	        for (int i = 0; i < 10; i++) {
	            clients.add(mockNewDTO(i));
	        }
	        return clients;
	    }
	    
	    public Client mockEntity(Integer number) {
	        Client client = new Client();
	        client.setName("Name Test" + number);
	        client.setId(number.longValue());
	        client.setEmail("Email Test" + number);
	        client.setCpf("CPF Test" + number);
	        return client;
	    }

	    public ClientDTO mockDTO(Integer number) {
	        ClientDTO client = new ClientDTO();
	        client.setName("Name Test" + number);
	        client.setId(number.longValue());
	        client.setEmail("Email Test" + number);
	        return client;
	    }
	    
	    public ClientNewDTO mockNewDTO(Integer number) {
	        ClientNewDTO client = new ClientNewDTO();
	        client.setId(number.longValue());
	        client.setName("Name Test" + number);
	        client.setEmail("Email Test" + number);
	        client.setCpf("CPF Test" + number);
	        client.setTelephone("Phone Test" + number);
	        client.setAddress("Address Test" + number);
	        client.setNumber(number.intValue());
	        client.setComplement("Complement Test" + number);
	        client.setNeighborhood("Neighborhood Test" + number);
	        client.setCep("CEP Test" + number);
	        return client;
	    }
	    
	    public Address mockEntityAddress(Integer number) {
	    	Address address = new Address();
	    	address.setId(number.longValue());
	    	address.setAddress("Address Test" + number);
	    	address.setNumber(number.intValue());
	    	address.setComplement("Complement Test" + number);
	    	address.setNeighborhood("Neighborhood test" + number);
	    	address.setCep("CEP Test" + number);
	    	return address;
	    }
}
