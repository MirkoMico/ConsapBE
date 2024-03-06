package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazione;
import com.proggettazione.richiesteConsapBE.model.Utente;
import com.proggettazione.richiesteConsapBE.repository.UtenteRepository;
import com.proggettazione.richiesteConsapBE.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    UtenteRepository utenteRepository;


    @Override
    public String getCredenziali(String username, String password) {
        return null;
    }

    @Override
    public List<Utente> getUtenti() {
        return utenteRepository.findAll();
    }

    @Override
    public Utente saveUtente(Utente utente) {
        return utenteRepository.save(utente);
    }
    @Override
    public int setStatoApprovazione(String statoApprovazione) {
        switch (statoApprovazione){
            case "PENDING_APPROVAL":
                return StatoApprovazione.PENDIG_APPROVAL.ordinal();
            case "APPROVED":
                return StatoApprovazione.APPROVED.ordinal();
            default:
                return -1;
        }
    }

}
