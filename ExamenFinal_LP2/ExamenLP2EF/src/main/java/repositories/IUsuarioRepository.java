package repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import Entidades.usuario;

public interface IUsuarioRepository extends JpaRepository<usuario, Integer> {
}
