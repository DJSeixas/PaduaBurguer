package com.paduaburguer.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.paduaburguer.data.dto.CategoryDTO;
import com.paduaburguer.model.Category;
import com.paduaburguer.unittests.mapper.mocks.MockCategory;

@ExtendWith(MockitoExtension.class)
public class CategoryConverterTest {
		
		MockCategory inputObject;
		
		@InjectMocks
		private ModelMapper mapper;

	    @BeforeEach
	    public void setUp() {
	        inputObject = new MockCategory();
	    }

	    @Test
	    public void parseEntityToDTOTest() {
	        CategoryDTO output = mapper.map(inputObject.mockEntity(), CategoryDTO.class);
	        assertEquals(Long.valueOf(0L), output.getId());
	        assertEquals("Name Test0", output.getName());
	    }

	    @Test
	    public void parseEntityListToDTOListTest() {
	        List<CategoryDTO> outputList = mapper.map(inputObject.mockEntityList(), new TypeToken<List<CategoryDTO>>() {}.getType());
	        CategoryDTO outputZero = outputList.get(0);
	        
	        assertEquals(Long.valueOf(0L), outputZero.getId());
	        assertEquals("Name Test0", outputZero.getName());
	        
	        CategoryDTO outputSeven = outputList.get(7);
	        
	        assertEquals(Long.valueOf(7L), outputSeven.getId());
	        assertEquals("Name Test7", outputSeven.getName());    
	    }

	    @Test
	    public void parseDTOToEntityTest() {
	        Category output = mapper.map(inputObject.mockDTO(), Category.class);
	        assertEquals(Long.valueOf(0L), output.getId());
	        assertEquals("Name Test0", output.getName());
	    }

	    @Test
	    public void parserDTOListToEntityListTest() {
	        List<Category> outputList = mapper.map(inputObject.mockEntityList(), new TypeToken<List<Category>>() {}.getType());
	        Category outputZero = outputList.get(0);
	        
	        assertEquals(Long.valueOf(0L), outputZero.getId());
	        assertEquals("Name Test0", outputZero.getName());
	        
	        Category outputSeven = outputList.get(7);
	        
	        assertEquals(Long.valueOf(7L), outputSeven.getId());
	        assertEquals("Name Test7", outputSeven.getName());      
	    }
	}

