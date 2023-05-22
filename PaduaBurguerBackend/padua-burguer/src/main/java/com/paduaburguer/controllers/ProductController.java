package com.paduaburguer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paduaburguer.data.dto.ProductDTO;
import com.paduaburguer.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/products")
@Tag(name = "Product", description = "Endpoints for Managing Products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			})
		@Operation(summary = "Finds all products", description = "Finds all products",
				tags = {"Product"},
				responses = {
						@ApiResponse(description = "Success", responseCode = "200", 
								content = {
									@Content(
											mediaType = "application/json",
											array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class))
									)	
								}),
						@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
						@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
						@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
						@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
				}
		)
		public List<ProductDTO> findAll() {
			return service.findAll();
		}
	
	@GetMapping(value ="/{id}",
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			})
	public ProductDTO findById(@PathVariable(value = "id")Long id) {
		
		return service.findById(id);
	}
}
