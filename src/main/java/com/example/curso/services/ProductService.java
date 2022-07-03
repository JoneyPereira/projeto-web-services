package com.example.curso.services;

import com.example.curso.dto.ProductDTO;
import com.example.curso.entities.Product;
import com.example.curso.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(long id){

        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> find(PageRequest pageRequest){

        Page<Product> page = repository.findAll(pageRequest);
        repository.findProductsCategories(page.stream().collect(Collectors.toList()));
        return page.map(x -> new ProductDTO(x));
    }
}
