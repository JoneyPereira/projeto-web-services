package com.example.curso.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.curso.entities.Product;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductDTO {

    private Long id;
    private String name;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        categories = product.getCategories().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }


    
}
