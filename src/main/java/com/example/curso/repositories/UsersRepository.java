package com.example.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
