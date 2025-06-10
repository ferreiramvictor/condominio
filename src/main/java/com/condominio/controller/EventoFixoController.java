package com.condominio.controller;

import com.condominio.model.EventoFixo;
import com.condominio.repository.EventoFixoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos-fixos")
@CrossOrigin(origins = "https://edificiotexas.github.io")
public class EventoFixoController {

    @Autowired
    private EventoFixoRepository eventoFixoRepository;

    // GET - Listar todos os eventos (já implementado)
    @GetMapping
    public ResponseEntity<List<EventoFixo>> listarEventos() {
        List<EventoFixo> eventos = eventoFixoRepository.findAll();
        return ResponseEntity.ok(eventos);
    }

    // POST - Criar um novo evento
    @PostMapping
    public ResponseEntity<EventoFixo> criarEvento(@RequestBody EventoFixo evento) {
        // Em uma aplicação real, aqui haveria validação do token de admin
        EventoFixo novoEvento = eventoFixoRepository.save(evento);
        return ResponseEntity.ok(novoEvento);
    }

    // PUT - Atualizar um evento existente
    @PutMapping("/{id}")
    public ResponseEntity<EventoFixo> atualizarEvento(@PathVariable Long id, @RequestBody EventoFixo dadosEvento) {
        return eventoFixoRepository.findById(id)
            .map(eventoExistente -> {
                eventoExistente.setTitulo(dadosEvento.getTitulo());
                eventoExistente.setDias(dadosEvento.getDias());
                eventoExistente.setHorario(dadosEvento.getHorario());
                eventoExistente.setCategoria(dadosEvento.getCategoria());
                EventoFixo eventoAtualizado = eventoFixoRepository.save(eventoExistente);
                return ResponseEntity.ok(eventoAtualizado);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE - Excluir um evento
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEvento(@PathVariable Long id) {
        return eventoFixoRepository.findById(id)
            .map(evento -> {
                eventoFixoRepository.delete(evento);
                return ResponseEntity.ok().build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}