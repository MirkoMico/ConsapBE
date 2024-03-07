package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaOs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoRichiestaOsRepository extends JpaRepository<StatoRichiestaOs, Integer> {
}
