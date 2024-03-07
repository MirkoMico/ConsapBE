package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.CommessaOs;
import com.proggettazione.richiesteConsapBE.repository.CommessaOsRepository;
import com.proggettazione.richiesteConsapBE.service.CommessaOsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommessaOsServiceImpl implements CommessaOsService {

    @Autowired
    CommessaOsRepository commessaOsRepository;
    @Override
    public CommessaOs saveCommessaOs(CommessaOs commessaOs) {
        return commessaOsRepository.save(commessaOs);
    }

    @Override
    public List<CommessaOs> getCommessaOs() {
        return commessaOsRepository.findAll();
    }

    @Override
    public CommessaOs putCommessaOs(int idCommessaOs, CommessaOs commessaOs) {
        CommessaOs newCommessaOs= commessaOsRepository.findById(idCommessaOs)
                .orElseThrow(()-> new NoSuchElementException("Commessa non trovata" + idCommessaOs));
        newCommessaOs.setDescCommessaOS(commessaOs.getDescCommessaOS());
        return newCommessaOs;
    }

    @Override
    public CommessaOs deleteByIDCommessaOs(int idCommessaOs) {
        return commessaOsRepository.deleteById(idCommessaOs);
    }


}
