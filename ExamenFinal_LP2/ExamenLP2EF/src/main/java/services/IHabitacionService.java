package services;

import java.util.List;
import java.util.Optional;

import Entidades.habitacion;

public interface IHabitacionService {
    List<habitacion> findAll();

    habitacion save(habitacion habitacion);

    Optional<habitacion> findById(Integer id);
}