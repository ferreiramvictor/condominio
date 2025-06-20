package com.condominio.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominio.model.Aviso;
import com.condominio.repository.AvisoRepository;

@RestController
@RequestMapping("/api/avisos")
@CrossOrigin(origins = "*")
public class AvisoController {

    @Autowired
    private AvisoRepository avisoRepository;

    @PostMapping
    public ResponseEntity<Aviso> criarAviso(@RequestBody Aviso aviso) {
        aviso.setData(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        Aviso avisoSalvo = avisoRepository.save(aviso);
        return ResponseEntity.ok(avisoSalvo);
    }

    @GetMapping
    public List<Aviso> listarAvisos() {
        return avisoRepository.findAllByOrderByDataDesc();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Aviso> atualizarAviso(
            @PathVariable Long id,
            @RequestBody Aviso avisoAtualizado) {
        
        return avisoRepository.findById(id)
            .map(aviso -> {
                aviso.setTitulo(avisoAtualizado.getTitulo());
                aviso.setMensagem(avisoAtualizado.getMensagem());
                Aviso avisoAtualizadoSalvo = avisoRepository.save(aviso);
                return ResponseEntity.ok(avisoAtualizadoSalvo);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerAviso(@PathVariable Long id) {
        return avisoRepository.findById(id)
            .map(aviso -> {
                avisoRepository.delete(aviso);
                return ResponseEntity.ok().build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}