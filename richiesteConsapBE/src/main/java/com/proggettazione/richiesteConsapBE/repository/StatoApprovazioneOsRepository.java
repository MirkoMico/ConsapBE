package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneOs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoApprovazioneOsRepository extends JpaRepository<StatoApprovazioneOs, Integer> {
}
