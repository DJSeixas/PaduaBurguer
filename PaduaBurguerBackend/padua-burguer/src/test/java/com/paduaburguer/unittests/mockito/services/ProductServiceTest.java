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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.paduaburguer.data.dto.ProductDTO;
import com.paduaburguer.exceptions.RequiredObjectIsNullException;
import com.paduaburguer.model.Product;
import com.paduaburguer.repositories.ProductRepository;
import com.paduaburguer.services.ProductService;
import com.paduaburguer.unittests.mapper.mocks.MockProduct;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	
	MockProduct input;
	
	@InjectMocks
	private ProductService service;
	
	@Mock
	private ProductRepository repository;
	
	@Spy
	private ModelMapper mapper;

	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockProduct();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		List<Product> list = input.mockEntityList();
		
		when(repository.findAll()).thenReturn(list);
		
		var product = service.findAll();
		
		var productOne = product.get(1);
		
		assertNotNull(productOne);
		assertNotNull(productOne.getId());
		assertNotNull(productOne.getLinks());
		
		assertTrue(productOne.toString().contains("links: [</api/products/1>;rel=\"self\"]"));
		
		assertEquals("Name Test1", productOne.getName());
		
		var productFive = product.get(5);
		
		assertNotNull(productFive);
		assertNotNull(productFive.getId());
		assertNotNull(productFive.getLinks());
		
		assertTrue(productFive.toString().contains("links: [</api/products/5>;rel=\"self\"]"));
		
		assertEquals("Name Test5", productFive.getName());
	}

	@Test
	void testFindById() {
		Product entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		var result = service.findById(1L);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/products/1>;rel=\"self\"]"));
		assertEquals("Name Test1", result.getName());
	}

	@Test
	void testCreate() {
		Product entity = input.mockEntity(1);
		
		Product persisted = entity;
		persisted.setId(1L);
		
		ProductDTO dto = input.mockDTO(1);
		dto.setId(1L);
		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.create(dto);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/products/1>;rel=\"self\"]"));
		assertEquals("Name Test1", result.getName());
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
		Product entity = input.mockEntity(1);
		entity.setId(1L);
		
		Product persisted = entity;
		persisted.setId(1L);
		
		ProductDTO dto = input.mockDTO(1);
		dto.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.update(dto);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/products/1>;rel=\"self\"]"));
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
		Product entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		service.delete(1L);
	}

}
