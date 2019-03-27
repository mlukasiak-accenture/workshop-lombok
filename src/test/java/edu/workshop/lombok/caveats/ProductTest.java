package edu.workshop.lombok.caveats;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ProductTest {

    @Test
    public void shouldBuildStringRepresentation() {
        Product product = new Product("Marchew", new ArrayList<>());
        Category category = new Category("Warzywa", new ArrayList<>());
        product.getCategories().add(category);
        category.getProducts().add(product);

        System.out.println(product);

        Category category2 = new Category("Owoce", new ArrayList<>());

        System.out.println(category2.equals(category));
    }


}