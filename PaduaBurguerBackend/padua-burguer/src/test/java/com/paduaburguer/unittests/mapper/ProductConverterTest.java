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

import com.paduaburguer.data.dto.ProductDTO;
import com.paduaburguer.model.Product;
import com.paduaburguer.unittests.mapper.mocks.MockProduct;

@ExtendWith(MockitoExtension.class)
public class ProductConverterTest {
	
	MockProduct inputObject;
	
	@InjectMocks
	private ModelMapper mapper;

    @BeforeEach
    public void setUp() {
        inputObject = new MockProduct();
    }

    @Test
    public void parseEntityToDTOTest() {
    	
    	mapper.createTypeMap(Product.class, ProductDTO.class)
		.<String>addMapping(src -> src.getCategory().getName(), 
				(dest, value) -> dest.setCategory(value));
    	
    	System.out.println(inputObject.mockEntity().getCategory().getName());
        ProductDTO output = mapper.map(inputObject.mockEntity(), ProductDTO.class);
        System.out.println(output.getCategory());
        System.out.println(output.getName());
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Name Test0", output.getName());
        assertEquals("CategoryName Test", output.getCategory());
    }

    @Test
    public void parseEntityListToDTOListTest() {
    	
    	mapper.createTypeMap(Product.class, ProductDTO.class)
		.<String>addMapping(src -> src.getCategory().getName(), 
				(dest, value) -> dest.setCategory(value));
    	
        List<ProductDTO> outputList = mapper.map(inputObject.mockEntityList(), new TypeToken<List<ProductDTO>>() {}.getType());
        ProductDTO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Name Test0", outputZero.getName());
        assertEquals("CategoryName Test", outputZero.getCategory());
        
        ProductDTO outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Name Test7", outputSeven.getName());
        assertEquals("CategoryName Test", outputSeven.getCategory());
    }

    @Test
    public void parseDTOToEntityTest() {
        Product output = mapper.map(inputObject.mockDTO(), Product.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Name Test0", output.getName());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Product> outputList = mapper.map(inputObject.mockEntityList(), new TypeToken<List<Product>>() {}.getType());
        Product outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Name Test0", outputZero.getName());
        
        Product outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Name Test7", outputSeven.getName());      
    }
}
