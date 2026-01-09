package com.example.demoprot.service;

import com.example.demoprot.model.Solicitud;
import com.example.demoprot.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final SolicitudRepository repository;
    private final PrioridadCalculator calculator;

    // Save a new request
    public Solicitud guardar(Solicitud solicitud) {
        // Validation: Guard Clause
        if (solicitud.getPrioridadManual() < 1 || solicitud.getPrioridadManual() > 5) {
            throw new IllegalArgumentException("La prioridad manual debe estar entre 1 y 5");
        }

        // Validation: Username required
        if (solicitud.getUsuario() == null || solicitud.getUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario es obligatorio");
        }
        return repository.save(solicitud);
    }

    // Get all requests sorted by our special logic
    public List<Solicitud> listarPorPrioridad() {
        return repository.findAll().stream()
                .sorted(Comparator.comparingDouble(calculator::calcularScore).reversed())
                .collect(Collectors.toList());
    }
}