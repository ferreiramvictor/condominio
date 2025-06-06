package com.condominio.repository;

import com.condominio.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
	Morador findByLoginAndSenha(String login, String senha); // Para login
    Morador findByLogin(String login); // Para validação de cadastro
    
        
    
    
}