package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RichiestaService {

    Richiesta saveRichiesta(Richiesta richiesta);
    Page<Richiesta> getRichieste(Pageable pageable);
    Optional<Richiesta> getRichiestaById(int id) throws Exception;
    Richiesta putRichiesta(Richiesta richiesta,int id);
    Richiesta deleteRichiestaById(int id);

    List<Richiesta> getAllRichiestaByCommeaaOsId(int commessaOsId) throws Exception;

    List<Richiesta> getAllRichiestaByApplicativoId(int applicativoId) throws Exception;

    Optional<Richiesta> getRichiestaByNumeroTicket(int numeroTicket) throws Exception;



}
