package com.example.simulacioncompras.repository;

import modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoRepository extends JpaRepository<Producto, Long> {

}