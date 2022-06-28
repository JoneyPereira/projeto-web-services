package com.example.curso.services;

import com.example.curso.entities.Users;
import com.example.curso.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public List<Users> findAll(){
        return repository.findAll();
    }

    public  Users findById(long id){

        Optional<Users> obj = repository.findById(id);
        return obj.get();
    }

}
