package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Entidades.Habitacion;

public interface HabitacionRepositorio extends JpaRepository<Habitacion, Long> {

	List<Habitacion> findAll();

	
}
