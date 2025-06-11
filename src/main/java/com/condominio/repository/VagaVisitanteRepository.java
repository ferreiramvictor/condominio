package com.condominio.repository;

import com.condominio.model.VagaVisitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface VagaVisitanteRepository extends JpaRepository<VagaVisitante, Long> {
    List<VagaVisitante> findByDataInicioBetween(LocalDate inicio, LocalDate fim);
    VagaVisitante findBySemana(int semana);
    
    List<VagaVisitante> findByVaga1OrVaga2(String vaga1, String vaga2);
    
    List<VagaVisitante> findAllByOrderByDataInicioAsc();
   
}