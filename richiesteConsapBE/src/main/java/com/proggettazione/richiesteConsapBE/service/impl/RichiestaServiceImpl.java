package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.*;
import com.proggettazione.richiesteConsapBE.repository.*;
import com.proggettazione.richiesteConsapBE.service.RichiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class RichiestaServiceImpl implements RichiestaService {

    @Autowired
    RichiestaRepository richiestaRepository;

    @Autowired
    StatoRichiestaConsapRepository statoRichiestaConsapRepository;
    @Autowired
    StatoApprovazioneConsapRepository statoApprovazioneConsapRepository;

    @Autowired
    UtenteServiceImpl utenteServiceImpl;
    @Autowired
    ApplicativoRepository applicativoRepository;
    @Autowired
    StatoApprovazioneOsRepository statoApprovazioneOsRepository;
    @Autowired
    StatoRichiestaOsRepository statoRichiestaOsRepository;
    @Autowired
    CommessaOsRepository commessaOsRepository;


    @Override
    public Richiesta saveRichiesta(Richiesta richiesta) {
            Richiesta nuovaRichiesta = new Richiesta(
            );
        Applicativo applicativo = applicativoRepository.findById(richiesta.getApplicativo().getApplicativoId())
                .orElse(null);
        StatoRichiestaConsap statoRichiestaConsap= statoRichiestaConsapRepository.
                findById(richiesta.getStatoRichiestaConsap().getStatoRichiestaConsapId())
                .orElse(null);
        StatoApprovazioneConsap statoApprovazioneConsap=statoApprovazioneConsapRepository.
                findById(richiesta.getStatoApprovazioneConsap().getStatoApprovazioneConsapId())
                .orElse(null);
        StatoApprovazioneOs statoApprovazioneOs=statoApprovazioneOsRepository.
                findById(richiesta.getStatoApprovazioneOs().getStatoApprovazioneOsId())
                .orElse(null);
        StatoRichiestaOs statoRichiestaOs=statoRichiestaOsRepository.
                findById(richiesta.getStatoRichiestaOs().getStatoRichiestaOsId())
                .orElse(null);
        CommessaOs commessaOs=commessaOsRepository.findById(richiesta.getCommessaOs().getCommessaOsId())
                .orElse(null);

        nuovaRichiesta.setNumeroTicket(richiesta.getNumeroTicket());
        nuovaRichiesta.setApplicativo(applicativo);
        nuovaRichiesta.setOggetto(richiesta.getOggetto());
        nuovaRichiesta.setStatoRichiestaConsap(statoRichiestaConsap);
        nuovaRichiesta.setDataCreazione(richiesta.getDataCreazione());
        nuovaRichiesta.setStatoApprovazioneConsap(statoApprovazioneConsap);
        nuovaRichiesta.setStatoApprovazioneOs(statoApprovazioneOs);
        nuovaRichiesta.setStatoRichiestaOs(statoRichiestaOs);
        nuovaRichiesta.setDataStimaFine(richiesta.getDataStimaFine());
        nuovaRichiesta.setImporto(richiesta.getImporto());
        nuovaRichiesta.setCommessaOs(commessaOs);

        return richiestaRepository.save(nuovaRichiesta);
    }

    @Override
    public List<Richiesta> getRichieste() {
        return richiestaRepository.findAll();
    }

    @Override
    public Optional<Richiesta> getRichiestaById(int id)throws Exception {

        Optional<Richiesta> optionalRichiesta = richiestaRepository.findById(id);
        if (optionalRichiesta.isEmpty()){
            throw new Exception("La richiesta n: " + id + "non è stata trovata");
        }
        return optionalRichiesta;


    }



    @Override
    public Richiesta putRichiesta(Richiesta richiesta, int id) {

        Richiesta richiesta1 = richiestaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Richiesta non trovata con ID: " + id));
       // richiesta1.setNumeroTicket(richiesta.getNumeroTicket());
        richiesta1.setApplicativo(richiesta.getApplicativo());
       // richiesta1.setOggetto(richiesta.getOggetto());
        richiesta1.setStatoRichiestaConsap(richiesta.getStatoRichiestaConsap());
      //  richiesta1.setDataCreazione(richiesta.getDataCreazione());
        richiesta1.setStatoApprovazioneConsap(richiesta.getStatoApprovazioneConsap());
        richiesta1.setStatoApprovazioneOs(richiesta.getStatoApprovazioneOs());
        richiesta1.setStatoRichiestaOs(richiesta.getStatoRichiestaOs());
        richiesta1.setDataStimaFine(richiesta.getDataStimaFine());
        richiesta1.setImporto(richiesta.getImporto());
        richiesta1.setCommessaOs(richiesta.getCommessaOs());

        richiestaRepository.save(richiesta1);
        return richiesta1;
    }

    @Override
    public Richiesta deleteRichiestaById(int id) {
        return richiestaRepository.deleteById(id);
    }

    @Override
    public List<Richiesta> getAllRichiestaByCommeaaOsId(int commessaOsId)throws  Exception {
        List<Richiesta> optionalList = richiestaRepository.findAllByCommessaIdCustomQ(commessaOsId);
        if (optionalList.isEmpty()) {
            throw new Exception("commessa non trovata");
        }
       // logger.info("Slot found");
        return optionalList;


    }

    @Override
    public List<Richiesta> getAllRichiestaByApplicativoId(int applicativoId) throws Exception {
        List<Richiesta> optionalListAppl= richiestaRepository.findAllByApplicativoCustomQ(applicativoId);
        if (optionalListAppl.isEmpty()) {
            throw new Exception("applicativo non trovato");
        }
        return optionalListAppl;
    }

    @Override
    public Optional<Richiesta> getRichiestaByNumeroTicket(int numeroTicket) throws Exception {

        Optional<Richiesta> optionalRichiesta = richiestaRepository.findByNumeroTicket(numeroTicket);
        if (optionalRichiesta.isEmpty()) {
            throw new Exception("Il numero ticket : " + numeroTicket + "non è stato trovato");

        }
        return optionalRichiesta;
    }







    }
