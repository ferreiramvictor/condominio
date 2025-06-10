package com.condominio.controller;

import com.condominio.model.Morador;
import com.condominio.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/moradores")
@CrossOrigin(origins = "*")
public class MoradorController {

    @Autowired
    private MoradorRepository moradorRepository;

    @GetMapping
    public ResponseEntity<?> listarTodosOsMoradores(/*@RequestHeader("Authorization") String token*/) {
        
        List<Morador> moradores = moradorRepository.findAll();
        return ResponseEntity.ok(moradores);
    }
}