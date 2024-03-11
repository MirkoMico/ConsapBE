package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RichiestaRepository extends JpaRepository<Richiesta,Integer> {
    Optional<Richiesta> findByNumeroTicket(int numeroTicket);

    Richiesta deleteById(int id);
//select u from User u where u.emailAddress = ?1
    @Query("SELECT r FROM Richiesta r WHERE r.commessaOs.commessaOsId = :commessaOsId "  )
    List<Richiesta> findAllByCommessaIdCustomQ(@Param("commessaOsId")int commessaOsId);

    @Query("SELECT r FROM Richiesta r WHERE r.applicativo.applicativoId = :applicativoId")
    List<Richiesta> findAllByApplicativoCustomQ(@Param("applicativoId")int applicativoId);


    // List<Richiesta> findByCommessaId(int commessaOsId);

   
}
