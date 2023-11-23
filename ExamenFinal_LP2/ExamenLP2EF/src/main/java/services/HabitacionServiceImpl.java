package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entidades.habitacion;
import repositories.IHabitacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionServiceImpl implements IHabitacionService {
    private final IHabitacionRepository habitacionRepos;

    @Autowired
    public HabitacionServiceImpl(IHabitacionRepository habitacionRepos) {
        this.habitacionRepos = habitacionRepos;
    }

    @Override
    public List<habitacion> findAll() {
        return habitacionRepos.findAll();
    }

    @Override
    public habitacion save(habitacion habitacion) {
        return habitacionRepos.save(habitacion);
    }

    @Override
    public Optional<habitacion> findById(Integer id) {
        return habitacionRepos.findById(id);
    }
}
