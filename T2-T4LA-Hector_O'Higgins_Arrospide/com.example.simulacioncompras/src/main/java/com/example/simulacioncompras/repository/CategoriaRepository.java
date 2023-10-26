package com.example.simulacioncompras.repository;

import modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}