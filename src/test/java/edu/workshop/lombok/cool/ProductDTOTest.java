package edu.workshop.lombok.cool;

import org.junit.jupiter.api.Test;

class ProductDTOTest {

    @Test
    public void buildProductDTO() {
        ProductDTO productDTO = ProductDTO.builder()
                .name("TestProduct")
                .description("Some long description")
                .build();
        System.out.println(productDTO);
    }
}