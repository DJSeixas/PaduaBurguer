package com.paduaburguer.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paduaburguer.controllers.ProductController;
import com.paduaburguer.data.dto.ProductDTO;
import com.paduaburguer.exceptions.RequiredObjectIsNullException;
import com.paduaburguer.exceptions.ResourceNotFoundException;
import com.paduaburguer.model.Product;
import com.paduaburguer.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<ProductDTO> findAll() {
		
		List<ProductDTO> products = mapper.map(repository.findAll(), new TypeToken<List<ProductDTO>>() {}.getType());
		
		products
			.stream()
			.forEach(c -> c.add(linkTo(methodOn(ProductController.class).findById(c.getId())).withSelfRel()));
	
	return products;
		
	}
	
	public ProductDTO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
	
		var prod = mapper.map(entity, ProductDTO.class);
		
		prod.add(linkTo(methodOn(ProductController.class).findById(prod.getId())).withSelfRel());
		
		return prod;
	}
	
	public ProductDTO create(ProductDTO product) {
		
		if(product == null) throw new RequiredObjectIsNullException();
		
		var entity = mapper.map(product, Product.class);
		
		var prod = mapper.map(repository.save(entity), ProductDTO.class);
		
		prod.add(linkTo(methodOn(ProductController.class).findById(prod.getId())).withSelfRel());
		
		return prod;
	}
	
public ProductDTO update(ProductDTO product) {
		
		if(product == null) throw new RequiredObjectIsNullException();
		
		var entity = repository.findById(product.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
		
		entity.setName(product.getName());
		
		var cat = mapper.map(repository.save(entity), ProductDTO.class);
		
		cat.add(linkTo(methodOn(ProductController.class).findById(cat.getId())).withSelfRel());
		
		return cat;
	}
	
	public void delete(Long id) {
		
		var prod = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
		
		repository.delete(prod);
	}
	
}
