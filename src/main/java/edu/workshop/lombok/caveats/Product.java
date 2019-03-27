package edu.workshop.lombok.caveats;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {
    private String name;
    private List<Category> categories;
}
