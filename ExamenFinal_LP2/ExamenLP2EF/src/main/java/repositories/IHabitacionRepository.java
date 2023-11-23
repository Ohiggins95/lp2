package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Entidades.habitacion;

public interface IHabitacionRepository extends JpaRepository<habitacion, Integer> {
}
