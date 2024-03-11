package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaConsap;
import com.proggettazione.richiesteConsapBE.repository.RichiestaRepository;
import com.proggettazione.richiesteConsapBE.repository.StatoRichiestaConsapRepository;
import com.proggettazione.richiesteConsapBE.service.StatoRichiestaConsapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatoRichiestaConsapServiceImpl implements StatoRichiestaConsapService {



    @Autowired
    RichiestaRepository richiestaRepository;

    @Autowired
    StatoRichiestaConsapRepository statoRichiestaConsapRepository;

    @Override
    public StatoRichiestaConsap saveStato(StatoRichiestaConsap statoRichiestaConsap) {
        return statoRichiestaConsapRepository.save(statoRichiestaConsap);
    }

    @Override
    public List<StatoRichiestaConsap> getAllStatoRichiestaConsap() {
        return statoRichiestaConsapRepository.findAll();
    }
  /*  @Override
    public List<StatoRichiestaConsap> getStati() {
        return statoRepository.findAll();
    }

    @Override
    public StatoRichiestaConsap saveStato(StatoRichiestaConsap statoRichiestaConsap) {
        return statoRepository.save(statoRichiestaConsap);
    }*/
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
    /*
@Override
public StatoRichiestaConsap getIdStatoByRichiesta(Richiesta richiesta) {
    int statoId = richiesta.getStatoRichiestaConsap().getId(); // Recupera l'ID dello stato dal JSON
    Optional<StatoRichiestaConsap> optionalStato = statoRepository.findById(statoId); // Cerca lo stato nel database utilizzando l'ID

    if (optionalStato.isPresent()) {
        return optionalStato.get(); // Restituisci lo stato trovato
    } else {
        // Gestisci il caso in cui lo stato non esiste nel database
        return null; // o altra logica di gestione dell'errore
    }*/
}



