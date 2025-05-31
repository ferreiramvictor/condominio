package com.condominio.repository;

import com.condominio.model.ReservaVisitante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservaVisitanteRepository extends JpaRepository<ReservaVisitante, Long> {
    List<ReservaVisitante> findByMoradorId(Long moradorId);
    boolean existsByVagaIdAndMoradorId(Long vagaId, Long moradorId);
}