package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entidades.Reserva;
import Repository.ReservaRepositorio;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepositorio reservaRepository;

    public List<Reserva> obtenerTodasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public void guardarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}

