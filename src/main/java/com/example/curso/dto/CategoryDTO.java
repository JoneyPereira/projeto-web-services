package com.example.curso.dto;

import com.example.curso.entities.Category;

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
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(Category category){
        id = category.getId();
        name = category.getName();
    }    
}
