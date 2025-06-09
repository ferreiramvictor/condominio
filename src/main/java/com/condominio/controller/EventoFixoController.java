package com.condominio.controller;

import com.condominio.model.EventoFixo;
import com.condominio.repository.EventoFixoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/eventos-fixos")
@CrossOrigin(origins = "*")
public class EventoFixoController {

    @Autowired
    private EventoFixoRepository eventoFixoRepository;

    @GetMapping
    public ResponseEntity<List<EventoFixo>> listarEventos() {
        List<EventoFixo> eventos = eventoFixoRepository.findAll();
        return ResponseEntity.ok(eventos);
    }
}