package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entidades.Habitacion;
import Repository.HabitacionRepositorio;

@Service
public class HabitacionService {
    @Autowired
    private HabitacionRepositorio habitacionRepository;

    public List<Habitacion> obtenerTodasHabitaciones() {
        return habitacionRepository.findAll();
    }

    public Habitacion obtenerHabitacionPorId(Long id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    public void guardarHabitacion(Habitacion habitacion) {
        habitacionRepository.save(habitacion);
    }

    public void eliminarHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }
}
