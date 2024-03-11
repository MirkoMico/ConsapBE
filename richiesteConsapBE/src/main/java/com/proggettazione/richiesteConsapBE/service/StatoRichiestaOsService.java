package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaConsap;
import com.proggettazione.richiesteConsapBE.model.StatoRichiestaOs;

import java.util.List;

public interface StatoRichiestaOsService {

    StatoRichiestaOs saveStatoRichiestaOs(StatoRichiestaOs statoRichiestaOs);

    List<StatoRichiestaOs> getAllStatoRichiestaOs();
}
