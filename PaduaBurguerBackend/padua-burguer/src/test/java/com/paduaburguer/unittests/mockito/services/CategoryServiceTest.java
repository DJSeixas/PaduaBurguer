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

import com.paduaburguer.data.dto.CategoryDTO;
import com.paduaburguer.exceptions.RequiredObjectIsNullException;
import com.paduaburguer.model.Category;
import com.paduaburguer.repositories.CategoryRepository;
import com.paduaburguer.services.CategoryService;
import com.paduaburguer.unittests.mapper.mocks.MockCategory;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
	
	MockCategory input;
	
	@InjectMocks
	private CategoryService service;
	
	@Mock
	private CategoryRepository repository;
	
	@Spy
	private ModelMapper mapper;

	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockCategory();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		List<Category> list = input.mockEntityList();
		
		when(repository.findAll()).thenReturn(list);
		
		var category = service.findAll();
		
		var categoryOne = category.get(1);
		
		assertNotNull(categoryOne);
		assertNotNull(categoryOne.getId());
		assertNotNull(categoryOne.getLinks());
		
		assertTrue(categoryOne.toString().contains("links: [</api/categories/1>;rel=\"self\"]"));
		
		assertEquals("Name Test1", categoryOne.getName());
		
		var categoryFive = category.get(5);
		
		assertNotNull(categoryFive);
		assertNotNull(categoryFive.getId());
		assertNotNull(categoryFive.getLinks());
		
		assertTrue(categoryFive.toString().contains("links: [</api/categories/5>;rel=\"self\"]"));
		
		assertEquals("Name Test5", categoryFive.getName());
	}

	@Test
	void testFindById() {
		Category entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		var result = service.findById(1L);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/categories/1>;rel=\"self\"]"));
		assertEquals("Name Test1", result.getName());
	}

	@Test
	void testCreate() {
		Category entity = input.mockEntity(1);
		
		Category persisted = entity;
		persisted.setId(1L);
		
		CategoryDTO dto = input.mockDTO(1);
		dto.setId(1L);
		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.create(dto);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/categories/1>;rel=\"self\"]"));
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
		Category entity = input.mockEntity(1);
		entity.setId(1L);
		
		Category persisted = entity;
		persisted.setId(1L);
		
		CategoryDTO dto = input.mockDTO(1);
		dto.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.update(dto);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</api/categories/1>;rel=\"self\"]"));
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
		Category entity = input.mockEntity(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		service.delete(1L);
	}

}
