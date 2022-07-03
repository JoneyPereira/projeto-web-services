package com.example.curso.resources;

import com.example.curso.dto.ProductDTO;
import com.example.curso.entities.Product;
import com.example.curso.repositories.ProductRepository;
import com.example.curso.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    /**
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){

        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
     */

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){

        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }   

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> find(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size){

            PageRequest pageRequest = PageRequest.of(page, size);
            Page<ProductDTO> list = service.find(pageRequest);
            
            return ResponseEntity.ok(list);
    }
}
