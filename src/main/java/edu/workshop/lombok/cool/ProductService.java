package edu.workshop.lombok.cool;


import edu.workshop.lombok.caveats.Product;
import lombok.val;

import java.util.Optional;

public abstract class ProductService {

    public Product createProduct(ProductDTO productDTO) {
        val existingProduct = getByName(productDTO.getName());
        return existingProduct.orElseGet(() -> save(productDTO));
    }

    abstract Product save(ProductDTO productDTO);

    abstract Optional<Product> getByName(String name);
}
