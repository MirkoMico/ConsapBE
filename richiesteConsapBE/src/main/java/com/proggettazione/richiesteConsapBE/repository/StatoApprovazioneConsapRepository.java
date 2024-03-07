package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneConsap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoApprovazioneConsapRepository extends JpaRepository<StatoApprovazioneConsap,Integer> {
}
