package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaConsap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoRichiestaConsapRepository extends JpaRepository<StatoRichiestaConsap,Integer> {
}
