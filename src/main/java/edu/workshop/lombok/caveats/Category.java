package edu.workshop.lombok.caveats;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Category {
    private String name;
    private List<Product> products;
}
