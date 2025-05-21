package com.condominio.controller;

import com.condominio.model.Reserva;
import com.condominio.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping
    public ResponseEntity<?> criarReserva(@RequestBody Reserva reserva) {
        reserva.setStatus("Pendente");
        reservaRepository.save(reserva);
        return ResponseEntity.ok("Reserva solicitada!");
    }
}