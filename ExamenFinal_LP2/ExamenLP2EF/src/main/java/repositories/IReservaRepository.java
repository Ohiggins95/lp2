package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Entidades.reserva;

public interface IReservaRepository extends JpaRepository<reserva, Integer> {
}
