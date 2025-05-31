package com.condominio.repository;

import com.condominio.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByEspacoAndData(String espaco, LocalDate data);
}