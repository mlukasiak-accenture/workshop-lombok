package edu.workshop.lombok.cool;

import lombok.*;

@Value
@Builder
public class ProductDTO {
    private String name;
    private String  description;
}
