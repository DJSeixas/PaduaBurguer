package com.paduaburguer.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.paduaburguer.data.dto.ProductDTO;
import com.paduaburguer.model.Category;
import com.paduaburguer.model.Product;

public class MockProduct {
	
	 	public Product mockEntity() {
	        return mockEntity(0);
	    }
	    
	    public ProductDTO mockDTO() {
	        return mockDTO(0);
	    }
	    
	    public List<Product> mockEntityList() {
	        List<Product> products = new ArrayList<Product>();
	        for (int i = 0; i < 10; i++) {
	           products.add(mockEntity(i));
	        }
	        return products;
	    }

	    public List<ProductDTO> mockDTOList() {
	        List<ProductDTO> products = new ArrayList<>();
	        for (int i = 0; i < 10; i++) {
	            products.add(mockDTO(i));
	        }
	        return products;
	    }
	    
	    public Product mockEntity(Integer number) {
	    	
	    	Category cat = new Category(1L, "CategoryName Test");
	    	
	        Product product = new Product();
	        product.setId(number.longValue());
	        product.setName("Name Test" + number);
	        product.setCategory(cat);
	        return product;
	    }

	    public ProductDTO mockDTO(Integer number) {
	        ProductDTO product = new ProductDTO();
	        product.setId(number.longValue());
	        product.setName("Name Test" + number);
	        product.setCategory("CategoryName Test" + number);
	        return product;
	    }
}
