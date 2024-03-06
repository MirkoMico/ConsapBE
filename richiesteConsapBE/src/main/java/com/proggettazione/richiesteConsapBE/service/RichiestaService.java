package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.dto.richiesteDto;
import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.model.StatoApprovazione;

import java.util.List;

public interface RichiestaService {

    Richiesta saveRichiesta(Richiesta richiesta);
    List<Richiesta> getRichieste();
    Richiesta getRichiesta(int id);
    Richiesta putRichiesta(Richiesta richiesta,int id);

}
