package com.paduaburguer.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.paduaburguer.data.dto.CategoryDTO;
import com.paduaburguer.model.Category;

public class MockCategory {
	
	 public Category mockEntity() {
	        return mockEntity(0);
	    }
	    
	    public CategoryDTO mockDTO() {
	        return mockDTO(0);
	    }
	    
	    public List<Category> mockEntityList() {
	        List<Category> categories = new ArrayList<Category>();
	        for (int i = 0; i < 10; i++) {
	           categories.add(mockEntity(i));
	        }
	        return categories;
	    }

	    public List<CategoryDTO> mockDTOList() {
	        List<CategoryDTO> categories = new ArrayList<>();
	        for (int i = 0; i < 10; i++) {
	            categories.add(mockDTO(i));
	        }
	        return categories;
	    }
	    
	    public Category mockEntity(Integer number) {
	        Category category = new Category();
	        category.setName("Name Test" + number);
	        category.setId(number.longValue());
	        return category;
	    }

	    public CategoryDTO mockDTO(Integer number) {
	        CategoryDTO category = new CategoryDTO();
	        category.setName("Name Test" + number);
	        category.setId(number.longValue());
	        return category;
	    }
}
