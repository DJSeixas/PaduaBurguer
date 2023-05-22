package com.paduaburguer.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.paduaburguer.data.dto.ClientDTO;
import com.paduaburguer.data.dto.ClientNewDTO;
import com.paduaburguer.exceptions.RequiredObjectIsNullException;
import com.paduaburguer.model.Client;
import com.paduaburguer.repositories.ClientRepository;
import com.paduaburguer.services.ClientService;
import com.paduaburguer.unittests.mapper.mocks.MockClient;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
	
	MockClient input;
	
	@InjectMocks
	private ClientService service;
	
	@Mock
	private ClientRepository repository;

	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockClient();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		List<Client> list = input.mockEntityList();
		
		when(repository.findAll()).thenReturn(list);
		
		var client = service.findAll();
		
		var clientOne = client.get(1);
		
		assertNotNull(clientOne);
		assertNotNull(clientOne.getId());
		assertNotNull(clientOne.getLinks());
		
		assertTrue(clientOne.toString().contains("links: [</api/clients/1>;rel=\"self\"]"));
		
		assertEquals("Name Test1", clientOne.getName());
		assertEquals("Email Test1", clientOne.getEmail());
		
		var clientFive = client.get(5);
		
		assertNotNull(clientFive);
		assertNotNull(clientFive.getId());
		assertNotNull(clientFive.getLinks());
		
		assertTrue(clientFive.toString().contains("links: [</api/clients/5>;rel=\"self\"]"));
		
		assertEquals("Name Test5", clientFive.getName());
		assertEquals("Email Test5", clientFive.getEmail());
	}

	@Test
	void testFindById() {
		Client entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		var result = service.findById(1L);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/clients/1>;rel=\"self\"]"));
		
		assertEquals("Name Test1", result.getName());
		assertEquals("Email Test1", result.getEmail());
	}

	@Test
	void testCreate() {
		Client entity = input.mockEntity(1);
		
		Client persisted = entity;
		persisted.setId(1L);
		
		ClientNewDTO dto = input.mockNewDTO(1);
		dto.setId(1L);
		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.create(dto);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/clients/1>;rel=\"self\"]"));
		
		assertEquals("Name Test1", result.getName());
		assertEquals("Email Test1", result.getEmail());
		assertEquals("CPF Test1", result.getCpf());
		assertEquals("Address Test1", result.getAddress());
		assertEquals("Complement Test1", result.getComplement());
		assertEquals("Neighborhood Test1", result.getNeighborhood());
		assertEquals("CEP Test1", result.getCep());
		assertEquals("Phone Test1", result.getTelephone());
	}
	
	@Test
	void testCreateWithNullPerson() {
		
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.create(null);
		});
		
		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void testUpdate() {
		Client entity = input.mockEntity(1);
		entity.setId(1L);
		
		Client persisted = entity;
		persisted.setId(1L);
		
		ClientDTO dto = input.mockDTO(1);
		dto.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.update(dto);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/clients/1>;rel=\"self\"]"));
		assertEquals("Name Test1", result.getName());
	}
	
	@Test
	void testUpdateWithNullPerson() {
		
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.update(null);
		});
		
		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void testDelete() {
		Client entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		service.delete(1L);
	}

}
