package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Richiesta;

import java.util.List;
import java.util.Optional;

public interface RichiestaService {

    Richiesta saveRichiesta(Richiesta richiesta);
    List<Richiesta> getRichieste();
    Optional<Richiesta> getRichiestaById(int id) throws Exception;
    Richiesta putRichiesta(Richiesta richiesta,int id);
    Richiesta deleteRichiestaById(int id);

   // List<Richiesta> getAllRichiestaBynumeroTicket(int numeroTicket);

    Optional<Richiesta> getRichiestaByNumeroTicket(int numeroTicket) throws Exception;



}
