package com.condominio.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.condominio.model.Reserva;
import com.condominio.repository.ReservaRepository;

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

@GetMapping("/disponibilidade")
public ResponseEntity<List<Reserva>> getDisponibilidade(
    @RequestParam String espaco,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
    
    // Retorna todas as reservas para o espaço e data especificados
    List<Reserva> reservas = reservaRepository.findByEspacoAndData(espaco, data);
    return ResponseEntity.ok(reservas);
}
}