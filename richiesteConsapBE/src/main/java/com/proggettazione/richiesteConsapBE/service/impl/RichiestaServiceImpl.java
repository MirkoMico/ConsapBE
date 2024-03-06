package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.dto.richiesteDto;
import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.model.Stato;
import com.proggettazione.richiesteConsapBE.model.StatoApprovazione;
import com.proggettazione.richiesteConsapBE.repository.RichiestaRepository;
import com.proggettazione.richiesteConsapBE.repository.StatoRepository;
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
    StatoServiceImpl statoServiceImpl;

    @Autowired
    StatoRepository statoRepository;

    @Autowired
    UtenteServiceImpl utenteServiceImpl;

    @Override

    public Richiesta saveRichiesta(Richiesta richiesta) {
        Richiesta nuovaRichiesta = new Richiesta(
        );
        Stato stato = statoRepository.findById(richiesta.getStato().getId())
                .orElse(null);
        nuovaRichiesta.setIdCommessa(richiesta.getIdCommessa());
        nuovaRichiesta.setStato(stato);
        nuovaRichiesta.setDataCreazione(richiesta.getDataCreazione());
        nuovaRichiesta.setOggetto(richiesta.getOggetto());
        nuovaRichiesta.setStatoApprovazione(richiesta.getStatoApprovazione());
        nuovaRichiesta.setCampo1(richiesta.getCampo1());
        nuovaRichiesta.setCampo2(richiesta.getCampo2());
        nuovaRichiesta.setCampo3(richiesta.getCampo3());
        nuovaRichiesta.setCampo4(richiesta.getCampo4());
        nuovaRichiesta.setDataInserimento(richiesta.getDataInserimento());
        nuovaRichiesta.setDataModifica(richiesta.getDataModifica());
        nuovaRichiesta.setUtenteCreazione(richiesta.getUtenteCreazione());
        nuovaRichiesta.setUtenteModifica(richiesta.getUtenteModifica());
        return richiestaRepository.save(nuovaRichiesta);
    }

/*
    @Override
    public Richiesta saveRichieste(richiesteDto richiesteDto) {
        Optional<Stato> optionalStato = statoRepository.findById(richiesteDto.getStatoId());
        if (optionalStato.isEmpty()) {
            return null;
        }
        Richiesta newRichesta = new Richiesta(richiesteDto.getIdCommessa(),
                richiesteDto.getOggetto(), stato, richiesteDto.getDataCreazione(),
                richiesteDto.getStatoApprovazione(), richiesteDto.getNote(),
                richiesteDto.getCampo1(), richiesteDto.getCampo2(), richiesteDto.getCampo3(), richiesteDto.getCampo4(),
                richiesteDto.getUtenteInserimento(), richiesteDto.getDataInserimento(),
                richiesteDto.getUtenteModifica(), richiesteDto.getDataModifica());
        richiestaRepository.save(newRichesta);


        return richiestaRepository.save(newRichesta);
    }
    */

    @Override
    public List<Richiesta> getRichieste() {
        return richiestaRepository.findAll();
    }
    @Override
    public Richiesta getRichiesta(int id) {
        return richiestaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Richiesta non trovata con ID: " + id));
    }
    @Override
    public Richiesta putRichiesta(Richiesta richiesta,int id) {
        Richiesta existingRichiesta = richiestaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Richiesta non trovata con ID: " + id));
        existingRichiesta.setIdCommessa(richiesta.getIdCommessa());
        existingRichiesta.setStato(richiesta.getStato());
        existingRichiesta.setDataCreazione(richiesta.getDataCreazione());
        existingRichiesta.setOggetto(richiesta.getOggetto());
        existingRichiesta.setStatoApprovazione(richiesta.getStatoApprovazione());
        existingRichiesta.setCampo1(richiesta.getCampo1());
        existingRichiesta.setCampo2(richiesta.getCampo2());
        existingRichiesta.setCampo3(richiesta.getCampo3());
        existingRichiesta.setCampo4(richiesta.getCampo4());
        existingRichiesta.setDataInserimento(richiesta.getDataInserimento());
        existingRichiesta.setDataModifica(richiesta.getDataModifica());
        existingRichiesta.setUtenteCreazione(richiesta.getUtenteCreazione());
        existingRichiesta.setUtenteModifica(richiesta.getUtenteModifica());
        richiestaRepository.save(existingRichiesta);
        return existingRichiesta;
    }

}
