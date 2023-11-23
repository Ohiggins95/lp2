package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entidades.Reserva;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {
}
