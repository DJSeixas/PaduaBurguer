package com.paduaburguer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paduaburguer.model.Orders;
import com.paduaburguer.services.OrdersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/orders")
@Tag(name = "Orders", description = "Endpoints for Managing Orders")
public class OrdersController {
	
	@Autowired
	private OrdersService service;
	
	@GetMapping(value ="/{id}",
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			})
	public Orders findById(@PathVariable(value = "id")Long id) {
		return service.findById(id);
	}
	
	/*
	 * @PostMapping( produces = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_XML_VALUE }) public Orders create(@RequestBody Orders
	 * orders) { return service.create(orders); }
	 */
}
