package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.model.Stato;

import java.util.List;

public interface StatoService {
    List<Stato> getStati();
    Stato saveStato(Stato stato);
    Stato getIdStatoByRichiesta(Richiesta richiesta);
}
