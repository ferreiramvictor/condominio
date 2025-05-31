package com.condominio.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominio.model.ReservaVisitante;
import com.condominio.model.VagaVisitante;
import com.condominio.repository.ReservaVisitanteRepository;
import com.condominio.repository.VagaVisitanteRepository;

@RestController
@RequestMapping("/api/reservas-visitantes")
@CrossOrigin(origins = "*")
public class ReservaVisitanteController {
    
    private final ReservaVisitanteRepository reservaRepository;
    private final VagaVisitanteRepository vagaRepository;
    
    public ReservaVisitanteController(ReservaVisitanteRepository reservaRepository,
                                    VagaVisitanteRepository vagaRepository) {
        this.reservaRepository = reservaRepository;
        this.vagaRepository = vagaRepository;
    }
    
    @PostMapping
    public ResponseEntity<?> criarReserva(@RequestBody ReservaVisitante reserva) {
        // Verifica se ainda há vagas disponíveis
        VagaVisitante vaga = vagaRepository.findById(reserva.getVaga().getId())
            .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        
        if (vaga.getVagasDisponiveis() <= 0) {
            return ResponseEntity.badRequest().body("Não há vagas disponíveis para este horário");
        }
        
        // Atualiza vagas disponíveis
        vaga.setVagasDisponiveis(vaga.getVagasDisponiveis() - 1);
        vagaRepository.save(vaga);
        
        // Cria a reserva
        reserva.setDataReserva(LocalDateTime.now());
        reserva.setStatus("CONFIRMADA");
        reservaRepository.save(reserva);
        
        return ResponseEntity.ok(reserva);
    }
    
    @GetMapping("/morador/{moradorId}")
    public ResponseEntity<List<ReservaVisitante>> getReservasPorMorador(@PathVariable Long moradorId) {
        List<ReservaVisitante> reservas = reservaRepository.findByMoradorId(moradorId);
        return ResponseEntity.ok(reservas);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelarReserva(@PathVariable Long id) {
        ReservaVisitante reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        
        // Libera a vaga
        VagaVisitante vaga = reserva.getVaga();
        vaga.setVagasDisponiveis(vaga.getVagasDisponiveis() + 1);
        vagaRepository.save(vaga);
        
        // Cancela a reserva
        reserva.setStatus("CANCELADA");
        reservaRepository.save(reserva);
        
        return ResponseEntity.ok().build();
    }
}