package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.model.Stato;
import com.proggettazione.richiesteConsapBE.repository.RichiestaRepository;
import com.proggettazione.richiesteConsapBE.repository.StatoRepository;
import com.proggettazione.richiesteConsapBE.service.RichiestaService;
import com.proggettazione.richiesteConsapBE.service.StatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StatoServiceImpl implements StatoService {



    @Autowired
    RichiestaRepository richiestaRepository;

    @Autowired
    StatoRepository statoRepository;
    @Override
    public List<Stato> getStati() {
        return statoRepository.findAll();
    }

    @Override
    public Stato saveStato(Stato stato) {
        return statoRepository.save(stato);
    }
/*
    @Override
    public Stato getIdStatoByRichiesta(Richiesta richiesta) {
        Optional<Richiesta> optionalRichiesta = richiestaRepository.findById(richiesta.getId());


        if (optionalRichiesta.isPresent()) {
            Richiesta nuovaRichiesta = optionalRichiesta.get();
            nuovaRichiesta.setStato(richiesta.getStato());
            return nuovaRichiesta.getStato();
        } else {
            // Gestisci il caso in cui la richiesta non esiste nel database
            return null; // o altra logica di gestione dell'errore
        }
    }
    */
@Override
public Stato getIdStatoByRichiesta(Richiesta richiesta) {
    int statoId = richiesta.getStato().getId(); // Recupera l'ID dello stato dal JSON
    Optional<Stato> optionalStato = statoRepository.findById(statoId); // Cerca lo stato nel database utilizzando l'ID

    if (optionalStato.isPresent()) {
        return optionalStato.get(); // Restituisci lo stato trovato
    } else {
        // Gestisci il caso in cui lo stato non esiste nel database
        return null; // o altra logica di gestione dell'errore
    }
}



}