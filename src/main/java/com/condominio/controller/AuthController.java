package com.condominio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominio.model.Morador;
import com.condominio.repository.MoradorRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://ferreiramvictor.github.io") 
public class AuthController {
    
    @Autowired
    private MoradorRepository moradorRepository;
    
 // Conteúdo para modificar em com/condominio/controller/AuthController.java

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Morador morador) {
        Morador moradorExistente = moradorRepository.findByLoginAndSenha(morador.getLogin(), morador.getSenha());
        
        if (moradorExistente != null) {
            
            Map<String, Object> response = new HashMap<>();
            response.put("nome", moradorExistente.getNome());
            response.put("apartamento", moradorExistente.getApartamento());
            response.put("bloco", moradorExistente.getBloco());
            response.put("contato", moradorExistente.getContato());
            response.put("isAdmin", moradorExistente.isAdmin()); 
            
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Login ou senha inválidos.");
        }
    }
    
    @PostMapping("/verificar-login")
    public ResponseEntity<?> verificarLogin(@RequestBody Map<String, String> request) {
        String login = request.get("login");
        Morador moradorExistente = moradorRepository.findByLogin(login);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("existe", moradorExistente != null);
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarMorador(@RequestBody Morador morador) {
        try {
            // Gera o login automaticamente (apartamento + bloco)
            String login = morador.getApartamento() + morador.getBloco();
            morador.setLogin(login);

            // Valida se o login já existe
            if (moradorRepository.findByLogin(login) != null) {
                return ResponseEntity.badRequest().body("Já existe um morador com este apartamento/bloco.");
            }

            // Salva no banco de dados
            moradorRepository.save(morador);
            
            // Retorna os dados do morador (sem senha)
            Map<String, String> response = new HashMap<>();
            response.put("mensagem", "Morador cadastrado com sucesso!");
            response.put("login", login); // Ex: "103A"
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar: " + e.getMessage());
        }
    }
}
