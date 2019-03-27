package edu.workshop.lombok.cool;


import edu.workshop.lombok.caveats.Product;
import lombok.val;

import java.util.Optional;

public class ProductService {

    public Product createProduct(ProductDTO productDTO) {
        val existingProduct = getByName(productDTO.getName());
        return existingProduct.orElseGet(() -> save(productDTO));
    }

    private Product save(ProductDTO productDTO) {
        return null; //TODO
    }

    private Optional<Product> getByName(String name) {
        return Optional.empty(); //TODO
    }
}
