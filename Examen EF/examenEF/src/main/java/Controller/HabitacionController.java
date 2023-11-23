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

import Entidades.Habitacion;
import services.HabitacionService;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {
    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public String listarHabitaciones(Model model) {
        List<Habitacion> habitaciones = habitacionService.obtenerTodasHabitaciones();
        model.addAttribute("habitaciones", habitaciones);
        return "habitaciones/listar";
    }

    @GetMapping("/{id}")
    public String verHabitacion(@PathVariable Long id, Model model) {
        Habitacion habitacion = habitacionService.obtenerHabitacionPorId(id);
        model.addAttribute("habitacion", habitacion);
        return "habitaciones/ver";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearHabitacion(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitaciones/formulario";
    }

    @PostMapping("/crear")
    public String crearHabitacion(@ModelAttribute Habitacion habitacion) {
        habitacionService.guardarHabitacion(habitacion);
        return "redirect:/habitaciones";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarHabitacion(@PathVariable Long id, Model model) {
        Habitacion habitacion = habitacionService.obtenerHabitacionPorId(id);
        model.addAttribute("habitacion", habitacion);
        return "habitaciones/formulario";
    }

    @PostMapping("/editar/{id}")
    public String editarHabitacion(@PathVariable int id, @ModelAttribute Habitacion habitacion) {
        habitacion.setId(id);
        habitacionService.guardarHabitacion(habitacion);
        return "redirect:/habitaciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarHabitacion(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }
}
