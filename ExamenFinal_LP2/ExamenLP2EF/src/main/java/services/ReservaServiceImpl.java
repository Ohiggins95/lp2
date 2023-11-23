package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entidades.reserva;
import repositories.IReservaRepository;

@Service
public class ReservaServiceImpl implements IReservaService {
    private final IReservaRepository reservaRepos;

    @Autowired
    public ReservaServiceImpl(IReservaRepository reservaRepos) {
        this.reservaRepos = reservaRepos;
    }

    @Override
    public reserva save(reserva reserva) {
        return reservaRepos.save(reserva);
    }
}