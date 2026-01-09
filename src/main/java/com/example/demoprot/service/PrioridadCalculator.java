package com.example.demoprot.service;

import com.example.demoprot.model.Solicitud;
import com.example.demoprot.model.TipoSolicitud;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class PrioridadCalculator {

    public double calcularScore(Solicitud solicitud) {
        double score = 0;

        // 1. Base Score by Type
        switch (solicitud.getTipo()) {
            case INCIDENTE -> score += 1000;
            case REQUERIMIENTO -> score += 500;
            case CONSULTA -> score += 100;
        }

        // 2. Manual Priority (1-5)
        score += (solicitud.getPrioridadManual() * 10);

        // 3. Aging (Time Factor)
        long horasEsperando = Duration.between(solicitud.getFechaCreacion(), LocalDateTime.now()).toHours();
        score += horasEsperando;

        return score;
    }
}