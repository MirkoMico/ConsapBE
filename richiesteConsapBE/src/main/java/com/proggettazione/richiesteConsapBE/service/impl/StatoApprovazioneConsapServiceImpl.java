package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneConsap;
import com.proggettazione.richiesteConsapBE.repository.StatoApprovazioneConsapRepository;
import com.proggettazione.richiesteConsapBE.service.StatoApprovazioneConsapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatoApprovazioneConsapServiceImpl implements StatoApprovazioneConsapService {

    @Autowired
    StatoApprovazioneConsapRepository statoApprovazioneConsapRepository;
    @Override
    public StatoApprovazioneConsap saveStatoApprovazioneConsap(StatoApprovazioneConsap statoApprovazioneConsap) {
        return statoApprovazioneConsapRepository.save(statoApprovazioneConsap) ;
    }
}
