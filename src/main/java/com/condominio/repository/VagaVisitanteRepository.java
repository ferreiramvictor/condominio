package com.condominio.repository;

import com.condominio.model.VagaVisitante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface VagaVisitanteRepository extends JpaRepository<VagaVisitante, Long> {
    List<VagaVisitante> findByDataInicioBetween(LocalDate inicio, LocalDate fim);
    VagaVisitante findBySemana(int semana);
}