package com.example.demoprot.controller;

import com.example.demoprot.model.Solicitud;
import com.example.demoprot.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService service;

    @PostMapping
    public Solicitud crear(@RequestBody Solicitud solicitud) {
        return service.guardar(solicitud);
    }

    @GetMapping
    public List<Solicitud> listar() {
        return service.listarPorPrioridad();
    }
}