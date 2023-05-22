package com.paduaburguer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paduaburguer.exceptions.ResourceNotFoundException;
import com.paduaburguer.model.Orders;
import com.paduaburguer.repositories.OrderProductsRepository;
import com.paduaburguer.repositories.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository repository;

	@Autowired
	private ProductService prodService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private OrderProductsRepository OrderProdRepo;

	public Orders findById(Long id) {

		Orders order = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
		return order;
	}

	/*@Transactional
	public Orders create(Orders order) {

		
		  if(order == null) throw new RequiredObjectIsNullException();
		  
		  Client client = new Client(order.getClient(), null, null, null);
		  
		  order.setId(null); order.setDate(new Date()); order.setClient(client);
		  
		  var entity =repository.save(order);
		  
		  for(OrderProducts op: entity.getItens()) { op.setDesconto(0.0);
		  op.setProduct(prodService.findById(op.getProduct().getId()));
		  op.setPrice(op.getProduct().getPrice()); op.setOrders(entity); }
		  
		  return order;*/
		 

	}

