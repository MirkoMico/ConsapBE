package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RichiestaRepository extends JpaRepository<Richiesta,Integer> {
    Optional<Richiesta> findByNumeroTicket(int numeroTicket);

    Richiesta deleteById(int id);

    // List<Richiesta> findByCommessaId(int commessaOsId);

   
}
