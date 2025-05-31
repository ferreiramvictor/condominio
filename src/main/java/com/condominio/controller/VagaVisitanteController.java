package com.condominio.controller;

import com.condominio.model.VagaVisitante;
import com.condominio.repository.VagaVisitanteRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vagas-visitantes")
@CrossOrigin(origins = "*")
public class VagaVisitanteController {
    
    private final VagaVisitanteRepository repository;
    
    public VagaVisitanteController(VagaVisitanteRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/disponiveis")
    public ResponseEntity<List<VagaVisitante>> getVagasDisponiveis(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        
        List<VagaVisitante> vagas = repository.findDisponiveisByData(data);
        return ResponseEntity.ok(vagas);
    }
    
    @GetMapping("/periodo")
    public ResponseEntity<List<VagaVisitante>> getVagasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {
        
        List<VagaVisitante> vagas = repository.findByDataBetween(inicio, fim);
        return ResponseEntity.ok(vagas);
    }
}