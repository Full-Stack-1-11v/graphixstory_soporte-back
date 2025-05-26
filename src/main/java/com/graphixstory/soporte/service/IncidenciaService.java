package com.graphixstory.soporte.service;

import com.graphixstory.soporte.model.Incidencia;
import com.graphixstory.soporte.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository repo;

    public Incidencia crearIncidencia(Incidencia incidencia) {
        return repo.save(incidencia);
    }

    public List<Incidencia> listarIncidencias() {
        return repo.findAll();
    }

    public Optional<Incidencia> obtenerPorId(Long id) {
        return repo.findById(id);
    }

    public Incidencia actualizarIncidencia(Long id, Incidencia nueva) {
        return repo.findById(id).map(incidencia -> {
            incidencia.setDescripcion(nueva.getDescripcion());
            incidencia.setCategoria(nueva.getCategoria());
            incidencia.setPrioridad(nueva.getPrioridad());
            incidencia.setEstado(nueva.getEstado());
            return repo.save(incidencia);
        }).orElse(null);
    }

    public void eliminarIncidencia(Long id) {
        repo.deleteById(id);
    }
}


