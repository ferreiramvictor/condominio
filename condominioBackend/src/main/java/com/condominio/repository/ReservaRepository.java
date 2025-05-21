package com.condominio.repository;

import com.condominio.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Métodos customizados (se necessário)
}