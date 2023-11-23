package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
