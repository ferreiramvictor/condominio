package com.condominio.repository;

import com.condominio.model.VagaVisitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface VagaVisitanteRepository extends JpaRepository<VagaVisitante, Long> {
    List<VagaVisitante> findByDataBetween(LocalDate inicio, LocalDate fim);
    
    @Query("SELECT v FROM VagaVisitante v WHERE v.data = :data AND v.vagasDisponiveis > 0")
    List<VagaVisitante> findDisponiveisByData(LocalDate data);
}