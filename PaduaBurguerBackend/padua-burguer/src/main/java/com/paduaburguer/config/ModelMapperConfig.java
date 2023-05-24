package com.paduaburguer.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paduaburguer.data.dto.ClientNewDTO;
import com.paduaburguer.data.dto.ProductDTO;
import com.paduaburguer.model.Address;
import com.paduaburguer.model.Client;
import com.paduaburguer.model.Product;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	ModelMapper ModelMapper() {
		var mapper = new ModelMapper();
		
		mapper.addConverter(new ClientToNewDTOConverter());
		mapper.addConverter(new NewDTOToClientConverter());
		
		mapper.createTypeMap(Product.class, ProductDTO.class)
			.<String>addMapping(src -> src.getCategory().getName(), 
					(dest, value) -> dest.setCategory(value));
		
		
		return mapper;
	}
	
	public class ClientToNewDTOConverter implements Converter<Client, ClientNewDTO> {
		  
		  @Override
		  public ClientNewDTO convert(MappingContext<Client, ClientNewDTO> context) {
			  Client s = context.getSource();
			  ClientNewDTO d = context.getDestination();
			  if(d == null) {
				  d = new ClientNewDTO();
			  }
			  d.setId(s.getId());
			  d.setName(s.getName());
			  d.setEmail(s.getEmail());
			  d.setCpf(s.getCpf());
			  Address ad = s.getAddresses().stream().findFirst().orElse(null);
			  if(ad != null) {
				  d.setAddress(ad.getAddress());
				  d.setNumber(ad.getNumber());
				  d.setComplement(ad.getComplement());
				  d.setNeighborhood(ad.getNeighborhood());
				  d.setCity(ad.getCity());
				  d.setState(ad.getState());
				  d.setCep(ad.getCep());
			  }
			  d.setTelephone(s.getTelephones().stream().findFirst().orElse(null));
			  return d;
		  }
		  
	  }
		  
		  public class NewDTOToClientConverter implements Converter<ClientNewDTO, Client> {
			  
			  @Override
			  public Client convert(MappingContext<ClientNewDTO, Client> context) {
				  ClientNewDTO s = context.getSource();
				  Client d = context.getDestination();
				  if(d == null) {
					  d = new Client();
				  }
				  d.setId(s.getId());
				  d.setName(s.getName());
				  d.setEmail(s.getEmail());
				  d.setCpf(s.getCpf());
				  Address ad = new Address(null, s.getAddress(), s.getNumber(), s.getComplement(), s.getNeighborhood(), s.getCep(), s.getCity(), s.getState(), null);
				  d.getAddresses().add(ad);
				  d.getTelephones().add(s.getTelephone());
				  return d;
			  }
		  
	  }
}


