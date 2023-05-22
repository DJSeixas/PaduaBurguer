package com.paduaburguer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paduaburguer.data.dto.ClientNewDTO;
import com.paduaburguer.model.Client;
import com.paduaburguer.data.dto.ProductDTO;
import com.paduaburguer.model.Product;

import org.modelmapper.ModelMapper;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	ModelMapper ModelMapper() {
		var mapper = new ModelMapper();
		
		mapper.createTypeMap(Client.class, ClientNewDTO.class)
			.<String>addMapping(src -> src.getTelephones(),
					(d, v) -> d.setTelephone(v))
			.<String>addMapping(s -> s.getAddresses(),
					(d, v) -> d.setAddress(v));
		
		mapper.createTypeMap(Product.class, ProductDTO.class)
			.<String>addMapping(src -> src.getCategory().getName(), 
					(dest, value) -> dest.setCategory(value));
		
		
		return mapper;
	}
}
