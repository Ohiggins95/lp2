package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import services.IUsuarioService;

@Controller
public class usuariocontroller {
    private final IUsuarioService usuarioService;

    @Autowired
    public usuariocontroller(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
