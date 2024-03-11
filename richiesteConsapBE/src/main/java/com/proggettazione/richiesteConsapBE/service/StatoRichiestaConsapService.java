package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.model.StatoRichiestaConsap;

import java.util.List;

public interface StatoRichiestaConsapService {

    StatoRichiestaConsap saveStato(StatoRichiestaConsap statoRichiestaConsap);

    List<StatoRichiestaConsap> getAllStatoRichiestaConsap();

}
