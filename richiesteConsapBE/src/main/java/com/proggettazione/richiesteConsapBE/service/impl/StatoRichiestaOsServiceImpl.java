package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaOs;
import com.proggettazione.richiesteConsapBE.repository.StatoRichiestaOsRepository;
import com.proggettazione.richiesteConsapBE.service.StatoRichiestaOsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatoRichiestaOsServiceImpl implements StatoRichiestaOsService {

    @Autowired
    StatoRichiestaOsRepository statoRichiestaOsRepository;
    @Override
    public StatoRichiestaOs saveStatoRichiestaOs(StatoRichiestaOs statoRichiestaOs) {
        return statoRichiestaOsRepository.save(statoRichiestaOs);
    }
}
