package com.graphixstory.soporte.controller;

import com.graphixstory.soporte.model.Incidencia;
import com.graphixstory.soporte.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {
    @Autowired
    private IncidenciaService servicio;

    @PostMapping
    public Incidencia crear(@RequestBody Incidencia i) {
        return servicio.crearIncidencia(i);
    }

    @GetMapping
    public List<Incidencia> listar() {
        return servicio.listarIncidencias();
    }

    @GetMapping("/{id}")
    public Incidencia obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Incidencia actualizar(@PathVariable Long id, @RequestBody Incidencia i) {
        return servicio.actualizarIncidencia(id, i);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminarIncidencia(id);
    }
}
