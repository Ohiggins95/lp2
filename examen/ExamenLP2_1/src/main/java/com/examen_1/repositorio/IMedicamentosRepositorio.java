package com.examen_1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examen_1.modelo.Medicamentos;

public interface IMedicamentosRepositorio extends JpaRepository<Medicamentos, Integer>{

}
