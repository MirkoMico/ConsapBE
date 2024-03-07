package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneOs;
import com.proggettazione.richiesteConsapBE.repository.StatoApprovazioneOsRepository;
import com.proggettazione.richiesteConsapBE.service.StatoApprovazioneOsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatoApprovazioneOsServiceImpl implements StatoApprovazioneOsService {

    @Autowired
    StatoApprovazioneOsRepository statoApprovazioneOsRepository;
    @Override
    public StatoApprovazioneOs saveStatoApprovazioneOs(StatoApprovazioneOs statoApprovazioneOs) {
        return statoApprovazioneOsRepository.save(statoApprovazioneOs);
    }
}
