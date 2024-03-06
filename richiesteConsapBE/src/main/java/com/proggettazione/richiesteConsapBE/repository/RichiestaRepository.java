package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RichiestaRepository extends JpaRepository<Richiesta,Integer> {
    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE richiesta ADD CONSTRAINT stato_approvazione_check CHECK (id_stato BETWEEN 0 AND 3)", nativeQuery = true)
    void addStatoConstraint();

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE richiesta ADD CONSTRAINT stato_approvazione_check CHECK (stato_approvazione BETWEEN 0 AND 3)", nativeQuery = true)
    void addStatoApprovazioneConstraint();
}
