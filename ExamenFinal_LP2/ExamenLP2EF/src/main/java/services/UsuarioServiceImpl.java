package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entidades.usuario;
import repositories.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    private final IUsuarioRepository usuarioRepos;

    @Autowired
    public UsuarioServiceImpl(IUsuarioRepository usuarioRepos) {
        this.usuarioRepos = usuarioRepos;
    }

    @Override
    public usuario save(usuario usuario) {
        return usuarioRepos.save(usuario);
    }
}
