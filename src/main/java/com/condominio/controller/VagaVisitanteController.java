package com.condominio.controller;

import com.condominio.model.VagaVisitante;
import com.condominio.repository.VagaVisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vagas-visitantes")
@CrossOrigin(origins = "https://edificiotexas.github.io")
public class VagaVisitanteController {
    
    @Autowired
    private VagaVisitanteRepository vagaRepository;
    
    @GetMapping("/semana/{semana}")
    public ResponseEntity<VagaVisitante> getPorSemana(@PathVariable int semana) {
        VagaVisitante vaga = vagaRepository.findBySemana(semana);
        if (vaga != null) {
            return ResponseEntity.ok(vaga);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/disponibilidade")
    public ResponseEntity<Map<String, String>> verificarDisponibilidade(
            @RequestParam String apartamento) {
        LocalDate hoje = LocalDate.now();
        List<VagaVisitante> vagas = vagaRepository.findByDataInicioBetween(
            hoje.minusDays(7), hoje.plusDays(7));
        
        for (VagaVisitante vaga : vagas) {
            if (apartamento.equals(vaga.getVaga1())) {
                return ResponseEntity.ok(Map.of(
                    "mensagem", "Você pode usar a Vaga 01 na semana " + vaga.getSemana(),
                    "semana", String.valueOf(vaga.getSemana()),
                    "vaga", "1"));
            }
            if (apartamento.equals(vaga.getVaga2())) {
                return ResponseEntity.ok(Map.of(
                    "mensagem", "Você pode usar a Vaga 02 na semana " + vaga.getSemana(),
                    "semana", String.valueOf(vaga.getSemana()),
                    "vaga", "2"));
            }
        }
        
        return ResponseEntity.ok(Map.of(
            "mensagem", "Não há vagas disponíveis para seu apartamento nas próximas semanas"));
    }
    
    @GetMapping("/por-apartamento/{apartamento}")
    public ResponseEntity<List<VagaVisitante>> getPorApartamento(@PathVariable String apartamento) {
        List<VagaVisitante> vagas = vagaRepository.findByVaga1OrVaga2(apartamento, apartamento);
        return ResponseEntity.ok(vagas);
    }
}