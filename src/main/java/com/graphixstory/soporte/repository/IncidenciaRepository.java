package com.graphixstory.soporte.repository;

import com.graphixstory.soporte.model.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
    // Puedes agregar métodos de búsqueda con filtros más adelante si deseas
}

