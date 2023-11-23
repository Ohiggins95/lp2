package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Entidades.Reserva;
import services.ReservaService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaService.obtenerTodasReservas();
        model.addAttribute("reservas", reservas);
        return "reservas/listar";
    }

    @GetMapping("/{id}")
    public String verReserva(@PathVariable Long id, Model model) {
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        model.addAttribute("reserva", reserva);
        return "reservas/ver";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservas/formulario";
    }

    @PostMapping("/crear")
    public String crearReserva(@ModelAttribute Reserva reserva) {
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarReserva(@PathVariable Long id, Model model) {
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        model.addAttribute("reserva", reserva);
        return "reservas/formulario";
    }

    @PostMapping("/editar/{id}")
    public String editarReserva(@PathVariable Long id, @ModelAttribute Reserva reserva) {
        reserva.setId(id);
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
        return "redirect:/reservas";
    }
}