package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.CommessaOs;
import com.proggettazione.richiesteConsapBE.model.Richiesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommessaOsRepository extends JpaRepository<CommessaOs, Integer> {
    CommessaOs deleteById(int idCommessaOs);


}
