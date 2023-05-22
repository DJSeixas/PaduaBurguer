package com.paduaburguer.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paduaburguer.controllers.CategoryController;
import com.paduaburguer.data.dto.CategoryDTO;
import com.paduaburguer.exceptions.RequiredObjectIsNullException;
import com.paduaburguer.exceptions.ResourceNotFoundException;
import com.paduaburguer.model.Category;
import com.paduaburguer.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<CategoryDTO> findAll() {
		
		List<CategoryDTO> categories = mapper.map(repository.findAll(), new TypeToken<List<CategoryDTO>>() {}.getType());
		
		categories
			.stream()
			.forEach(c -> c.add(linkTo(methodOn(CategoryController.class).findById(c.getId())).withSelfRel()));
		
		return categories;		
	}
	
	public CategoryDTO findById(Long id) {
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
		
		var cat = mapper.map(entity, CategoryDTO.class);
		
		cat.add(linkTo(methodOn(CategoryController.class).findById(cat.getId())).withSelfRel());
		
		return cat;
	}
	
	public CategoryDTO create(CategoryDTO category) {
		
		if(category == null) throw new RequiredObjectIsNullException();
		
		var entity = mapper.map(category, Category.class);
		
		var cat = mapper.map(repository.save(entity), CategoryDTO.class);
		
		cat.add(linkTo(methodOn(CategoryController.class).findById(cat.getId())).withSelfRel());
		
		return cat;
	}
	
	public CategoryDTO update(CategoryDTO category) {
		
		if(category == null) throw new RequiredObjectIsNullException();
		
		var entity = repository.findById(category.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
		
		entity.setName(category.getName());
		
		var cat = mapper.map(repository.save(entity), CategoryDTO.class);
		
		cat.add(linkTo(methodOn(CategoryController.class).findById(cat.getId())).withSelfRel());
		
		return cat;
	}
	
	public void delete(Long id) {
		
		var cat = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
		
		repository.delete(cat);
	}
}
