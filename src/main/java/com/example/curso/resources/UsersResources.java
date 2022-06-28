package com.example.curso.resources;

import com.example.curso.entities.Users;
import com.example.curso.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {

    @Autowired
    private UsersService service;

    @GetMapping
    public ResponseEntity<List<Users>> findAll(){

        List<Users> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id){

        Users obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}
